package com.example.journal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.journal.pages.HomePage
import com.example.journal.ui.theme.JournalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JournalTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(0.dp)
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        HomePage()
                    }
                }
            }
        }
    }
}
