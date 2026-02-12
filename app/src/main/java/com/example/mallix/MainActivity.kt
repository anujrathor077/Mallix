package com.example.mallix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mallix.NavigationFile.MyApp
import com.example.mallix.ProductCard.Product_Card



import com.example.mallix.ui.theme.MallixTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {


            MallixTheme {
                // UserProfile()
                MyApp()
                //   TextFieldDropdownExample()
                //   grid1()
                // MainScreen()
                // Alertdialog()
                // SideEffectsExample()
                // NavigationRailExample()
                // BottomAppBarDemo()
               //  mainScreenP2()






                }
        }
    }
}


