package com.luisleite.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreateWalletRequestDto(val userId: String)