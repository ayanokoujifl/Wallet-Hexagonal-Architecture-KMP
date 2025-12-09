package com.luisleite.model

data class Wallet(
    val id: String,
    val userId: String,
    val balance: Double,
    val active: Boolean
)