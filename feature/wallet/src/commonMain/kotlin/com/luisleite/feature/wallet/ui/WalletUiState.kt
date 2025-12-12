package com.luisleite.feature.wallet.ui

import com.luisleite.domain.model.Wallet

data class WalletUiState(
    val isLoading: Boolean = false,
    val wallet: Wallet? = null,
    var error: String? = null
)