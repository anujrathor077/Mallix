package com.example.mallix.profile



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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



//@Preview(showBackground = true)
@Composable
fun Profile(navController: NavController) {

    var selectedBottomIndex by remember { mutableStateOf(4) }

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
                                        3 -> navController.navigate("favorite")
                                        4 -> Unit
                                    }
                                },
                            contentAlignment = Alignment.Center
                        )
 {
                            Icon(
                                icon,
                                contentDescription = null,
                                tint = if (selected)
                                    MaterialTheme.colorScheme.primary
                                else Color.Gray,
                                modifier = Modifier.size(30.dp)
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
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            // 🔹 SEARCH ICON
            Box(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .size(26.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 🔹 TITLE
            Text(
                text = "My profile",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 🔹 PROFILE INFO
            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    painter = painterResource(id = R.drawable.anime_girl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        "Matilda Brown",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "matildabrown@mail.com",
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 🔹 OPTION ITEM FUNCTION (INLINE)
            @Composable
            fun profileItem(title: String, subtitle: String) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Text(subtitle, fontSize = 12.sp, color = Color.Gray)
                        }
                        Icon(Icons.Default.KeyboardArrowRight, null, tint = Color.Gray)
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
            }

            profileItem("My orders", "Already have 12 orders")
            profileItem("Shipping addresses", "3 addresses")
            profileItem("Payment methods", "Visa **34")
            profileItem("Promo codes", "You have special promocodes")
            profileItem("My reviews", "Reviews for 4 items")
            profileItem("Settings", "Notifications, password")
        }
    }
}
