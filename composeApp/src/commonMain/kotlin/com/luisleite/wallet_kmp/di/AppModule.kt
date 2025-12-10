package com.luisleite.wallet_kmp.di

import com.luisleite.data.di.dataModule
import com.luisleite.domain.usecase.CreateWalletUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.module

val domainModule = module {
    factory { CreateWalletUseCase(repository = get()) }
}

fun initKoin() = startKoin {
    modules(dataModule, domainModule)
}