package com.example.mallix.MyBag

// Imports
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun SuccessScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
      //  contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = com.example.mallix.R.drawable.succes1_image),
            contentDescription = "Celebration Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .height(300.dp)
        )



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(26.dp),
          //  horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier.padding(start = 50.dp, top = 20.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Column() {
            Text(
                text = "Success!",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Your order will be delivered soon.\nThank you for choosing our app!",
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
 //TODO: Handle continue shopping
 },
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .height(48.dp)
                    .width(200.dp)
            ) {
                Text(text = "Continue shopping", color = Color.White)
            }
            Spacer(modifier = Modifier.height(32.dp))

        }
    }
}
}
}
