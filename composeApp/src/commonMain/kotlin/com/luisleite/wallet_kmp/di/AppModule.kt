package com.luisleite.wallet_kmp.di

import com.luisleite.wallet_kmp.data.repository.WalletRepositoryImpl
import com.luisleite.wallet_kmp.domain.repository.WalletRepository
import com.luisleite.wallet_kmp.domain.usecase.CreateWalletUseCase
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                })
            }
        }
    }

    single<WalletRepository> {
        WalletRepositoryImpl(client = get())
    }

    factory {
        CreateWalletUseCase(repository = get())
    }
}