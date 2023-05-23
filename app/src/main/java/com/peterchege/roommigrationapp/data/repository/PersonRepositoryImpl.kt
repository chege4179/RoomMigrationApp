package com.peterchege.roommigrationapp.data.repository

import com.peterchege.roommigrationapp.data.room.database.RoomMigrationAppDatabase
import com.peterchege.roommigrationapp.data.room.entities.PersonEntity
import com.peterchege.roommigrationapp.domain.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class PersonRepositoryImpl (
    private val db:RoomMigrationAppDatabase
):PersonRepository {
    override suspend fun insertPerson(personEntity: PersonEntity) = withContext(Dispatchers.IO) {
        db.personDao.insertPerson(personEntity = personEntity)
    }

    override fun getAllPeople(): Flow<List<PersonEntity>> {
        return db.personDao.getAllPeople()
    }

    override suspend fun deletePersonById(personId: String) {
        return db.personDao.deletePersonById(id = personId)
    }

}