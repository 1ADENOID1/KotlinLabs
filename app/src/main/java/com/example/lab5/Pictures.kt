package com.example.lab5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class Paintwork (var image: Int, var name: String, var author: String) {

}


@Composable
fun PicturesLayout(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {

    val paint1 = Paintwork(image = R.drawable.lemon_restart, name = "cup", author = "author1")
    val paint2 = Paintwork(image = R.drawable.lemon_squeeze, name = "lemon", author = "author2")
    val paint3 = Paintwork(image = R.drawable.lemon_drink, name = "drink", author = "author3")

    val paintworks = listOf(paint1, paint2, paint3)



    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var currentPainting by remember { mutableStateOf(0) }
        Image(
            painter = painterResource(paintworks[currentPainting].image),
            contentDescription = null
        )
        Text(
            text = "Name: " + paintworks[currentPainting].author
        )
        Text(
            text = "Name: " + paintworks[currentPainting].name
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row() {
            Button(onClick = { currentPainting = if (currentPainting > 0) --currentPainting else paintworks.size-1; println(currentPainting) }) {
                Text("Prevous")
            }
            Button(onClick = { currentPainting = if (currentPainting < paintworks.size-1) ++currentPainting else 0; println(currentPainting) }) {
                Text("Next")
            }
        }
    }

}