package com.luisleite.wallet_kmp.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreateWalletRequestDto(val userId: String)