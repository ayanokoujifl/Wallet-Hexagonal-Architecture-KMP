package com.luisleite.wallet_kmp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WalletResponseDto(val id: String, val userId: String, val balance: Double, val active: Boolean)