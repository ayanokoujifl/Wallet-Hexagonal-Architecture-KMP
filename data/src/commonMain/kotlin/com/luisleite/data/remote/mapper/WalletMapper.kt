package com.luisleite.data.remote.mapper

import com.luisleite.data.remote.dto.WalletResponseDto
import com.luisleite.domain.model.Wallet

fun WalletResponseDto.toDomain(): Wallet {
    return Wallet(
        id = this.id,
        userId = this.userId,
        balance = this.balance,
        active = this.active
    )
}