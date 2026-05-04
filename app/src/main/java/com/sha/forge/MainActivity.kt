package com.sha.forge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var tab by remember { mutableStateOf("EDITOR") }
    val tabs = listOf("AI", "TERM", "EDIT", "PREV")

    Column {
        TabRow(
            selectedTabIndex = tabs.indexOf(tab),
            containerColor = Color.Black,
            contentColor = Color.Cyan
        ) {
            tabs.forEach { title ->
                Tab(
                    selected = tab == title,
                    onClick = { tab = title },
                    text = { Text(title, fontSize = 10.sp) }
                )
            }
        }
        Box(modifier = Modifier.weight(1f).fillMaxSize()) {
            Text(
                text = "ShaForge Node: $tab",
                color = Color.DarkGray,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
