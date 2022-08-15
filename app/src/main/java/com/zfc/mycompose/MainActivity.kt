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
import androidx.compose.ui.layout.layout
import androidx.compose.ui.modifier.modifierLocalConsumer
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
    Box(
        modifier = Modifier.size(120.dp,80.dp)
    ){
        ClearBox(
            Modifier
                .offset()
                .exampleLayout(20,40)
                .background(Color.Blue)

        )
    }
}

fun Modifier.exampleLayout(
    x:Int,
    y:Int
) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width,placeable.height){
        placeable.placeRelative(x,y)
    }
}

@Composable
fun ClearBox(modifier : Modifier = Modifier) {
    Box(
        modifier = modifier.then(
            Modifier
                .padding(1.dp)
                .width(50.dp)
                .height(10.dp)
        )
    )
}


@Composable
fun Bagua() {
    Box(
        Modifier
            .size(210.dp)
            .clip(CutCornerShape((210 / 3.4f).toInt().dp))
            .background(Color.Blue))
}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        MainScreen()
    }
}

