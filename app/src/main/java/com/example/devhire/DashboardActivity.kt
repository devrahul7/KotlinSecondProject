package com.example.devhire

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.devhire.ui.theme.DevhireTheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            DashboardBody()

        }
    }
}

@Composable
fun DashboardBody() {
    val context = LocalContext.current
    val activity = context as Activity

    val username : String? = activity.intent.getStringExtra("username")
    Scaffold {
        innerPadding-> Column  (modifier = Modifier.padding(innerPadding)){
            Text("Good Morning, $username")
    } }
    }


@Preview
@Composable
fun DashboardPreview() {
    DashboardBody()
}