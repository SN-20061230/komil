package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, itemId: Int) {
    val selectedItem = remember { getItemById(itemId) }

    selectedItem?.let { item ->

        val firaSansFamily = FontFamily(
            Font(R.font.pop_300, FontWeight.Light),
            Font(R.font.montserrat_regular, FontWeight.Normal),
            Font(R.font.montserrat_medium, FontWeight.Medium),
            Font(R.font.montserrat_bold, FontWeight.Bold)
        )
        Column (
            modifier = Modifier.fillMaxSize()
//                .padding(150.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,

        ){
            Image(
                painter = painterResource(id = item.imageId),
                contentDescription = null, // Provide a meaningful description
                modifier = Modifier.fillMaxWidth()

                    .height(500.dp)

            )

            Text(text = "${item.title}", fontWeight = FontWeight.Bold, fontFamily = firaSansFamily, fontSize = 28.sp)
            Text(text = "${item.description}", modifier = Modifier.fillMaxWidth()
                .padding(start = 25.dp)
                .padding(end = 25.dp)
                .padding(top = 20.dp)
                .align(alignment = Alignment.CenterHorizontally),

                fontWeight = FontWeight.Medium, fontFamily = firaSansFamily
            )

            // Display other details as needed
            Button(onClick = { navController.popBackStack() }, modifier= Modifier.fillMaxWidth()

                .padding(top =20.dp)
                .padding(start = 150.dp)
                .padding(end = 150.dp)
                .padding(bottom = 0.dp)

            ) {
                Text(text = "Back")
            }

        }
    }

    // Example of navigating back

}

// Function to get the selected item by ID
fun getItemById(itemId: Int): Item? {
    // Replace this logic with your actual data retrieval mechanism
    val itemList = generateItemList()
    return itemList.find { it.id == itemId }
}
