package com.example.mallix.MyBag

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mallix.MainScreens.mainpage1_module.AllViewModel


@Composable
fun AddShippingAddressScreen(
    navController: NavHostController,
    viewModel: AllViewModel
)
 {

    // 🔹 States
    var fullName by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var state by remember { mutableStateOf("") }
    var zipCode by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE53935)
                )
            ) {
                Text(
                    text = "SAVE ADDRESS",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier=Modifier.clickable{
                        navController.navigate("checkout_screen")
                    }
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFF5F5F5))
                .padding(16.dp)
        ) {
            // Top Bar
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.ArrowBackIos,
                    contentDescription = null,
                    modifier = Modifier.clickable{
                        navController.popBackStack()
                    }
                )
                Spacer(modifier = Modifier.width(40.dp))
                Text(
                    text = "Adding Shipping Address",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }


            Spacer(modifier = Modifier.height(20.dp))

            // 🔹 Full Name
            OutlinedTextField(
                value = viewModel.fullName,
                onValueChange = {   viewModel.updateFullName(it) },
                label = { Text("Full name") },
                placeholder = { Text("Enter full name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                shape = RoundedCornerShape(12.dp)
            )

            // 🔹 Address
            OutlinedTextField(
                value = viewModel.address,
                onValueChange ={ viewModel.updateAddress(it) },
                label = { Text("Address") },
                placeholder = { Text("Enter address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                shape = RoundedCornerShape(12.dp)
            )

            // 🔹 City
            OutlinedTextField(
                value = viewModel.city,
                onValueChange = { viewModel.updateCity(it) },
                label = { Text("City") },
                placeholder = { Text("Enter city") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                shape = RoundedCornerShape(12.dp)
            )

            // 🔹 State / Province
            OutlinedTextField(
                value = viewModel.state,
                onValueChange =  { viewModel.updateState(it) },
                label = { Text("State/Province/Region") },
                placeholder = { Text("Enter state") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                shape = RoundedCornerShape(12.dp)
            )

            // 🔹 Zip Code
            OutlinedTextField(
                value = viewModel.zipCode,
                onValueChange = { viewModel.updateZipCode(it) },
                label = { Text("Zip Code (Postal Code)") },
                placeholder = { Text("Enter zip code") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(6.dp))

            // 🔹 Country
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("Country", fontSize = 12.sp, color = Color.Gray)
                        Text("United States")
                    }
                    Icon(
                        Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}
