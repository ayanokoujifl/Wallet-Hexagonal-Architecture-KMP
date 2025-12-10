package com.luisleite.domain.repository

import com.luisleite.domain.model.Wallet

interface WalletRepository {
    suspend fun createWallet(userId: String): Wallet
}