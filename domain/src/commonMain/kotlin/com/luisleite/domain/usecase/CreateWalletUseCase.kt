package com.luisleite.domain.usecase

import com.luisleite.domain.exception.DomainException
import com.luisleite.domain.model.Wallet
import com.luisleite.domain.repository.WalletRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow

class CreateWalletUseCase(private val repository: WalletRepository) {
    operator fun invoke(userId: String): Flow<Wallet> = flow {
        if (userId.isBlank()) {
            throw DomainException("User ID cannot be blank")
        }
         emitAll(repository.createWallet(userId))
    }
}