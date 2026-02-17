package com.example.mallix.MainScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mallix.R
import com.example.mallix.MainScreens.mainpage1_module.AllViewModel

@Composable
fun HomeScreenSingle1(
    navController: NavController,
    viewModel: AllViewModel
){


    var selectedBottomIndex by remember { mutableStateOf(0) }

    val products by viewModel.products.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAll()
    }
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

            // 🔹 Banner
            item {
                Image(
                    painter = painterResource(R.drawable.fasionsale_banner),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp),
                    contentScale = ContentScale.FillWidth
                )
            }

            // 🔹 Title
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
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    items(products) { product ->

                            Column(
                                modifier = Modifier
                                    .width(160.dp)
                                    .clickable {
                                        viewModel.selectProduct(product)
                                        navController.navigate("product_card")
                                    }
                            ) {

                                AsyncImage(
                                    model = product.image,
                                    contentDescription = product.title,
                                    modifier = Modifier
                                        .height(200.dp)
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(12.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = product.title,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 2
                                )

                                Text(
                                    text = "₹ ${product.price}",
                                    color = Color.Red,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

            }



//  LazyRow 2 (Local)
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(newProducts) { product ->
                        Card(
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.width(160.dp)
                        ) {
                            Column {

                                Image(
                                    painter = painterResource(id = product.image),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp),
                                    contentScale = ContentScale.Crop
                                )

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