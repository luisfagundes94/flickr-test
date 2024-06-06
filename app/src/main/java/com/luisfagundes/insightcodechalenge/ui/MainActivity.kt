package com.luisfagundes.insightcodechalenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.luisfagundes.insightcodechalenge.designsystem.components.FlickrBackground
import com.luisfagundes.insightcodechalenge.designsystem.theme.InsightCodeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.onBackground
            ) { padding ->
                InsightCodeChallengeTheme(
                    darkTheme = true,
                    dynamicColor = false,
                    androidTheme = false,
                ) {
                    FlickrBackground {
                        MainApp(
                            modifier = Modifier
                                .padding(padding)
                                .fillMaxSize()
                                .consumeWindowInsets(padding)
                        )
                    }
                }
            }
        }
    }
}
