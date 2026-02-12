package com.example.mallix.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import androidx.navigation.NavController
import com.example.mallix.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showBackground = true)
fun Categories1(navController: NavController) {

    var selectedBottomIndex by remember { mutableStateOf(1) }
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Women", "Men", "Kids")

    val categories = listOf(
        "New" to R.drawable.eveningdress,
        "Clothes" to R.drawable.menshoodies,
        "Shoes" to R.drawable.takinkphotobackground,
        "Accessories" to R.drawable.girlsnew_top
    )

    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.ShoppingCart,
        Icons.Default.ShoppingBag,
        Icons.Default.Favorite,
        Icons.Default.Person
    )

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    icons.forEachIndexed { index, icon ->


                        val isSelected = selectedBottomIndex == index

                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    if (isSelected)
                                        Color.Black.copy(alpha = 0.08f)
                                    else
                                        Color.Transparent
                                )
                                .clickable {

                                    selectedBottomIndex = index

                                    when (index) {
                                        0 -> navController.navigate("main_page1") // Home
                                        // 1 -> navController.navigate("my_order")  // Cart
                                        2 -> navController.navigate("myBag_screen")
                                        3 -> navController.navigate("favorite") // favorite
                                        4 -> navController.navigate("profile")  //  PROFILE
                                    }


                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = if (isSelected)
                                    MaterialTheme.colorScheme.primary
                                else
                                    Color.Gray,
                                modifier = Modifier.size(34.dp)
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(10.dp)
                .fillMaxSize()
        ) {

            // Tabs
            Card(modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(10.dp))

            {
            TabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Summer Sale Banner
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color(0xFFE53935), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "SUMMER SALES",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Up to 50% off",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Category List
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(categories) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(110.dp)
                            .background(Color.White, RoundedCornerShape(10.dp))
                            .clickable { },
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = item.first,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp)
                        )

                        Image(
                            painter = painterResource(item.second),
                            contentDescription = null,
                            modifier = Modifier
                                .width(140.dp)
                                .fillMaxHeight(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
    }
}
