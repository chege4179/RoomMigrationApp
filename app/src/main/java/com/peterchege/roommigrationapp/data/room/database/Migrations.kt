package com.peterchege.roommigrationapp.data.room.database

import androidx.room.migration.Migration

class Migrations {

    companion object {
        val M1_2: Migration = Migration(startVersion = 1, endVersion = 2) { database ->
            database.execSQL("ALTER TABLE person ADD COLUMN email TEXT")
        }
    }
}