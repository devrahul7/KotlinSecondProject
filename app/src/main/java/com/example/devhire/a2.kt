package com.example.devhire

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.devhire.ui.theme.DevhireTheme

class a2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { padding -> a2compose(padding) }

        }
    }
}

@Composable
fun a2compose(paddingValues: PaddingValues) {

    Column {
        Text("RAm")
    }

}

@Preview(showBackground = true)
@Composable
fun previewa2() {
    a2compose(paddingValues = PaddingValues(0.dp))

}