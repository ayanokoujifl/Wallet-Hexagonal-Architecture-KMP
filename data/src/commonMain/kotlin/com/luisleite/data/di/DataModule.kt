package com.luisleite.data.di

import com.luisleite.data.local.ArchitectureSampleDatabase
import com.luisleite.data.repository.WalletRepositoryImpl
import com.luisleite.domain.repository.WalletRepository
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

expect val driverModule: Module
val dataModule = module {
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

    includes(driverModule)

    single {
        ArchitectureSampleDatabase(get())
    }

    single<WalletRepository> {
        WalletRepositoryImpl(client = get(), db = get())
    }
}