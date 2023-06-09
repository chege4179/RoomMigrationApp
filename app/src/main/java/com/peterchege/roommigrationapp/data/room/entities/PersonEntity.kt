package com.peterchege.roommigrationapp.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person")
data class PersonEntity(
    @PrimaryKey
    val personId:String,
    val firstName:String,
    val lastName:String
)