package com.zfc.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
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
        MainScreen2()
    }
}

@Composable
fun DemoText() {
    Row {
        Text(text = "Hello World \nZfc",
        modifier = Modifier.alignBy(FirstBaseline),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
            lineHeight = 40.sp
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(text = "Compose\nCompose\nCompose",
            Modifier
                .paddingFrom(LastBaseline, before = 100.dp, after = 10.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun MainScreen2() {
    Row {
        TextCell("1", Modifier.weight(weight = 0.2f, fill = true))
        TextCell("2", Modifier.weight(weight = 0.4f, fill = true))
        TextCell("3", Modifier.weight(weight = 0.3f, fill = true))
    }
}

@Composable
fun MainScreen() {
//    val list = listOf<String>("1","2","3","4","5","6","7","8","9")
    val list = listOf<String>("1","2")
    val isFeeVisible = remember {
        mutableStateOf(false)
    }

    Column (
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Red)
            .clickable {
                isFeeVisible.value = !isFeeVisible.value
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        if (isFeeVisible.value) {
            FeeList(fees = list, onItemClicked = {})
        } else {
            Text(text = "Fee is Gone")
        }
    }
}

@Composable
fun FeeList(fees:List<String>,onItemClicked : (String) -> Unit){
    LazyColumn(
        Modifier
            .background(Color.Blue)
            .run {
                if(fees.size > 3){
                    height(400.dp)
                } else {
                    wrapContentHeight(
                    )
                }
            }
        ){
        items(fees.size){ index ->
            DetailItem(title = fees[index], onItemClicked)
        }
    }
}

@Composable
fun DetailItem(title:String, onItemClicked : (String) -> Unit) {
    Text(text = title,
        Modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = Color.Black)
            .padding(10.dp, 50.dp, 10.dp, 50.dp)
            .clickable {
                onItemClicked(title)
            }
            .background(Color.Green),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center)
}
