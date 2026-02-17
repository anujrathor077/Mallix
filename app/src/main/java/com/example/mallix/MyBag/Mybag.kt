package com.example.mallix.MyBag

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.mallix.MainScreens.mainpage1_module.AllViewModel

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBag_Screen(  navController: NavHostController,
                   viewModel: AllViewModel)
{
    var selectedBottomIndex by remember { mutableStateOf(2) }
    var showPromoSheet by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }
    val cartItems by viewModel.cartList.collectAsState()
    var isCouponApplied by remember { mutableStateOf(false) }

    var discountPercent by remember { mutableStateOf(0) }
    val subTotal = cartItems.sumOf { it.price * it.quantity }

    val discountAmount = (subTotal * discountPercent) / 100

    val totalAmount = subTotal - discountAmount





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

                                    when (index) {
                                        0 -> navController.navigate("main_page1") // Home
                                        1 -> navController.navigate("category_first")  // Cart
                                        //2 -> navController.navigate("")
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


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            // Top bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                // horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 330.dp, top = 10.dp).size(40.dp)
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "My Bag",
                fontWeight = FontWeight.Bold,
                fontSize = 34.sp,
                color = Color.Black,

                )


            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {

                items(cartItems) { item ->

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {

                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            // Product Image
                            AsyncImage(
                                model = item.image,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(RoundedCornerShape(12.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            // Title + Size + Qty
                            Column(modifier = Modifier.weight(1f)) {

                                Text(
                                    item.title,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 20.sp
                                )

                                Text(
                                    "Size: ${item.size}",
                                    fontSize = 12.sp,
                                    color = Color.Gray
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(verticalAlignment = Alignment.CenterVertically) {

                                    // Minus
                                    FloatingActionButton(
                                        onClick = {
                                            viewModel.decreaseQty(item)
                                        },
                                        modifier = Modifier.size(42.dp),
                                        containerColor = Color(0xFFF3F3F3),
                                        shape = CircleShape,
                                        elevation = FloatingActionButtonDefaults.elevation(3.dp)
                                    ) {
                                        Text("-", fontSize = 24.sp)
                                    }

                                    Text(
                                        item.quantity.toString(),
                                        modifier = Modifier.padding(horizontal = 12.dp)
                                    )

                                    // Plus
                                    FloatingActionButton(
                                        onClick = {
                                            viewModel.increaseQty(item)
                                        },
                                        modifier = Modifier.size(42.dp),
                                        containerColor = Color(0xFFF3F3F3),
                                        shape = CircleShape,
                                        elevation = FloatingActionButtonDefaults.elevation(3.dp)
                                    ) {
                                        Text("+", fontSize = 20.sp)
                                    }
                                }
                            }

                            // Right Side Menu + Price
                            Column(horizontalAlignment = Alignment.End) {

                                var expanded by remember { mutableStateOf(false) }

                                Box {

                                    Icon(
                                        Icons.Default.MoreVert,
                                        contentDescription = null,
                                        modifier = Modifier.clickable {
                                            expanded = true
                                        }
                                    )

                                    DropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false }
                                    ) {

                                        DropdownMenuItem(
                                            text = { Text("Delete") },
                                            onClick = {
                                                viewModel.removeFromCart(item)
                                                expanded = false
                                            }
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(20.dp))

                                Text(
                                    "₹${item.price * item.quantity}",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
            if (discountPercent > 0) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Discount ($discountPercent%)")

                    Text(
                        "-₹$discountAmount",
                        color = Color.Green,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Total Amount Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Total Amount",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "₹$totalAmount",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
            }

             // Chekout Button


            Button(
                onClick = {

                    if (!isCouponApplied) {
                        // Pehli baar → Coupon sheet open
                        showPromoSheet = true
                    } else {
                        // Dusri baar → Navigate
                        navController.navigate("shipping_address")
                    }
                },




                        modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
            ) {
                Text(
                    if (isCouponApplied) "PROCEED TO PAY" else "CHECK OUT",
                    color = Color.White,
                    fontSize = 16.sp
                )

            }
        }


    }
    if (showPromoSheet) {

        //  List
        val promoList: List<Triple<String, String, Color>> = listOf(
            Triple("10%", "Personal offer|mypromocode2020|6 days remaining", Color(0xFFE53935)),
            Triple("15%", "Summer Sale|summer2020|23 days remaining", Color(0xFF4CAF50)),
            Triple("22%", "Personal offer|mypromocode2020|6 days remaining", Color.Black)
        )

        ModalBottomSheet(
            onDismissRequest = { showPromoSheet = false },

                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            containerColor = Color.White
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                // Handle
                item {
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(4.dp)
                            .background(Color.LightGray, RoundedCornerShape(50))
                            .align(Alignment.CenterHorizontally)
                    )
                }

                // Enter Promo
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF3F3F3), RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 10.dp)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Enter your promo code", color = Color.Gray)
                        Icon(
                            Icons.Default.ArrowForward,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .background(Color.Black, CircleShape)
                                .padding(6.dp)
                                .clickable{ showPromoSheet = false },
                        )
                    }
                }

                //  Title
                item {
                    Text(
                        text = "Your Promo Codes",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                //  PROMO ITEMS
                items(promoList) { promo ->

                    val parts = promo.second.split("|")

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .background(promo.third, RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    promo.first,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(parts[0], fontWeight = FontWeight.Bold)
                                Text(parts[1], fontSize = 12.sp, color = Color.Gray)
                            }

                            Column(horizontalAlignment = Alignment.End) {
                                Text(
                                    parts[2],
                                    fontSize = 10.sp,
                                    color = Color.Gray
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Button(
                                    onClick = {

                                        val percent = promo.first.replace("%", "").toInt()

                                        discountPercent = percent
                                        isCouponApplied = true   // Mark applied
                                        showPromoSheet = false

                                       // navController.navigate("payment_card")
                                    },

                                    shape = RoundedCornerShape(20.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFE53935)
                                    ),
                                    contentPadding = PaddingValues(
                                        horizontal = 16.dp,
                                        vertical = 4.dp
                                    )
                                ) {
                                    Text("Apply", fontSize = 12.sp)
                                }
                            }
                        }
                    }
                }

                item { Spacer(modifier = Modifier.height(12.dp)) }
            }
        }
    }






}




