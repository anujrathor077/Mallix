package com.example.mallix.Myprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PasswordChangeBottomSheet() {

    var showSheet by remember { mutableStateOf(true) }

    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        // Dummy background content (Settings screen)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE0E0E0))
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Settings",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Personal information",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = "Name, Date of birth",
                onValueChange = {},
                //placeholder = { Text("Full name") },
                modifier = Modifier.fillMaxWidth(),
                //shape = RoundedCornerShape(12.dp)
            )


            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Password",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            OutlinedTextField(
                value = "Password settings",
                onValueChange = {},
               // placeholder = { Text("Password settings") },
                modifier = Modifier.fillMaxWidth(),
                //colors = OutlinedTextField(colors = Color.White)
                //shape = RoundedCornerShape(12.dp)
            )


            if (showSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showSheet = false },
                    containerColor = Color.White,
                    shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {

                        // Drag Handle

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Password Change",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        OutlinedTextField(
                            value = oldPassword,
                            onValueChange = { oldPassword = it },
                            placeholder = { Text("Old Password") },
                            modifier = Modifier.fillMaxWidth(),
                         //  shape = RoundedCornerShape(12.dp),
                            visualTransformation = PasswordVisualTransformation(),
                            colors = OutlinedTextFieldDefaults.colors(
                                // Background
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                disabledContainerColor = Color.White,

                                // Border
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color(0xFFDDDDDD),
                                disabledBorderColor = Color(0xFFDDDDDD),

                                // Text
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                disabledTextColor = Color.Gray,

                                // Placeholder
                                focusedPlaceholderColor = Color.Gray,
                                unfocusedPlaceholderColor = Color.Gray,

                            )
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Forgot Password?",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            modifier = Modifier.align(Alignment.End)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = newPassword,
                            onValueChange = { newPassword = it },
                           placeholder = { Text("New Password") },
                            modifier = Modifier.fillMaxWidth(),
                          //  shape = RoundedCornerShape(12.dp),
                            visualTransformation = PasswordVisualTransformation(),
                            colors = OutlinedTextFieldDefaults.colors(
                                // Background
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                disabledContainerColor = Color.White,

                                // Border
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color(0xFFDDDDDD),
                                disabledBorderColor = Color(0xFFDDDDDD),

                                // Text
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                disabledTextColor = Color.Gray,

                                // Placeholder
                                focusedPlaceholderColor = Color.Gray,
                                unfocusedPlaceholderColor = Color.Gray,

                                )
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            value = repeatPassword,
                            onValueChange = { repeatPassword = it },
                            placeholder = { Text("Repeat New Password") },
                            modifier = Modifier.fillMaxWidth(),
                           // shape = RoundedCornerShape(12.dp),
                            visualTransformation = PasswordVisualTransformation(),
                            colors = OutlinedTextFieldDefaults.colors(
                                // Background
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                disabledContainerColor = Color.White,

                                // Border
                                focusedBorderColor = Color.Black,
                                unfocusedBorderColor = Color(0xFFDDDDDD),
                                disabledBorderColor = Color(0xFFDDDDDD),

                                // Text
                                focusedTextColor = Color.Black,
                                unfocusedTextColor = Color.Black,
                                disabledTextColor = Color.Gray,

                                // Placeholder
                                focusedPlaceholderColor = Color.Gray,
                                unfocusedPlaceholderColor = Color.Gray,

                                )
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        Button(
                            onClick = { /* save password */ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            shape = RoundedCornerShape(26.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE53935)
                            )
                        ) {
                            Text(
                                text = "SAVE PASSWORD",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}

