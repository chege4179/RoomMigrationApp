package com.peterchege.roommigrationapp.domain

import com.peterchege.roommigrationapp.data.room.entities.PersonEntity
import kotlinx.coroutines.flow.Flow

interface PersonRepository {

    suspend fun insertPerson(personEntity: PersonEntity)

    fun getAllPeople(): Flow<List<PersonEntity>>

    suspend fun deletePersonById(personId:String)
}