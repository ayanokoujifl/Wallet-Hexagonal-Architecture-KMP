package com.luisleite.wallet_kmp.domain.repository

import com.luisleite.wallet_kmp.domain.model.Wallet

interface WalletRepository {
    suspend fun createWallet(userId: String): Wallet
}