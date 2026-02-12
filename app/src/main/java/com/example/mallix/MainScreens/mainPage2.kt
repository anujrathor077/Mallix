package com.example.mallix.MainScreens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mallix.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenSingle2(navController: NavController) {

    var selectedBottomIndex by remember { mutableStateOf(0) }

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

                        val selected = selectedBottomIndex == index

                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    if (selected) Color.Black.copy(alpha = 0.08f)
                                    else Color.Transparent
                                )
                                .clickable {
                                    selectedBottomIndex = index
                                    when (index) {
                                        0 -> navController.navigate("main_page1")
                                        1 -> navController.navigate("category_first")
                                        2 -> navController.navigate("myBag_screen")
                                        3 -> navController.navigate("favorite")
                                        4 -> navController.navigate("profile")
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = icon,
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

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // TOP BANNER
            item(span = { GridItemSpan(2) }) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.streetclothebanner),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(260.dp),
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        text = "Street clothes",
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    )
                }
            }

            // NEW HEADER
            item(span = { GridItemSpan(2) }) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("New", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        Text("You've never seen it before!", fontSize = 12.sp, color = Color.Gray)
                    }
                    Text("View all", fontSize = 12.sp, color = Color.Gray)
                }
            }

            // NEW PRODUCTS
            items(newProducts) { product ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth()
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

//RATING BAR

@Composable
fun RatingBar(
    rating: Float,
    maxRating: Int = 5,
    starSize: Dp = 20.dp
) {
    Row {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i <= rating) Icons.Default.Star else Icons.Default.StarBorder,
                contentDescription = null,
                tint = Color(0xFFFFC107),
                modifier = Modifier.size(starSize)
            )
        }
    }
}

// DATA CLASS

data class NewProduct(
    val image: Int,
    val brand: String,
    val name: String,
    val rating: Float,
    val oldPrice: String,
    val newPrice: String
)