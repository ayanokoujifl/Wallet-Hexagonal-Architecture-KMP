package com.luisleite.feature.wallet.di

import com.luisleite.feature.wallet.ui.WalletViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val walletFeatureModel = module {
    viewModel { WalletViewModel(createWalletUseCase = get()) }
}