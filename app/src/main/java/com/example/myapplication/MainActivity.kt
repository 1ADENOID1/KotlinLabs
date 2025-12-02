package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.FontScaling

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "Лёха ВАЛ",
                        from = "канал"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    val userIcon = painterResource(R.drawable.valchannelicon1)
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Image(
            painter = userIcon,
            contentDescription = null,
            modifier = Modifier
                .padding(1.dp)

        )
        Text(
            text = message,
            fontSize = 70.sp,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 30.sp,

            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        GreetingContacts(
            phone = "+66666666666",
            userId = "@valchannel",
            email = "valchannel@val.channel",
        )
    }
}

@Composable
fun GreetingContacts(phone: String, userId: String, email: String, modifier: Modifier = Modifier) {
    val contactIcon = painterResource(R.drawable.contacticon)
    Column (
        verticalArrangement = Arrangement.Bottom,
        //horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 80.dp)

    ) {
        Row(

            modifier = Modifier
                .padding(5.dp)

        ) {
            Image (
                painter = contactIcon,
                contentDescription = null,
                alignment = Alignment.BottomStart
            )
            Text (
                text = phone,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Image (
                painter = contactIcon,
                contentDescription = null
            )
            Text (
                text = userId,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Image (
                painter = contactIcon,
                contentDescription = null
            )
            Text (
                text = email,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(message = message,
                    from = from,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        GreetingImage(message = "Лёха ВАЛ", from = "канал")
    }
}