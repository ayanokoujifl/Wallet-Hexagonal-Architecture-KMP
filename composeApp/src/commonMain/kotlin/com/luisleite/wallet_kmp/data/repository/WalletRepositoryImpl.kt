package com.luisleite.wallet_kmp.data.repository

import com.luisleite.wallet_kmp.data.remote.dto.CreateWalletRequestDto
import com.luisleite.wallet_kmp.data.remote.dto.WalletResponseDto
import com.luisleite.wallet_kmp.data.remote.mapper.toDomain
import com.luisleite.wallet_kmp.domain.model.Wallet
import com.luisleite.wallet_kmp.domain.repository.WalletRepository
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*


class WalletRepositoryImpl(private val client: HttpClient) : WalletRepository {
    private val baseUrl = "http://localhost:10.0.2.2:8080"

    override suspend fun createWallet(userId: String): Wallet {
        val responseDto = client.post("$baseUrl/carteiras") {
            contentType(ContentType.Application.Json)
            setBody(CreateWalletRequestDto(userId = userId))
        }.body<WalletResponseDto>()
        return responseDto.toDomain()
    }

}