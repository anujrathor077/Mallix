package com.example.mallix.MainScreens



import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable

fun Filter(navController: NavController) {
    var isApplyClicked by remember { mutableStateOf(false) }
    var Search by remember { mutableStateOf("") }
    var showSheet by remember { mutableStateOf(true) }
    val sheetState = rememberModalBottomSheetState()

    val size = listOf<String>(
        "S",
        "L",
        "Xl",
        "XS"
    )
    val category = listOf<String>(
        "All",
        "Women",
        "Men",
        "Boys",
        "Girls"

    )

    val colorList = listOf(
        Color.Red,
        Color.Blue,
        Color.Green,
        Color.Yellow,
        Color.Black,
        Color.Magenta,
        Color.Gray,
        Color.White

    )




    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column() {


            Row() {


                Icon(
                    imageVector = Icons.Default.ArrowBackIos, contentDescription = null,
                    modifier = Modifier.padding(start = 10.dp, top = 30.dp)
                )

                Spacer(modifier = Modifier.width(100.dp))

                Text(
                    text = "Filters",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp, top = 30.dp)
                )

            }
            Spacer(modifier = Modifier.height(10.dp))

            Divider(
                modifier = Modifier.shadow(
                    elevation = 20.dp,
                    spotColor = Color.Black
                ), thickness = 1.dp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Price range",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 15.dp)

            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = Search,
                onValueChange = { Search = it },
                label = { Text("Search") },
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.padding(start = 5.dp).fillMaxWidth(fraction = 0.9f)
            )


            Spacer(modifier = Modifier.height(25.dp))





            Text(
                text = "Colors",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 15.dp)

            )
            Spacer(modifier = Modifier.height(15.dp))

            Card(
                modifier = Modifier.fillMaxWidth().height(55.dp).width(70.dp).size(100.dp),
                elevation = CardDefaults.cardElevation(10.dp),

                ) {


                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {

                    items(colorList.size) { index ->
                        Card(
                            modifier = Modifier.size(48.dp)
                                .background(color = Color.White),
                            shape = RoundedCornerShape(300.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = colorList[index]
                            )

                        )

                        {

                        }

                    }


                }
            }


            Spacer(modifier = Modifier.height(25.dp))


            // size

            Text(
                text = "Sizes",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 15.dp)

            )
            Spacer(modifier = Modifier.height(15.dp))


            Card(
                modifier = Modifier.fillMaxWidth().height(50.dp).width(70.dp).size(100.dp),
                elevation = CardDefaults.cardElevation(10.dp),

                )
            {


                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    items(size) { index ->

                        Button(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(20.dp),

                            ) {
                            Text(text = index)


                        }


                    }

                }

            }
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "Category",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 15.dp)

            )

            Spacer(modifier = Modifier.height(25.dp))

            // category

            Card(
                modifier = Modifier.fillMaxWidth().height(150.dp),
                elevation = CardDefaults.cardElevation(10.dp),

                )
            {

                LazyHorizontalGrid(
                    rows = GridCells.Fixed(2),
                    contentPadding = PaddingValues(12.dp),

                    )
                {

                    items(category){
                            index->

                        Button(
                            onClick = { /*TODO*/ },
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier.size(100.dp).
                            padding(2.dp)

                        ) {
                            Text(text = index)


                        }
                    }






                }






            }



// model bottom sheet


            ModalBottomSheet(
                onDismissRequest = { showSheet = true },
                sheetState = sheetState,
            ) {



                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    // DISCARD BUTTON
                    Button(
                        onClick = {
                            isApplyClicked = false
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.White
                        ),
                        border = BorderStroke(1.dp, Color.Black),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Discard",
                            color = Color.Black
                        )
                    }

                    // APPLY BUTTON
                    Button(
                        onClick = {
                            isApplyClicked = true
                        },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isApplyClicked) Color.Red else Color.White
                        ),
                        border = if (!isApplyClicked)
                            BorderStroke(1.dp, Color.Black)
                        else null,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(
                            text = "Apply",
                            color = if (isApplyClicked) Color.White else Color.Black
                        )
                    }
                }


            }
            }

        }



    }



