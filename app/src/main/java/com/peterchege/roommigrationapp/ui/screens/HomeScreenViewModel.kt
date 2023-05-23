package com.peterchege.roommigrationapp.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peterchege.roommigrationapp.data.room.entities.PersonEntity
import com.peterchege.roommigrationapp.domain.PersonRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.random.Random

class HomeScreenViewModel(
    val personRepository: PersonRepository,
) : ViewModel() {


    val people = personRepository.getAllPeople()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    fun deletePersonById(personId: String) {
        viewModelScope.launch {
            personRepository.deletePersonById(personId = personId)
        }
    }

    fun addDummyPerson(){
        val person = PersonEntity(
            personId = UUID.randomUUID().toString(),
            firstName = generateRandomString(length = 10),
            lastName = generateRandomString(length = 5)
        )
        viewModelScope.launch {
            personRepository.insertPerson(personEntity = person)
        }

    }

    private fun generateRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9') // Define the characters allowed in the random string
        return (1..length)
            .map { allowedChars[Random.nextInt(0, allowedChars.size)] }
            .joinToString("")
    }


}