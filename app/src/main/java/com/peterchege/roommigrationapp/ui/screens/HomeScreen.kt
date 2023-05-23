package com.peterchege.roommigrationapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.peterchege.roommigrationapp.ui.components.PersonCard
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    val viewModel = getViewModel<HomeScreenViewModel>()
    val people = viewModel.people.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)

            ){
                items(items = people.value){ personEntity ->
                    PersonCard(
                        personEntity = personEntity,
                        deletePerson = {
                            viewModel.deletePersonById(it)
                        }

                    )
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Button(onClick = {
                    viewModel.addDummyPerson()
                }) {
                    Text(text = "Add dummy Person")

                }
            }


        }


    }

}