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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mallix.R
import com.example.mallix.Screens.RegistrationModule.UserViewModelFactory
import com.example.mallix.viewmodel.UserViewModel
import java.lang.Character.getName


//@Preview(showBackground = true)
@Composable
fun Profile_1(navController: NavController) {

    var selectedBottomIndex by remember { mutableStateOf(4) }

    val context = LocalContext.current
    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(context)
    )
    val username = userViewModel.getUsername()
    val email = userViewModel.getEmail()


    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.ShoppingCart,
        Icons.Default.ShoppingBag,
        Icons.Default.Favorite,
        Icons.Default.Person
    )
    val profileItems = listOf(
        Triple("My orders", "Already have 12 orders", "my_order"),
        Triple("Shipping addresses", "3 addresses", "shipping_address"), // Abhi ke liye category par bhej rahe hain
        Triple("Payment methods", "Visa **34", "payment_card"),
        Triple("Promo codes", "You have special promocodes", ""),
        Triple("My reviews", "Reviews for 4 items", ""),
        Triple("Settings", "Notifications, password", "setting_screen")
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
                                    if (selected)
                                        Color.Black.copy(alpha = 0.08f)
                                    else Color.Transparent
                                )
                                .clickable {
                                    selectedBottomIndex = index
                                    when (index) {
                                        0 -> navController.navigate("main_page1")
                                        1 -> navController.navigate("category_first")
                                        2 -> navController.navigate("myBag_screen")
                                        3 -> navController.navigate("favorite")
                                        4 -> Unit
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
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            //  SEARCH ICON
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

            // TITLE
            Text(
                text = "My profile",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(25.dp))

            // PROFILE INFO
            Row(verticalAlignment = Alignment.CenterVertically) {

                Image(
                    painter = painterResource(id=R.drawable.anime_girl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(92.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        text = if (username.isNotEmpty()) username else "No Name",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = if (email.isNotEmpty()) email else "No Email",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            //  OPTION ITEM FUNCTION
            profileItems.forEach { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp)
                        .clickable {
                            // Ye line 'item.third' se route uthayegi (e.g., "my_order")
                            navController.navigate(item.third)
                        },
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
                            Text(item.first, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Text(item.second, fontSize = 16.sp, color = Color.Gray)
                        }
                        Icon(Icons.Default.KeyboardArrowRight, null, tint = Color.Gray)
                    }
                }
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}