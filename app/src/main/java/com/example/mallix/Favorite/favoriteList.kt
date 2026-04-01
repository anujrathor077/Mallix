package com.example.mallix.Favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mallix.MainScreens.mainpage1_module.AllViewModel

@Composable
fun FavoritesScreen(navController: NavController, viewModel: AllViewModel) {

    var selectedBottomIndex by remember { mutableStateOf(3) }

    // 🔥 ViewModel se Dynamic List Yahan Aayegi 🔥
    val favoriteList by viewModel.favoriteProducts.collectAsState()

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
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    icons.forEachIndexed { index, icon ->
                        val selected = selectedBottomIndex == index
                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    if (selected) Color.Black.copy(alpha = 0.08f) else Color.Transparent
                                )
                                .clickable {
                                    selectedBottomIndex = index
                                    when (index) {
                                        0 -> navController.navigate("main_page1")
                                        1 -> navController.navigate("my_order")
                                        2 -> navController.navigate("category_first")
                                        // 3 -> navController.navigate("favorite")
                                        4 -> navController.navigate("profile")
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                icon,
                                contentDescription = null,
                                tint = if (selected) MaterialTheme.colorScheme.primary else Color.Gray,
                                modifier = Modifier.size(34.dp)
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->

        // Yahan maine Column ki jagah LazyColumn use kiya hai taaki list properly scroll ho
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {

            // HEADER PART
            item {
                Spacer(modifier = Modifier.height(12.dp))

                Box(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .size(34.dp)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Favorites",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            // EMPTY STATE YAA FIR PRODUCTS LIST
            if (favoriteList.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No Favorites Yet!",
                            color = Color.Gray,
                            fontSize = 18.sp
                        )
                    }
                }
            } else {
                items(favoriteList) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(bottom = 12.dp), // Thoda gap cards ke beech mein
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(12.dp)
                        ) {

                            // IMAGE AREA
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color.LightGray)
                            ) {
                                // Dynamic Image Load
                                AsyncImage(
                                    model = item.image,
                                    contentDescription = item.title,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                                Text(
                                    text = "NEW",
                                    color = Color.White,
                                    fontSize = 10.sp,
                                    modifier = Modifier
                                        .background(Color.Black, RoundedCornerShape(6.dp))
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                        .align(Alignment.TopStart)
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            // TEXT & DETAILS AREA
                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(item.brand ?: "Brand", fontSize = 12.sp, color = Color.Gray)

                                Text(
                                    item.title,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                // SIZE & COLOR
                                Row {
                                    Text(text = "Color:", fontSize = 12.sp, color = Color.Gray)
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text(text = "Black", fontSize = 12.sp, color = Color.Black) // Placeholder

                                    Spacer(modifier = Modifier.width(16.dp))

                                    Text(text = "Size:", fontSize = 12.sp, color = Color.Gray)
                                    Spacer(modifier = Modifier.width(2.dp))
                                    Text(text = item.size ?: "L", fontSize = 12.sp, color = Color.Black) // Product ka size
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                // PRICE & RATING
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "₹${item.price.toInt()}",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Black
                                    )

                                    Spacer(modifier = Modifier.weight(1f)) // Taaki rating end mein push ho jaye

                                    // RATING
                                    Row {
                                        repeat(5) { index ->
                                            Icon(
                                                imageVector = Icons.Default.Star,
                                                contentDescription = null,
                                                tint = if (index < (item.rating ?: 4).toInt()) Color(0xFFFFC107) else Color.LightGray,
                                                modifier = Modifier.size(16.dp)
                                            )
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.width(8.dp))

                            // ICONS AREA (Close & Cart)
                            Column(
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxHeight()
                            ) {
                                // ❌ REMOVE FROM FAVORITE BUTTON
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Remove",
                                    tint = Color.Gray,
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clickable {
                                            viewModel.toggleFavorite(item) // Yahan item hat jayega
                                        }
                                )

                                // 🛍️ ADD TO CART BUTTON
                                FloatingActionButton(
                                    onClick = {
                                        // TODO: Yahan aap cart mein add karne ka function laga sakte hain
                                        // jaise viewModel.addToCart(CartItem(...))
                                    },
                                    containerColor = Color.Red,
                                    modifier = Modifier.size(36.dp),
                                    shape = CircleShape
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ShoppingBag,
                                        contentDescription = "Add to cart",
                                        tint = Color.White,
                                        modifier = Modifier.size(18.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}