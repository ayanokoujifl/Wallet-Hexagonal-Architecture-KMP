package com.luisleite.usecase

import com.luisleite.exception.DomainException
import com.luisleite.model.Wallet
import com.luisleite.repository.WalletRepository

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