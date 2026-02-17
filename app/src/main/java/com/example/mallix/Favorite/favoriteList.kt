package com.example.mallix.Favorite

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

//@Preview(showBackground = true)
@Composable

fun FavoritesScreen(navController: NavController) {

    var selectedBottomIndex by remember { mutableStateOf(3) }

    val items = listOf(
        Triple("LIME", "Shirt", "$32"),
        Triple("Mango", "Longsleeve Violeta", "$46"),
        Triple("Oliver", "Shirt", "$52")
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
                                    if (selected)
                                        Color.Black.copy(alpha = 0.08f)
                                    else Color.Transparent
                                )
                                .clickable {
                                    selectedBottomIndex = index
                                    when (index) {
                                        0 -> navController.navigate("main_page1")
                                        1 -> navController.navigate("my_order")
                                        2 -> navController.navigate("category_first")
                                      //  3 -> navController.navigate("favorite")
                                        4-> navController.navigate("profile")
                                    }
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                icon,
                                contentDescription = null,
                                tint = if (selected)
                                    MaterialTheme.colorScheme.primary
                                else Color.Gray,
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
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            //  TITLE + SEARCH
            Box(modifier = Modifier.fillMaxWidth()) {

                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterEnd).size(34.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Favorites",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            items.forEach { item ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp)
                    ) {

                        // IMAGE PLACEHOLDER + NEW TAG
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.LightGray)
                        ) {
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

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(item.first, fontSize = 12.sp, color = Color.Gray)
                            Text(
                                item.second,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )



                            Spacer(modifier = Modifier.height(6.dp))

                            // SIZE

                            Row() {
                            Text(
                                text = "Color:",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )

                            Spacer(modifier = Modifier.width(1.dp))

                            Text(
                                text ="blue",
                                fontSize = 12.sp,
                                color = Color.Black
                            )
                                Spacer(modifier = Modifier.width(34.dp))

                                Text(
                                    text ="Size:",
                                    fontSize = 12.sp,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.width(1.dp))

                                Text(
                                    text ="L",
                                    fontSize = 12.sp,
                                    color = Color.Black
                                )

                            }

                            Spacer(modifier = Modifier.height(5.dp))

                            Row() {
                                Text(
                                    text = "46$",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.width(52.dp))

                                // RATING
                                Row {
                                    repeat(5) { index ->
                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = null,
                                            tint = if (index < 4) Color(0xFFFFC107) else Color.LightGray,
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                }
                            }




                        }

                        // Close Icon
                        Column() {

                        Icon(
                            Icons.Default.Close,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(20.dp).clickable {  }
                        )

                        Spacer(modifier = Modifier.height(64.dp))

                        Box {
                            FloatingActionButton(
                                onClick = {
 },
                                containerColor = Color.Red,
                                modifier = Modifier
                                    .size(40.dp).align(Alignment.BottomEnd)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ShoppingBag,
                                    contentDescription = "Add to cart",
                                    tint = Color.White
                                )
                            }
                        }
                        }

                    }




                }

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}
