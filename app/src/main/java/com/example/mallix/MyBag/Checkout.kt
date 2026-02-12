package com.example.mallix.MyBag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Checkout", fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ArrowBackIos, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

 //Shipping Address

            Text("Shipping address", fontWeight = FontWeight.Medium,fontSize = 20.sp)

            Spacer(Modifier.height(15.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(2.dp),
                modifier = Modifier.fillMaxWidth().size(120.dp)
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("Jane Doe", fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
                        Spacer(Modifier.height(10.dp))
                        Text("3 Newbridge Court",fontSize = 17.sp)
                        Spacer(Modifier.height(10.dp))
                        Text("Chino Hills, CA 91709, United States", fontSize = 17.sp)
                    }
                    Text(
                        "Change",
                        color = Color.Red,
                        fontWeight = FontWeight.Medium
                                ,fontSize = 17.sp
                    )
                }
            }

            Spacer(Modifier.height(40.dp))

// Payment

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Payment", fontWeight = FontWeight.Medium,fontSize = 20.sp)
                Text("Change", color = Color.Red,fontSize = 17.sp)
            }

            Spacer(Modifier.height(8.dp))

            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(12.dp).fillMaxWidth().size(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color(0xFFFFE0B2), RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("MC", fontWeight = FontWeight.Bold,fontSize = 17.sp)
                    }
                    Spacer(Modifier.width(12.dp))
                    Text("**** **** **** 3947",fontSize = 17.sp)
                }
            }

            Spacer(Modifier.height(40.dp))

 //Delivery Method

            Text("Delivery method", fontWeight = FontWeight.Medium,fontSize = 20.sp)

            Spacer(Modifier.height(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("FedEx", "USPS", "DHL").forEach {
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                            .fillMaxWidth().size(70.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(it, fontWeight = FontWeight.Bold, fontSize = 17.sp)

                            Spacer(Modifier.height(6.dp))

                            Text("2-3 days", fontSize = 15.sp)
                        }
                    }
                }
            }

            Spacer(Modifier.height(40.dp))

 //Price Summary

            Column {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Order:",fontSize = 18.sp)
                    Text("112$")
                }
                Spacer(Modifier.height(20.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Delivery:", fontSize = 18.sp)
                    Text("15$")
                }
                Spacer(Modifier.height(20.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Summary:", fontWeight = FontWeight.Bold,fontSize = 18.sp)
                    Text("127$", fontWeight = FontWeight.Bold)
                }
            }

            Spacer(Modifier.weight(1f))

// Submit Button

            Button(
                onClick = {},
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("SUBMIT ORDER", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
