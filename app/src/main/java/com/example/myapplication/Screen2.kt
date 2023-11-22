package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, itemId: Int) {
    val selectedItem = remember { getItemById(itemId) }

    selectedItem?.let { item ->
        Column {
            Text(text = "Name: ${item.name}")
            Text(text = "Description: ${item.description}")
            // Display other details as needed
        }
    }

    // Example of navigating back
    Button(onClick = { navController.popBackStack() }, modifier= Modifier.fillMaxWidth()
        .padding(100.dp)
    ) {
        Text(text = "Go Back")
    }
}

// Function to get the selected item by ID
fun getItemById(itemId: Int): Item? {
    // Replace this logic with your actual data retrieval mechanism
    val itemList = generateItemList()
    return itemList.find { it.id == itemId }
}
