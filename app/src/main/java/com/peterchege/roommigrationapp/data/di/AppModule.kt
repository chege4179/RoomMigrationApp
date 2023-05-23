package com.peterchege.roommigrationapp.data.di

import androidx.room.Room
import com.peterchege.roommigrationapp.data.repository.PersonRepositoryImpl
import com.peterchege.roommigrationapp.data.room.database.RoomMigrationAppDatabase
import com.peterchege.roommigrationapp.domain.PersonRepository
import com.peterchege.roommigrationapp.ui.screens.HomeScreenViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<RoomMigrationAppDatabase>{
        Room.databaseBuilder(
            androidContext(),
            RoomMigrationAppDatabase::class.java,
            "app.db"
        ).build()
    }

    single<PersonRepository> {
        PersonRepositoryImpl(db = get())
    }
    viewModel {
        HomeScreenViewModel(personRepository = get())
    }

}