package com.example.devhire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.devhire.ui.theme.DevhireTheme

class Form : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { padding-> FormBody(padding)
            }
        }
    }
}


@Composable
fun FormBody(paddingValues: PaddingValues){
    Column(
        modifier = Modifier.fillMaxSize().padding(paddingValues).background(color = Color.White)
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = null,
            modifier = Modifier.height(250.dp).width(250.dp).padding(90.dp, 0.dp ,0.dp, 0.dp).fillMaxWidth()
        )







    }
}

@Preview
@Composable
fun FormPrev(){
    FormBody(paddingValues = PaddingValues(0.dp))
}