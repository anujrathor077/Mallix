package com.example.mallix.ProductCard

import android.R.attr.contentDescription
import android.R.attr.icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.VerticalDragHandleDefaults.sizes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mallix.CartItem
import com.example.mallix.MainScreens.mainpage1_module.AllViewModel

//@Preview(showBackground = true

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun Product_Card(
    navController: NavController,
    // object of viewmodel
    viewModel: AllViewModel
) {



    var selectedBottomIndex by remember { mutableStateOf(0) }

    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.ShoppingCart,
        Icons.Default.ShoppingBag,
        Icons.Default.Favorite,
        Icons.Default.Person
    )

    var showSheet by remember { mutableStateOf(false) }
    var selectedSize by remember { mutableStateOf("") }

    val sizes = listOf("XS", "S", "M", "L", "XL")

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Short dress",
                        modifier = Modifier.padding(start = 80.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBackIos, "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Share, "Share")
                    }
                }
            )
        },

        //   BOTTOM BAR
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
                                        MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
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

        // Api Product

        val product by viewModel.selectedProduct.collectAsState()


        LazyColumn(modifier = Modifier.padding(paddingValues))
        {

            item {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ) {
                    AsyncImage(
                        model = product?.image,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))

            }
            item {

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp)
                ) {

                    // Size Button
                    OutlinedButton(
                        onClick = { showSheet = true },
                        modifier = Modifier.padding(start = 10.dp).fillMaxWidth(fraction = 0.3f),
                        colors = ButtonDefaults.outlinedButtonColors(),
                        shape = _root_ide_package_.androidx.compose.ui.graphics.RectangleShape,

                        ) {
                        Text(
                            text = "Size"
                        )

                    }

                    //Color Button
                    OutlinedButton(
                        onClick = {},
                        modifier = Modifier.padding(start = 10.dp).fillMaxWidth(fraction = 0.4f),
                        colors = ButtonDefaults.outlinedButtonColors(),
                        shape = _root_ide_package_.androidx.compose.ui.graphics.RectangleShape,

                        ) {
                        Text(
                            text = "Color"
                        )


                    }


                    Spacer(modifier = Modifier.width(50.dp))


                    FloatingActionButton(
                        onClick = {},
                        containerColor = Color.White,
                        modifier = Modifier.padding(top = 3.dp).size(40.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Back",

                            )

                    }
                }
                Spacer(modifier = Modifier.height(16.dp))


                // Brand Name

                Column() {

                    product?.let { p ->

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = p.title,
                                fontWeight = Bold,
                                fontSize = 22.sp
                            )

                            Text(
                                text = "₹${p.price}",
                                fontWeight = Bold,
                                fontSize = 16.sp,
                                color = Color.Red
                            )


                        Spacer(modifier=Modifier.height(10.dp))



                        }
                    }









                    Spacer(modifier = Modifier.height(16.dp))



                    Text(
                        text = "Short dress in soft cotton jersey with decorative buttons down the front and a wide, frill-trimmed hem.",
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    //  Add to Cart

                    Button(
                        onClick = {
                            product?.let { p ->

                                if (selectedSize.isEmpty()) {
                                    showSheet = true
                                    return@Button
                                }

                                val cartItem = CartItem(
                                    id = p.id,
                                    title = p.title,
                                    image = p.image,
                                    price = p.price,
                                    size = selectedSize
                                )

                                viewModel.addToCart(cartItem)

                                navController.navigate("myBag_screen")
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Text("ADD TO CART", color = Color.White)
                    }
                }

                //  You may also like


                if (showSheet) {
                    ModalBottomSheet(
                        onDismissRequest = { showSheet = false },
                        sheetState = sheetState,
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {

                            Text("Select size", fontSize = 18.sp, fontWeight = Bold)

                            Spacer(modifier = Modifier.height(16.dp))

                            FlowRow(
                                maxItemsInEachRow = 3,
                                horizontalArrangement = Arrangement.spacedBy(12.dp),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                sizes.forEach { size ->
                                    Box(
                                        modifier = Modifier
                                            .width(80.dp)
                                            .height(40.dp)
                                            .border(
                                                1.dp,
                                                if (selectedSize == size) Color.Black else Color.LightGray,
                                                RoundedCornerShape(8.dp)
                                            )
                                            .background(
                                                if (selectedSize == size) Color.Black else Color.White,
                                                RoundedCornerShape(8.dp)
                                            )
                                            .clickable { selectedSize = size },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = size,
                                            color = if (selectedSize == size) Color.White else Color.Black
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(24.dp))

                            Button(
                                onClick = {
                                    showSheet = false
                                },
                                enabled = selectedSize.isNotEmpty(),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                shape = RoundedCornerShape(25.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Red,
                                    disabledContainerColor = Color.LightGray
                                )
                            ) {
                                Text("ADD TO CART")
                            }

                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }











        @Composable
        fun SimilarProductItem() {
            Column(
                modifier = Modifier.width(140.dp)
            ) {
                Image(
                    painter = painterResource(com.example.mallix.R.drawable.eveningdress),
                    contentDescription = null,
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text("Evening Dress", fontSize = 14.sp, maxLines = 1)
                Text("$15", fontWeight = FontWeight.Bold)
            }
        }
    }
    }
















