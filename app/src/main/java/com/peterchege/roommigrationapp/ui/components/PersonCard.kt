package com.peterchege.roommigrationapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.peterchege.roommigrationapp.data.room.entities.PersonEntity

@Composable
fun PersonCard(
    personEntity: PersonEntity,
    deletePerson:(String) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(70.dp)
            ,
        shape = RoundedCornerShape(15),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Name :" + personEntity.firstName + " " + personEntity.lastName,
                    fontWeight = FontWeight.Bold,

                    )
                Text(text = personEntity.personId)

            }
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    deletePerson(personEntity.personId)
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete Icon"
                    )

                }
            }
        }
    }
}