package com.luisleite.data.di

import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.luisleite.data.local.ArchitectureSampleDatabase
import org.koin.dsl.module

actual val driverModule = module {
    single { NativeSqliteDriver(schema = ArchitectureSampleDatabase.Schema, name = "ArchitectureSampleDatabase.db") }
}