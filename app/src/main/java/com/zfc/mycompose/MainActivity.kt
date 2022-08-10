package com.zfc.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zfc.mycompose.ui.theme.MyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoScreen() {
    Column {
        Row {
            Column {
                TextCell("1")
                TextCell("2")
                TextCell("3")
            }
            Column {
                TextCell("4")
                TextCell("5")
                TextCell("6")
            }
            Column {
                TextCell("7")
                TextCell("8")

            }
        }

        Row {
            TextCell("9")
            TextCell("10")
            TextCell("J")
        }
    }
}

@Composable
fun TextCell(text:String , modifier: Modifier = Modifier) {
    val cellModifier = Modifier
        .size(100.dp, 100.dp)
        .padding(4.dp)
        .border(width = 4.dp, color = Color.Black)

    Text(text,
        cellModifier.then(modifier),
        fontSize = 70.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        DemoScreen()
    }
}