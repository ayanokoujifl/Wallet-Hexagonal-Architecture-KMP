package com.luisleite.wallet_kmp.domain.usecase

import com.luisleite.wallet_kmp.domain.exception.DomainException
import com.luisleite.wallet_kmp.domain.model.Wallet
import com.luisleite.wallet_kmp.domain.repository.WalletRepository

class CreateWalletUseCase(private val repository: WalletRepository) {
    suspend operator fun invoke(userId: String): Result<Wallet> {
        return try {
            if (userId.isBlank()) {
                throw DomainException("User ID cannot be blank")
            }
            val wallet = repository.createWallet(userId)
            Result.success(wallet)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}