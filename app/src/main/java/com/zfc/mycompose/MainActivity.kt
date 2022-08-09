package com.zfc.mycompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
                    Composable1()
                }
            }
        }
    }
}

// 1. 声明一个CompositionLocal
val LocalColor = staticCompositionLocalOf {
    Color(0xFFffdbcf)
}

@Composable
fun Composable1() {
    Column {
        Composable2()
        var color = if (isSystemInDarkTheme()) {
            Color(0xFFa08d87)
        } else {
            Color(0xFFffdbcf)
        }

        CompositionLocalProvider(LocalColor provides color) {
            Composable3()
        }
    }
}

@Composable
fun Composable3() {
    Composable5()
}

@Composable
fun Composable5() {
    Composable7()
    // 可以中间修改一下
    CompositionLocalProvider(LocalColor provides Color(0xffff0000)) {
        Composable8()
    }
}

@Composable
fun Composable7() {
    Text(text = "Composable7",
        modifier = Modifier.background(LocalColor.current))
}

@Composable
fun Composable8() {
    Text(text = "Composable8",
        modifier = Modifier.background(LocalColor.current))
}

@Composable
fun Composable2() {
    Composable4()

}

@Composable
fun Composable4() {
    Composable6()
}

@Composable
fun Composable6() {
    Text(text = "Composable6",
        modifier = Modifier.background(LocalColor.current))
}


@Preview(showBackground = true ,
        uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    MyComposeTheme {
        Composable1()
    }
}