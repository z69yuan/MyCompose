package com.zfc.mycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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

    ScreenContent(
        linearSelected = linearSelected.value,
        imageSelected = imageSelected.value,
        onLinearClick = onLinearClicked,
        onTitleClick = onTitleClicked,
        titleContent = {
            if (imageSelected.value) {
                TitleCompose(drawing = R.drawable.ic_baseline_cloud_download_24)
            } else {
                Text("Downloading", style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(30.dp))
            }
        },
        progressContent = {
            if (linearSelected.value) {
                LinearProgressIndicator(Modifier.height(40.dp))
            } else {
                CircularProgressIndicator(Modifier.size(200.dp),
                    strokeWidth = 18.dp)
            }
        }
    )
}

@Composable
fun ScreenContent(
    linearSelected: Boolean,
    imageSelected: Boolean,
    onLinearClick: (Boolean) -> Unit,
    onTitleClick: (Boolean) -> Unit,
    titleContent: @Composable () -> Unit,
    progressContent: @Composable () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        titleContent()
        progressContent()
        CheckBoxes(
            linearSelected = linearSelected,
            imageSelected = imageSelected,
            onLinearClick = onLinearClick,
            onTitleClick = onTitleClick
        )
    }
}


@Composable
fun CheckBoxes( linearSelected : Boolean ,
               imageSelected : Boolean ,
               onLinearClick : (Boolean) -> Unit ,
               onTitleClick : (Boolean) -> Unit){

    Row (Modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically){
        Checkbox(
            checked = imageSelected,
            onCheckedChange = onTitleClick
        )
        Text("Image Title")
        Spacer(Modifier.width(20.dp))
        Checkbox(checked = linearSelected,
            onCheckedChange = onLinearClick
        )
        Text("Linear Progress")
    }
}

@Composable
fun TitleCompose(drawing: Int) {
    Image(
        painter = painterResource(id = drawing),
        contentDescription = "title image"
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        MainScreen()
    }
}