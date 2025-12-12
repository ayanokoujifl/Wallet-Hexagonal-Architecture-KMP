package com.luisleite.data.local.mapper

import com.luisleite.data.local.Wallet

fun Wallet.toDomain(): com.luisleite.domain.model.Wallet {
    return com.luisleite.domain.model.Wallet(
        id = this.id,
        userId = this.userId,
        balance = this.balance,
        active = this.active == 1L
    )
}