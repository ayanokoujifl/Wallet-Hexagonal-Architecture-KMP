package com.luisleite.domain.repository

import com.luisleite.domain.model.Wallet
import kotlinx.coroutines.flow.Flow

interface WalletRepository {
    fun createWallet(userId: String): Flow<Wallet>
}