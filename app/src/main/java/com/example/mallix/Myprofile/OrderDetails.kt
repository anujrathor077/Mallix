package com.example.mallix.Myprofile

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp




@Preview(showBackground = true)
@Composable


fun OrderDetailsScreen() {

    val productImages = listOf(
        com.example.mallix.R.drawable.menshoodies,
        com.example.mallix.R.drawable.eveningdress,
        com.example.mallix.R.drawable.girlsnew_top
    )






    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
            .padding(16.dp)
    ) {

        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Order Details",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Default.Search, contentDescription = "Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Order Info
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text("Order №1947034", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Text("Tracking number: IW347545345", fontSize = 12.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(10.dp))
                Text("3 items", fontSize = 12.sp)
            }
            Text("Delivered", color = Color(0xFF2E7D32))
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Order Item Card (Reusable look)
        repeat(productImages.size) { index ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Row(modifier = Modifier.padding(10.dp)) {

                    Image(
                        painter = painterResource(id = productImages[index]),
                        contentDescription = "Product Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text("Pullover", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Mango", fontSize = 12.sp, color = Color.Gray)
                        Text("Color: Gray   Size: L", fontSize = 12.sp)

                        Row {
                            Text("Units: 1", fontSize = 12.sp)
                            Spacer(modifier = Modifier.weight(1f))
                            Text("51$", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
0
        Spacer(modifier = Modifier.height(50.dp))


        // Order Information
        Text("Order information", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        Row() {

        Text("Shipping Address:", fontSize = 12.sp, color = Color.Gray)

            Spacer(modifier = Modifier.width(8.dp))
            Text("3 Newbridge Court, Chino Hills, CA 91709, United States", fontSize = 12.sp, )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Text("Payment method: **** **** **** 3947", fontSize = 12.sp)
        Spacer(modifier = Modifier.height(14.dp))
        Text("Delivery method: FedEx, 3 days, 15$", fontSize = 12.sp)
        Spacer(modifier = Modifier.height(14.dp))
        Text("Discount: 10%, Personal promo code", fontSize = 12.sp)
        Spacer(modifier = Modifier.height(14.dp))
        Text("Total Amount: 133$", fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(40.dp))

        // Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("Reorder")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {},
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE53935)
                )
            ) {
                Text("Leave feedback", color = Color.White)
            }
        }
    }
}
