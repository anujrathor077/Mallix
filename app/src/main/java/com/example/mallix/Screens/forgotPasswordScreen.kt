package com.example.mallix.Screens



import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Thin
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants

//@Preview(showBackground = true)
@Composable

fun Forgot1(navController: NavController){


    var email by remember { mutableStateOf("") }
    var showdialog by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {


            Column() {

                Icon(
                    Icons.Default.ArrowBackIos,
                    contentDescription = null,
                    modifier = Modifier.padding(top = 30.dp, start = 10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))
// text

                Text(
                    text = "Forgot password",
                    fontWeight = Bold,
                    fontSize = 36.sp,
                    modifier = Modifier.padding(10.dp)
                )


                Spacer(modifier = Modifier.height(60.dp))


                Text(
                    text = "Please, enter your email address. you will receive" +
                            "a link to create a new password vie email ",
                    // fontWeight = Thin,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(10.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

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


                Spacer(modifier = Modifier.height(70.dp))

                Button(
                    onClick = { showdialog = true },
                    modifier = Modifier.fillMaxWidth(fraction = 0.9f)
                        .align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red
                    )
                ) {
                    Text(
                        text = "SEND"
                    )
                }

            }

            // Alert Dialer

            if (showdialog) {
                AlertDialog(
                    onDismissRequest = {},
                    title = { Text("Forgot link sent successfully") },
                    text = { Text("check your email link sent on your email*******854@gmail.com") },
                    confirmButton = {
                        Button(onClick = { showdialog = false
                            navController.navigate("login")}) {
                            Text("Ok")
                        }
                    },
                    properties = DialogProperties(
                        dismissOnBackPress = false,
                        dismissOnClickOutside = false
                    )
                )
            }


        }
    }}