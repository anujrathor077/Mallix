package com.example.mallix.Favorite





import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DensityMedium
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardDoubleArrowDown
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Mood
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mallix.ProductItem
import com.example.mallix.R


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable


fun Favourite_Module(navController: NavController) {

    var selectedBottomIndex by remember { mutableStateOf(3) }
    var showSortSheet by remember { mutableStateOf(false) }


    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.ShoppingCart,
        Icons.Default.ShoppingBag,
        Icons.Default.Favorite,
        Icons.Default.Person
    )

    val categories = listOf(
        "T-shirts",
        "Crop tops",
        "Blouses",
        "Sweaters",
        "Jackets",
        "Pants",
        "Shorts",
        "Shoes"
    )
    val productList = listOf(

        ProductItem(
            id = 1,
            image = R.drawable.womens_top,
            brand = "Mango",
            title = "T-Shirt SPANISH",
            price = 799.0,
            size = "M",
            rating = 3
        ),

        ProductItem(
            id = 2,
            image = R.drawable.croptop_1,
            brand = "Dorothy Perkins",
            title = "Blouse",
            price = 999.0,
            size = "L",
            rating = 4
        ),

        ProductItem(
            id = 3,
            image = R.drawable.women_blouse,
            brand = "Mango",
            title = "Shirt",
            price = 899.0,
            size = "S",
            rating = 0
        ),

        ProductItem(
            id = 4,
            image = R.drawable.women_sweter,
            brand = "Dorothy Perkins",
            title = "Light blouse",
            price = 1199.0,
            size = "M",
            rating = 5
        ),

        ProductItem(
            id = 5,
            image = R.drawable.womens_top,
            brand = "Mango",
            title = "T-Shirt SPANISH",
            price = 799.0,
            size = "XL",
            rating = 3
        ),

        ProductItem(
            id = 6,
            image = R.drawable.croptop_1,
            brand = "Dorothy Perkins",
            title = "Blouse",
            price = 999.0,
            size = "M",
            rating = 4
        ),

        ProductItem(
            id = 7,
            image = R.drawable.women_blouse,
            brand = "Mango",
            title = "Shirt",
            price = 899.0,
            size = "L",
            rating = 0
        ),

        ProductItem(
            id = 8,
            image = R.drawable.women_sweter,
            brand = "Dorothy Perkins",
            title = "Light blouse",
            price = 1199.0,
            size = "S",
            rating = 5
        )
    )






    val categories2 = listOf(
        Pair(Icons.Default.Mood, "Client"),
        Pair(Icons.Default.MonetizationOn, "Earnings"),
        Pair(Icons.Default.Notifications, "Notifications"),
        Pair(Icons.Default.Email, "About Us"),
        Pair(Icons.Default.Category, "Category"),
        Pair(Icons.Default.Email, "About Us"),
        // Pair(Icons.Default.Category, "Category"),


    )
    val sortOptions = listOf(
        "Popular",
        "Newest",
        "Customer review",
        "Price: lowest to high",
        "Price: highest to low"
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
                                        1 -> navController.navigate("category_first")  // Cart
                                        2 -> navController.navigate("myBag_screen")
                                       // 3 -> navController.navigate("favorite") // favorite
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {

                Column() {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        Icon(
                            Icons.Default.ArrowBackIos,
                            contentDescription = null,
                            modifier = Modifier.padding(top = 30.dp)
                        )



                        Text(
                            text = "Favorites",
                            fontWeight = Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 30.dp,)
                        )


                        Icon(
                            Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier.padding(top = 30.dp,)
                        )

                    }

                    Spacer(modifier = Modifier.height(20.dp))


                    // filter button


                    LazyRow(
                        modifier = Modifier.padding(start = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        items(categories) { item ->
                            Button(
                                onClick = {
 },
                                shape = RoundedCornerShape(20.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Black,

                                    ),
                                contentPadding = PaddingValues(
                                    horizontal = 16.dp,
                                    vertical = 2.dp
                                )
                            ) {
                                Text(
                                    text = item,
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))


                    //  filter Option
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable {

 }
                        ) {
                            Icon(
                                imageVector = Icons.Default.FilterList,
                                contentDescription = "Filter"
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = "Filter", fontSize = 13.sp)
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable {
                                showSortSheet = true   // 🔥 bottom sheet open
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.KeyboardDoubleArrowDown,
                                contentDescription = "Sort"
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = "Sort", fontSize = 13.sp)
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.clickable {

 }
                        ) {
                            Icon(
                                imageVector = Icons.Default.DensityMedium,
                                contentDescription = "View"
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(text = "View", fontSize = 13.sp)
                        }

                    }
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(8.dp),
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        items(productList) { item ->

                            Card(
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFF8F8F8)
                                ),
                                elevation = CardDefaults.cardElevation(6.dp)
                            ) {

                                Column {

                                    // IMAGE AREA
                                    Box {

                                        Image(
                                            painter = painterResource(item.image),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(190.dp)
                                                .blur(if (item.isSoldOut) 14.dp else 0.dp),
                                            contentScale = ContentScale.Crop
                                        )

                                        if (item.isSoldOut) {
                                            Box(
                                                modifier = Modifier
                                                    .matchParentSize()
                                                    .background(Color.White.copy(alpha = 0.6f))
                                            )

                                            Text(
                                                text = "Sorry, this item is currently sold out",
                                                fontSize = 12.sp,
                                                color = Color.DarkGray,
                                                textAlign = TextAlign.Center,
                                                modifier = Modifier
                                                    .align(Alignment.Center)
                                                    .padding(12.dp)
                                            )
                                        }

                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = null,
                                            tint = Color.Gray,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(8.dp)
                                               // .background(Color.White, CircleShape)
                                                .padding(6.dp)
                                        )

                                        // DISCOUNT
                                        item.discount?.let {
                                            Box(
                                                modifier = Modifier
                                                    .padding(8.dp)
                                                    .background(Color.Red, RoundedCornerShape(12.dp))
                                                    .padding(horizontal = 8.dp, vertical = 4.dp)
                                            ) {
                                                Text(it, color = Color.White, fontSize = 12.sp)
                                            }
                                        }


                                        // HEART ICON
                                        Icon(
                                            imageVector = Icons.Default.ShoppingBag,
                                            contentDescription = null,
                                            tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.BottomEnd)
                                                .padding(top = 2.dp)
                                                .background(Color.Red, CircleShape)
                                                .padding(10.dp)
                                        )


                                    }

                                    Spacer(modifier = Modifier.height(6.dp))

                                    // RATING

                                    RatingBar(
                                        rating = item.rating,
                                        reviewCount = item.reviewCount
                                    )

                                    //  Spacer(modifier = Modifier.height(8.dp))

                                    // BRAND
                                    Text(
                                        text = item.brand,
                                        fontSize = 12.sp,
                                        color = Color.Gray,
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    )

                                    // TITLE
                                    Text(
                                        text = item.title,
                                        fontWeight = Bold,
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(horizontal = 8.dp)
                                    )

                                    // PRICE
                                    Row(modifier = Modifier.padding(8.dp)) {

                                        if (item.oldPrice.isNotEmpty()) {
                                            Text(
                                                text = item.oldPrice,
                                                fontSize = 13.sp,
                                                color = Color.Gray,
                                                textDecoration = TextDecoration.LineThrough
                                            )
                                            Spacer(modifier = Modifier.width(6.dp))
                                        }

                                        Text(
                                            text = "₹${item.price.toInt()}",
                                            fontSize = 14.sp,
                                            fontWeight = Bold,
                                            color = Color.Red
                                        )
                                    }
                                }
                            }
                        }


                    }


                }

            }
        }



        // bottom Sheet
        if (showSortSheet) {
            ModalBottomSheet(
                onDismissRequest = { showSortSheet = false }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {

                    Text(
                        text = "Sort by",
                        fontSize = 18.sp,
                        fontWeight = Bold,
                        modifier=Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    listOf(
                        "Popular",
                        "Newest",
                        "Customer review",
                        "Price: lowest to high",
                        "Price: highest to low"
                    ).forEach { option ->

                        Text(
                            text = option,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    showSortSheet = false   // click pe close
                                }
                                .padding(vertical = 12.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }





    }
}




// rating function


@Composable
fun RatingBar(
    rating: Int,
    reviewCount: Int
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        repeat(5) { index ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = if (index < rating)
                    Color(0xFFFFC107)
                else
                    Color.LightGray,
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


// bottomsheet


