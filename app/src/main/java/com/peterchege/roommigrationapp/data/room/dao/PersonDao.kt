package com.peterchege.roommigrationapp.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.peterchege.roommigrationapp.data.room.entities.PersonEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun getAllPeople(): Flow<List<PersonEntity>>


    @Query("DELETE FROM person WHERE personId = :id")
    suspend fun deletePersonById(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(personEntity: PersonEntity)


}