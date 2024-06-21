package com.example.composenavigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigationsample.ui.theme.ComposeNavigationSampleTheme
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeNavigationSampleTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ScreenA
                ){

                    composable<ScreenA> {
                        Box (
                            modifier = Modifier.fillMaxSize()
                        ){
                            Button(
                                modifier = Modifier.align(Alignment.Center),
                                onClick = {
                                    navController.navigate(
                                        ScreenB("Test name")
                                    )
                                }
                            ){
                                Text(
                                    "Navigate to Screen B"
                                )
                            }
                        }
                    }
                    composable<ScreenB> {
                        Box (
                            modifier = Modifier.fillMaxSize()
                        ){
                            Button(
                                modifier = Modifier.align(Alignment.Center),
                                onClick = {
                                    navController.navigateUp()
                                }
                            ){
                                Text(
                                    "Navigate to Screen A"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Serializable
object ScreenA

@Serializable
data class ScreenB(
    val name: String?
)