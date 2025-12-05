package com.luisleite.wallet_kmp.domain.model

data class Wallet(
    val id: String,
    val userId: String,
    val balance: Double,
    val active: Boolean
)