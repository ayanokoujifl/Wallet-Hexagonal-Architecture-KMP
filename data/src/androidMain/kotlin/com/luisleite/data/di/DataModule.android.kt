package com.luisleite.data.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.luisleite.data.local.ArchitectureSampleDatabase
import org.koin.dsl.module

actual val driverModule = module {
    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = ArchitectureSampleDatabase.Schema,
            context = get(),
            name = "ArchitectureSampleDatabase.db"
        )
    }
}
