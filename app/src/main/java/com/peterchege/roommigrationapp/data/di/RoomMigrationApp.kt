package com.peterchege.roommigrationapp.data.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RoomMigrationApp :Application (){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RoomMigrationApp)
            modules(appModule)
        }
    }
}