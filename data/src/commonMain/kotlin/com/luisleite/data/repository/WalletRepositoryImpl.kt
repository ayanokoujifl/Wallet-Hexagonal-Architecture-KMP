package com.luisleite.data.repository

import com.luisleite.data.local.ArchitectureSampleDatabase
import com.luisleite.data.remote.dto.CreateWalletRequestDto
import com.luisleite.data.remote.dto.WalletResponseDto
import com.luisleite.data.remote.mapper.toDomain
import com.luisleite.domain.model.Wallet
import com.luisleite.domain.repository.WalletRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*

class WalletRepositoryImpl(private val client: HttpClient, private val db: ArchitectureSampleDatabase) :
    WalletRepository {
    private val baseUrl = "http://localhost:10.0.2.2:8080"

    override suspend fun createWallet(userId: String): Wallet {
        val responseDto = client.post("$baseUrl/carteiras") {
            contentType(ContentType.Application.Json)
            setBody(CreateWalletRequestDto(userId = userId))
        }.body<WalletResponseDto>()
        return responseDto.toDomain()
    }

}