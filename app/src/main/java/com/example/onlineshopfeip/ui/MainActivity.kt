package com.example.onlineshopfeip.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.onlineshopfeip.ui.screens.productprewiew.ProductPreviewScreen
import com.example.onlineshopfeip.ui.screens.productprewiew.ProductPreviewViewModel
import com.example.onlineshopfeip.ui.theme.OnlineShopFEIPTheme
import org.koin.android.ext.android.get
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            OnlineShopFEIPTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = "start") {
                        composable("start") {
                            TempStart {
                                navController.navigate("product/123")
                            }
                        }
                        composable(
                            "product/{productId}",
                            arguments = listOf(navArgument("productId") { type = NavType.LongType })
                        ) { backStackEntry ->
                            val productId = backStackEntry.arguments?.getLong("productId")
                                ?: throw IllegalArgumentException("ProductId shouldn't be null")

                            val viewModel: ProductPreviewViewModel = get { parametersOf(productId) }
                            ProductPreviewScreen(viewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TempStart(onOpenProduct: () -> Unit) {
    Button(onClick = onOpenProduct) {

    }
}