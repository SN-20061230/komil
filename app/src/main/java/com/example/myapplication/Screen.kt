package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val itemList = remember { generateItemList() } // Your list of items

    LazyColumn {
        items(itemList) { item ->
            Text(
                text = item.name,
                modifier = Modifier.clickable {
                    navController.navigate("details/${item.id}")
                }
            )
        }
    }
}

// Generate some dummy items for demonstration
fun generateItemList(): List<Item> {
    return listOf(
        Item(1, "Item 1", "Description for Item 1"),
        Item(2, "Item 2", "Description for Item 2"),
        // Add more items as needed
    )
}
