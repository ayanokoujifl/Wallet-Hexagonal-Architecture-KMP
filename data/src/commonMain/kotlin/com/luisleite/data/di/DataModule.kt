package com.luisleite.data.di

import com.luisleite.data.local.ArchitectureSampleDatabase
import com.luisleite.data.local.DatabaseDriverFactory
import com.luisleite.data.repository.WalletRepositoryImpl
import com.luisleite.domain.repository.WalletRepository
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

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

    single { get<DatabaseDriverFactory>().createDriver() }

    single {
        ArchitectureSampleDatabase(get())
    }

    single<WalletRepository> {
        WalletRepositoryImpl(client = get(), db = get())
    }
}