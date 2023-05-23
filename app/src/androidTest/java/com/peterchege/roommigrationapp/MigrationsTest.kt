package com.peterchege.roommigrationapp

import androidx.room.testing.MigrationTestHelper
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.peterchege.roommigrationapp.data.room.database.Migrations
import com.peterchege.roommigrationapp.data.room.database.RoomMigrationAppDatabase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MigrationsTest {


    private val TEST_DB = "room-migration-app-test"

    @get:Rule
    val helper: MigrationTestHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(), RoomMigrationAppDatabase::class.java
    )


    @Test
    fun migrate1To2() {
        val db = helper.createDatabase(TEST_DB, 1)
        db.close()
        helper.runMigrationsAndValidate(TEST_DB, 1, true, Migrations.M1_2)
    }
}