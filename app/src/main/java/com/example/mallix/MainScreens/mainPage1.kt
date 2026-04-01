package com.example.mallix.MainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mallix.R
import com.example.mallix.MainScreens.mainpage1_module.AllViewModel

@Composable
fun HomeScreenSingle1(
    navController: NavController,
    viewModel: AllViewModel
) {


    var selectedBottomIndex by remember { mutableStateOf(0) }

    val products by viewModel.products.collectAsState()
    val favoriteProducts by viewModel.favoriteProducts.collectAsState()


    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.ShoppingCart,
        Icons.Default.ShoppingBag,
        Icons.Default.Favorite,
        Icons.Default.Person
    )
    val newProducts = listOf(
        NewProduct(
            image = R.drawable.girlsnew_top,
            brand = "Zara",
            name = "Girls Top",
            rating = 4.5f,
            oldPrice = "₹199",
            newPrice = "₹149"
        ),
        NewProduct(
            image = R.drawable.women_sweter,
            brand = "H&M",
            name = "Women Sweater",
            rating = 4.0f,
            oldPrice = "₹299",
            newPrice = "₹229"
        ),
        NewProduct(
            image = R.drawable.eveningdress,
            brand = "Zara",
            name = "Evening Dress",
            rating = 4.0f,
            oldPrice = "₹299",
            newPrice = "₹229"
        ),
        NewProduct(
            image = R.drawable.menshoodies,
            brand = "Zara",
            name = "Men Hoodies",
            rating = 4.5f,
            oldPrice = "₹299",
            newPrice = "₹229"
        )
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
                                        1 -> navController.navigate("category_first")  //
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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {


            item {
                Box(modifier = Modifier.fillMaxWidth().height(450.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.fasionsale_banner),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        modifier = Modifier.align(Alignment.BottomStart)
                            .padding(start = 16.dp, bottom = 32.dp)
                    ) {
                        Text(
                            "Fashion\nsale",
                            color = Color.White,
                            fontSize = 48.sp,
                            fontWeight = FontWeight.Black,
                            lineHeight = 48.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                navController.navigate("main_page3")
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDB3022)),
                            shape = RoundedCornerShape(24.dp),
                            modifier = Modifier.width(120.dp).height(36.dp),
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("Check", color = Color.White, fontSize = 14.sp)
                        }
                    }
                }
            }

            //  Title
            item {
                Column(modifier = Modifier.padding(12.dp)) {

                    // New Text
                    Text("New", fontSize = 32.sp, fontWeight = FontWeight.Bold)

                    // View all Text
                    Text(
                        "View all", color = Color.Gray,
                        modifier = Modifier.fillMaxWidth().clickable {
                            navController.navigate("main_page2")
                        },
                        textAlign = TextAlign.End,

                        )
                    Text("You've never seen it before!", color = Color.Gray)
                }
            }


            // LazyRow 1 (API)
            // LAZY ROW 1 (API PRODUCTS)
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(products) { product ->

                        // Check if this specific product is in favorites
                        val isFavorite = favoriteProducts.any { it.id == product.id }

                        Card(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .width(160.dp)
                                .height(280.dp)
                                .clickable {
                                    viewModel.selectProduct(product)
                                    navController.navigate("product_card")
                                }
                        ) {
                            Column {
                                Box {
                                    AsyncImage(
                                        model = product.image,
                                        contentDescription = product.title,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(200.dp),
                                        contentScale = ContentScale.Crop
                                    )

                                    // ❤️ DYNAMIC FAVORITE OVERLAY ❤️
                                    IconButton(
                                        onClick = { viewModel.toggleFavorite(product) },
                                        modifier = Modifier
                                            .align(Alignment.TopEnd)
                                            .padding(6.dp)
                                            .size(36.dp)
                                            .background(Color.White, CircleShape)
                                    ) {
                                        Icon(
                                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                            contentDescription = "Favorite",
                                            tint = Color.Red
                                        )
                                    }
                                }

                                Column(modifier = Modifier.padding(8.dp)) {
                                    RatingBar(rating = product.rating ?: 4.0f)
                                    Text(
                                        text = product.brand ?: "Brand",
                                        fontSize = 11.sp,
                                        color = Color.Gray
                                    )
                                    Text(
                                        text = product.title,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        maxLines = 2
                                    )
                                    Row {
                                        Text(
                                            text = "₹ ${product.price}",
                                            fontSize = 14.sp,
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // LAZY ROW 2 (LOCAL PRODUCTS)
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(newProducts) { product ->
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.width(160.dp)
                        ) {
                            Column {
                                Box {
                                    Image(
                                        painter = painterResource(id = product.image),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(200.dp),
                                        contentScale = ContentScale.Crop
                                    )

                                    // Local products ke liye default favorite button (kyunki ye ViewModel me nahi hain)
                                    IconButton(
                                        onClick = { /* Todo for local product */ },
                                        modifier = Modifier
                                            .align(Alignment.TopEnd)
                                            .padding(6.dp)
                                            .size(36.dp)
                                            .background(Color.White, CircleShape)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "Favorite",
                                            tint = Color.Red
                                        )
                                    }
                                }

                                Column(modifier = Modifier.padding(8.dp)) {
                                    RatingBar(rating = product.rating)
                                    Text(
                                        text = product.brand,
                                        fontSize = 11.sp,
                                        color = Color.Gray
                                    )
                                    Text(
                                        text = product.name,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Row {
                                        Text(
                                            text = product.oldPrice,
                                            fontSize = 12.sp,
                                            color = Color.Gray,
                                            textDecoration = TextDecoration.LineThrough
                                        )
                                        Spacer(modifier = Modifier.width(6.dp))
                                        Text(
                                            text = product.newPrice,
                                            fontSize = 14.sp,
                                            color = Color.Red,
                                            fontWeight = FontWeight.Bold
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
}