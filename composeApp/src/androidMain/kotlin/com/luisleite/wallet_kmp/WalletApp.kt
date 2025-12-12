package com.luisleite.wallet_kmp

import android.app.Application
import android.util.Log
import com.luisleite.wallet_kmp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class WalletApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("PRINT", "INITIALIZING KOIN")
        initKoin() {
            androidLogger()
            androidContext(this@WalletApp)
        }
        Log.d("PRINT", "KOIN INITIALIZED")
    }
}