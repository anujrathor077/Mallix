package com.example.mallix.category



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mallix.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showBackground = true)
fun Categories2(navController: NavController) {

    // 🔁 SAME navigation state (as your previous code)
    var selectedBottomIndex by remember { mutableStateOf(1) }

    val bottomIcons = listOf(
        Icons.Default.Home,
        Icons.Default.ShoppingCart,
        Icons.Default.ShoppingBag,
        Icons.Default.Favorite,
        Icons.Default.Person
    )

    val categories = listOf(
        "Tops",
        "Shirts & Blouses",
        "Cardigans & Sweaters",
        "Knitwear",
        "Blazers",
        "Outerwear",
        "Pants",
        "Jeans",
        "Shorts",
        "Skirts",
        "Dresses"
    )

    Scaffold(

        // 🔝 TOP BAR
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "                Categories",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
 //back navigation
 }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = {
 //search
 }) {
                        Icon(Icons.Default.Search, contentDescription = null)
                    }
                }
            )
        },

        // ⬇️ BOTTOM BAR (SAME AS YOUR CODE)
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
                                .clip(MaterialTheme.shapes.medium)
                                .background(
                                    if (isSelected)
                                        Color.Black.copy(alpha = 0.08f)
                                    else
                                        Color.Transparent
                                )
                                .clickable {
                                    selectedBottomIndex = index
                                    // 🔗 yahin se navigation call karna
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
                .fillMaxSize()
        ) {

            // 🔴 VIEW ALL ITEMS BUTTON
            Button(
                onClick = {
                    // 🔗 navigate to product list
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE53935)
                )
            ) {
                Text(
                    text = "VIEW ALL ITEMS",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "Choose category",
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Color.Gray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 📃 CATEGORY LIST
            LazyColumn {
                items(categories) { item ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                // 🔗 navigate with category name
                            }
                            .padding(horizontal = 16.dp, vertical = 14.dp)
                    ) {

                        Text(
                            text = item,
                            fontSize = 16.sp
                        )
                        Divider(
                            modifier = Modifier.padding(top = 14.dp),
                            thickness = 0.5.dp
                        )
                    }
                }
            }
        }
    }
}
