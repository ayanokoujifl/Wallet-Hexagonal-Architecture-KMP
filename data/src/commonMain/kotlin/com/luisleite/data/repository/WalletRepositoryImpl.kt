package com.luisleite.data.repository

import com.luisleite.data.local.ArchitectureSampleDatabase
import com.luisleite.data.local.mapper.toDomain
import com.luisleite.data.remote.dto.CreateWalletRequestDto
import com.luisleite.data.remote.dto.WalletResponseDto
import com.luisleite.domain.model.Wallet
import com.luisleite.domain.repository.WalletRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class WalletRepositoryImpl(private val client: HttpClient, private val db: ArchitectureSampleDatabase) :
    WalletRepository {
    private val baseUrl = "http://10.0.2.2:8080"

    override fun createWallet(userId: String): Flow<Wallet> = flow {
        val localWallet = db.walletQueries.findByUserId(userId).executeAsOneOrNull()
        if (localWallet != null) {
            emit(localWallet.toDomain())
        }
        try {
            val responseDto = client.post("$baseUrl/wallets") {
                contentType(ContentType.Application.Json)
                setBody(CreateWalletRequestDto(userId = userId))
            }.body<WalletResponseDto>()
            db.walletQueries.insertOrReplace(
                id = responseDto.id,
                userId = responseDto.userId,
                balance = responseDto.balance,
                active = if (responseDto.active) 1L else 0L
            )
            val localUpdateWallet = db.walletQueries.findByUserId(userId).executeAsOne()
            emit(localUpdateWallet.toDomain())
        } catch (e: Exception) {
            if (localWallet != null) {
                println("ERRO DE REDE: ${e.message}")
            } else {
                throw e
            }
        }
    }.flowOn(Dispatchers.IO)

}