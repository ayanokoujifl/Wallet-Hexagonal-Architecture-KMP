package com.luisleite.repository

import com.luisleite.model.Wallet

interface WalletRepository {
    suspend fun createWallet(userId: String): Wallet
}