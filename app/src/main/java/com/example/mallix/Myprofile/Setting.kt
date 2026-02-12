package com.example.mallix.Myprofile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Preview(showBackground = true)
@Composable
fun SettingsScreen() {

    var sales by remember { mutableStateOf(true) }
    var newArrivals by remember { mutableStateOf(false) }
    var deliveryStatus by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        // Top Bar
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

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Settings",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Personal Information
        Text(
            text = "Personal Information",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Full name") },
            modifier = Modifier.fillMaxWidth(),
            //shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "12/12/1989",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            //shape = RoundedCornerShape(12.dp),
            enabled = false
        )

        Spacer(modifier = Modifier.height(65.dp))

        // Password Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Password",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            Text(
                text = "Change",
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = "************",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
           // shape = RoundedCornerShape(12.dp),
            enabled = false
        )

        Spacer(modifier = Modifier.height(65.dp))

        // Notifications
        Text(
            text = "Notifications",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Sales")
            Switch(
                checked = sales,
                onCheckedChange = { sales = it },
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Color.Green,
                    checkedThumbColor = Color.White,
                    uncheckedTrackColor = Color.LightGray,
                    uncheckedThumbColor = Color.White
                )
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("New arrivals")
            Switch(
                checked = newArrivals,
                onCheckedChange = { newArrivals = it }
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Delivery status changes")
            Switch(
                checked = deliveryStatus,
                onCheckedChange = { deliveryStatus = it }
            )
        }
    }
}
