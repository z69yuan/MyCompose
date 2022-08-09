package com.zfc.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun MainScreen() {
    var linearSelected = remember {
        mutableStateOf(true)
    }

    var imageSelected = remember {
        mutableStateOf(true)
    }

    val onLinearClicked = { value : Boolean ->
        linearSelected.value = value
    }

    val onTitleClicked = { value : Boolean ->
        imageSelected.value = value
    }


}

@Composable
fun ScreenContent(
    linearSelected : Boolean ,
    imageSelected : Boolean ,
    onLinearClick : (Boolean) -> Unit ,
    onTitleClick : (Boolean) -> Unit
){
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {

    }
}


@Composable
fun CheckBoxes( linearSelected : Boolean ,
               imageSelected : Boolean ,
               onLinearClick : (Boolean) -> Unit ,
               onTitleClick : (Boolean) -> Unit){

    Row (Modifier.padding(20.dp)){
        Checkbox(
            checked = imageSelected,
            onCheckedChange = onTitleClick
        )
        Text("Image Title")
        Spacer(Modifier.width(20.dp))
//        Checkbox(checked = linearSelected,
//            onCheckedChange = onLinearClick
//        )
        Text("Linear Progress")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        MainScreen()
    }
}