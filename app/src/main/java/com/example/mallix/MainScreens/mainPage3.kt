package com.example.mallix.MainScreens




import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenSingle3(navController: NavController) {

    var  selectedBottomIndex by remember { mutableStateOf(0) }

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
                .verticalScroll(rememberScrollState())
        ) {

            // 🔹 Top Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(460.dp)
            ) {
                Image(
                    painter = painterResource(id = com.example.mallix.R.drawable.newcollectionbackground),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "New collection",
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            //  Grid Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                // Left Column
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .height(160.dp)
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(8.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Summer\nsale",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red
                        )
                    }

                    Box(
                        modifier = Modifier
                            .height(140.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = com.example.mallix.R.drawable.blachbackground),
                            contentDescription = null,
                            modifier = Modifier.height(160.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Black",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(12.dp)
                        )
                    }
                }

                // Right Image
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(300.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.menshoodies),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "Men’s\nhoodies",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(12.dp)
                    )
                }
            }
        }
    }
}





