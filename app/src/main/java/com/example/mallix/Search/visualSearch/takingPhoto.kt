package com.example.mallix.Search.visualSearch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
//@Preview
@Composable
fun SearchByPhotoScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {

        // 🔹 TOP BAR
        TopAppBar(
            title = {
                Text(
                    text = "Search by taking a photo",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        )

        // 🔹 IMAGE / CAMERA PREVIEW
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {

            // Temporary image (later CameraX preview lagega)
            Image(
                painter = painterResource(id =R.drawable.takinkphotobackground),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // 🔹 BOTTOM CAMERA CONTROLS
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            // ⚡ Flash
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.FlashOn,
                    contentDescription = "Flash"
                )
            }

            //  Capture Button
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.Red, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.capturebutton),
                    contentDescription = "Capture",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            // 🔄 Rotate Camera
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Cached,
                    contentDescription = "Switch Camera"
                )
            }
        }
    }
}
