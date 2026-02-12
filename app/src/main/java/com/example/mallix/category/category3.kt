/*
package com.example.mallix.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
fun Categories3(navController: NavController) {

    var selectedBottomIndex by remember { mutableStateOf(1) }
    var selectedChip by remember { mutableStateOf(0) }

    val bottomIcons = listOf(
        Icons.Default.Home,
        Icons.Default.ShoppingCart,
        Icons.Default.ShoppingBag,
        Icons.Default.Favorite,
        Icons.Default.Person
    )

    val chips = listOf("T-shirts", "Crop tops", "Sleeveless", "Shirts")

    val products = listOf(
        Triple("Pullover", "Mango", "$51"),
        Triple("Blouse", "Dorothy Perkins", "$34"),
        Triple("T-shirt", "LOST Ink", "$12"),
        Triple("Shirt", "Topshop", "$51")
    )

    Scaffold(

 ---------------- TOP BAR ----------------

        topBar = {
            TopAppBar(
                title = { Text("           Womens Tops",
                    fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = null)
                    }
                }
            )
        },

 ---------------- BOTTOM BAR ----------------

        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    bottomIcons.forEachIndexed { index, icon ->
                        val isSelected = selectedBottomIndex == index

                        Box(
                            modifier = Modifier
                                .size(52.dp)
                                .clip(RoundedCornerShape(14.dp))
                                .background(
                                    if (isSelected)
                                        Color.Black.copy(alpha = 0.08f)
                                    else Color.Transparent
                                )
                                .clickable { selectedBottomIndex = index },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = if (isSelected)
                                    MaterialTheme.colorScheme.primary
                                else Color.Gray,
                                modifier = Modifier.size(26.dp)
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
                .fillMaxSize()
        ) {

 ---------------- CHIPS ----------------

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(chips.size) { index ->
                    val selected = selectedChip == index
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(if (selected) Color.Black else Color.LightGray)
                            .clickable { selectedChip = index }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            text = chips[index],
                            color = if (selected) Color.White else Color.Black,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

 ---------------- FILTER ROW ----------------

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.FilterList, null)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Filters")
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.SwapVert, null)
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Price: lowest to high")
                }

                Icon(Icons.Default.GridView, null)
            }

            Spacer(modifier = Modifier.height(8.dp))

 ---------------- PRODUCT LIST ----------------

            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(products) { product ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(12.dp))
                            .padding(15.dp)
                    ) {

                        Image(
                            painter = painterResource(R.drawable.eveningdress),
                            contentDescription = null,
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {

                            Text(
                                text = product.first,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = product.second,
                                fontSize = 12.sp,
                                color = Color.Gray
                            )

 ⭐ RATING — MANGO KE NICHE

                            RatingBar(
                                rating = 4,
                                reviewCount = 3
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = product.third,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }
                }
            }
        }
    }
}
//   RATING BAR
@Composable
fun RatingBar(
    rating: Int,
    reviewCount: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(5) { index ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = if (index < rating)
                    Color(0xFFFFC107)
                else Color.LightGray,
                modifier = Modifier.size(14.dp)
            )
        }

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = "($reviewCount)",
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}
*/
