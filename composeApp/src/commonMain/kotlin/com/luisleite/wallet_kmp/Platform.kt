package com.luisleite.wallet_kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform