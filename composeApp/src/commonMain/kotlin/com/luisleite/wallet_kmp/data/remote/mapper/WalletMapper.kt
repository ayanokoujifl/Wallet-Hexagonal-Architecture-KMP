package com.luisleite.wallet_kmp.data.remote.mapper

import com.luisleite.wallet_kmp.data.remote.dto.WalletResponseDto
import com.luisleite.wallet_kmp.domain.model.Wallet

fun WalletResponseDto.toDomain(): Wallet {
    return Wallet(
        id = this.id,
        userId = this.userId,
        balance = this.balance,
        active = this.active
    )
}