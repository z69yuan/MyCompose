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
import androidx.compose.foundation.shape.CutCornerShape
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
                    MainScreen()
                }
            }
        }
    }
}


@Composable
fun MainScreen(){
//    Box{
//        val height = 200.dp
//        val width = 200.dp
//        TextCell("1",Modifier.size(width = width , height = height))
//        TextCell("2",Modifier.size(width = width , height = height))
//        TextCell("3",Modifier.size(width = width , height = height))
//    }

//    Box(modifier = Modifier.size(height = 90.dp, width = 290.dp)) {
//        Text("TopStart", Modifier.align(Alignment.TopStart))
//        Text("TopCenter", Modifier.align(Alignment.TopCenter))
//        Text("TopEnd", Modifier.align(Alignment.TopEnd))
//
//        Text("CenterStart", Modifier.align(Alignment.CenterStart))
//        Text("Center", Modifier.align(Alignment.Center))
//        Text(text = "CenterEnd", Modifier.align(Alignment.CenterEnd))
//
//        Text("BottomStart", Modifier.align(Alignment.BottomStart))
//        Text("BottomCenter", Modifier.align(Alignment.BottomCenter))
//        Text("BottomEnd", Modifier.align(Alignment.BottomEnd))
//    }

    Bagua()

}

@Composable
fun Bagua() {
    Box(Modifier.size(210.dp)
        .clip(CutCornerShape((210/3.4f).toInt().dp))
        .background(Color.Blue))
}


@Composable
fun TextCell(text:String, modifier:Modifier = Modifier , fontSize:Int = 150){

    val cellModifier = Modifier.padding(5.dp)
        .border(width = 5.dp, color = Color.Black)
    Text(text = text,
        modifier = cellModifier.then(modifier),
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center)
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        MainScreen()
    }
}

