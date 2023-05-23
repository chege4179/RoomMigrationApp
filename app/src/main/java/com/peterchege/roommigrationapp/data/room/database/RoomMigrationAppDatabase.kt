package com.peterchege.roommigrationapp.data.room.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.peterchege.roommigrationapp.data.room.dao.PersonDao
import com.peterchege.roommigrationapp.data.room.entities.PersonEntity

@Database(
    entities = [
        PersonEntity::class,
    ],
    version = 2,
    exportSchema = true,
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ]
)
abstract class RoomMigrationAppDatabase : RoomDatabase() {

    abstract val personDao: PersonDao;



}