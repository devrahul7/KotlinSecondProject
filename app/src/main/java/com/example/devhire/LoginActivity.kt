package com.example.devhire

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.style.UnderlineSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
//import androidx.compose.material.icons.filled.Refresh
//import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
//import androidx.compose.material3.TextField
//import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

//import com.example.devhire.ui.theme.DevhireTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LoginBody()
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginBody() {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    var rememberMe by remember { mutableStateOf(false) }


    val context = LocalContext.current

    val couroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val activity = context as? Activity


    var showDialog by remember { mutableStateOf(false) }


    Scaffold (
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    )  { padding->
        Column(
            modifier = Modifier
                .fillMaxSize().padding(padding)
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Trigger to show the dialog
            Button(onClick = { showDialog = true }) {
                Text("Show AlertDialog")
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = {
                        showDialog = false
                    }, // dismiss when clicked outside
                    confirmButton = {
                        Button(onClick = {
                            // Confirm action
                            showDialog = false
                        }) {
                            Text("OK")
                        }
                    },
                    dismissButton = {
                        Button(onClick = {
                            // Cancel action
                            showDialog = false
                        }) {
                            Text("Cancel")
                        }
                    },
                    title = { Text(text = "Alert Title") },
                    text = { Text("This is an alert dialog message.") }
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            Image(
                painter = painterResource(R.drawable.img),
                contentDescription = null,
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(12.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                prefix = {
                    Icon(Icons.Default.Email, contentDescription = null)
                },

                placeholder = {
                    Text("abc@gmail.com")
                },
                value = username,
                onValueChange = { input ->
                    username = input
                }
            )


            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(12.dp),
                visualTransformation =
                    if (passwordVisibility) PasswordVisualTransformation()
                    else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                prefix = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,

                        )
                },
                suffix = {
                    Icon(
                        painter = painterResource(
                            if (passwordVisibility)
                                R.drawable.visibility else R.drawable.notvisibility
                        ),
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            passwordVisibility = !passwordVisibility
                        }
                    )
                },

                placeholder = {
                    Text("*******")
                },
                value = password,
                onValueChange = { input ->
                    password = input
                }
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(

                    verticalAlignment = Alignment.CenterVertically,

                    ) {
                    Checkbox(

                        checked = rememberMe,
                        onCheckedChange = { rememeber ->
                            rememberMe = rememeber
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Green,
                            checkmarkColor = Color.White
                        )
                    )

                    Text(text = "Remember me")
                }

                Text("Forget Password")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (username == "Mr Rahul"
                        && password == "password"
                    ) {
                        val intent = Intent(context,DashboardActivity::class.java)
                        //to pass data to another  activity
                        intent.putExtra("username",username)
                        intent.putExtra("password",password)
                        context.startActivity(intent)

                        Toast.makeText(
                            context, "Login success",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        //snackbar
                        couroutineScope.launch {
                            snackbarHostState.showSnackbar("Invalid login")
                        }
                    }
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Login")
            }


            Spacer(modifier = Modifier.height(8.dp))


            Text("New user? Register Now",
                modifier = Modifier.clickable {
                    val intent = Intent(context,RegistrationActivity::class.java)
                    context.startActivity(intent)

                    //to destroy activity
                    activity?.finish()
                }
                )


            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {


                Image(
                    painter = painterResource(R.drawable.img2),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    painter = painterResource(R.drawable.img1),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )


            }

        }
    }

}



@Preview
@Composable
fun LoginPreviewBody() {
    LoginBody()
}



