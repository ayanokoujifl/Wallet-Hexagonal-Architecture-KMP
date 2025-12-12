package com.luisleite.wallet_kmp.di

import com.luisleite.data.di.dataModule
import com.luisleite.domain.usecase.CreateWalletUseCase
import com.luisleite.feature.wallet.di.walletFeatureModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val domainModule = module {
    factory { CreateWalletUseCase(repository = get()) }
}

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(dataModule, domainModule, walletFeatureModel)
}