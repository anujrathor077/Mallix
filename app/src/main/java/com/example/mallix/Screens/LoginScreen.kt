package com.example.mallix.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.example.mallix.R


//@Preview(showBackground = true)
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(
    navController: NavHostController,

)
 {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    var showDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            //  BACK ICON
            Icon(
                imageVector = Icons.Default.ArrowBackIos,
                contentDescription = null,
                modifier = Modifier.padding(top = 30.dp, start = 10.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            //  TITLE
            Text(
                text = "Login",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )

            Spacer(modifier = Modifier.height(60.dp))

            //  EMAIL
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = false
                },
                label = { Text("Email") },
                isError = emailError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .fillMaxWidth(0.9f)
            )

            if (emailError) {
                Text(
                    text = "Email is required",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 28.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            //  PASSWORD
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = false
                },
                label = { Text("Password") },
                isError = passwordError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .padding(start = 20.dp)
                    .fillMaxWidth(0.9f)
            )

            if (passwordError) {
                Text(
                    text = "Password is required",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 28.dp, top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row() {

            //  FORGOT
            Text(
                text = "Forgot your password",
                modifier = Modifier.fillMaxWidth(0.9f)
                    .clickable { navController.navigate("forgot_password") },
                textAlign = TextAlign.End
            )

           // Spacer(modifier = Modifier.width(1.dp))

            Text(
                text = " ->",
              //  modifier = Modifier.fillMaxWidth(0.9f),
                textAlign = TextAlign.End,
                color = Color.Red
            )
            }

            Spacer(modifier = Modifier.height(30.dp))

            //  LOGIN BUTTON
            Button(
                onClick = {

                    emailError = email.isBlank()
                    passwordError = password.isBlank()


                    if (!emailError && !passwordError) {

                        navController.navigate("main_page1")
                        showDialog = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                )
            ) {
                Text(text = "Login")
            }

            Spacer(modifier = Modifier.height(200.dp))

            //  SOCIAL TEXT
            Text(
                text = "Or Login With social account",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(15.dp))

            //  SOCIAL BUTTONS
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                FloatingActionButton(onClick = {},
                    modifier = Modifier,
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
                {
                    Image(
                        painterResource(id= com.example.mallix.R.drawable.facebook_icon),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                FloatingActionButton(onClick = {},
                    modifier = Modifier,
                    containerColor = Color.White
                ) {
                    Image(
                        painterResource(id= R.drawable.google_icon),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                        contentScale = ContentScale.Fit
                    )


                }
            }
        }
    }

    //SUCCESS DIALOG
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {},
            title = { Text("Login Successful") },
            text = { Text("Your account logged in successfully") },
            confirmButton = {

            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        )
    }
}
