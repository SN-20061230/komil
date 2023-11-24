package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.Navigation.Screens

@Composable
fun HomeScreen(navController: NavController) {
    val itemList = remember { generateItemList() } // Your list of items

    LazyVerticalGrid( modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(count = 1)) {
        items(itemList) {
            OneItem(it, navController)
        }
    }
}

@Composable
fun OneItem(itemData: Item, navController: NavController){
    val firaSansFamily = FontFamily(
        Font(R.font.pop_300, FontWeight.Light),
        Font(R.font.montserrat_regular, FontWeight.Normal),
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_bold, FontWeight.Bold)
    )
    Card(
        modifier = Modifier
            .wrapContentWidth()

            .padding(8.dp)
    ) {
        var isClicked by remember {
            mutableStateOf(false)
        }

        val painterResource: Painter = if (isClicked) {
            painterResource(id = R.drawable.baseline_favorite_24)
        } else {
            painterResource(id = R.drawable.baseline_favorite_border_24)
        }
        IconButton(
            onClick = { isClicked = !isClicked },
            Modifier.align(Alignment.End)
        ) {

            Image(
                painter = painterResource,
                contentDescription = null
            )

        }
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = itemData.imageId),
                contentDescription = null, // Provide a meaningful description
                modifier = Modifier.fillMaxWidth().clickable {
                    navController.navigate("${Screens.detail.route}/${itemData.id}")
                }
                    .height(210.dp),
                contentScale = ContentScale.Crop // Adjust as needed


            )





        }



        Text(  modifier = Modifier.clickable {
            navController.navigate("${Screens.detail.route}/${itemData.id}")
        }
            .padding(8.dp),
            text = itemData.title,
            fontWeight = FontWeight.Medium, fontFamily = firaSansFamily


        )
        Spacer(modifier = Modifier.height(18.dp))




        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null, // Provide a meaningful description
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp),
                contentScale = ContentScale.Crop // Adjust as needed


            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(text = itemData.price,
                fontWeight = FontWeight.Medium, fontFamily = firaSansFamily

            )

        }




    }
}
// Generate some dummy items for demonstration
fun generateItemList(): List<Item> {
    return listOf(
        Item(1, R.drawable.car3, "Jaguar E-Type","The Jaguar E-Type, or the Jaguar XK-E for the North American market," +
                " is a British sports car that was manufactured by Jaguar Cars Ltd between" +
                " 1961 and 1974. Its combination of aesthetics, high performance, and " +
                "competitive pricing established the model as an icon of the motoring world.", "180,000"),
        Item(2, R.drawable.car4, "Nissan Silvia","The Nissan Silvia is the series of small sports cars produced by Nissan. Versions of the Silvia have been marketed as the 200SX or 240SX for export, with some export versions being sold under the Datsun brand.", "126,000"),
        Item(3, R.drawable.car1, "BMW I7","G70 is the internal designation for the seventh generation of the BMW 7 Series, a range of luxury cars produced by the German luxury vehicle manufacturer BMW since July 2022.", "105,000"),
        Item(4, R.drawable.car2, "Lamborghini Urus","The Lamborghini Urus is a luxury SUV manufactured by Italian automobile manufacturer Lamborghini. It was introduced in December 2017 as a 2018 model year", "300,000"),

        Item(5, R.drawable.car5, "Lamborghini Huracan","The Lamborghini Huracán is a sports car manufactured by Italian automotive manufacturer Lamborghini replacing the previous V10 offering, the Gallardo.", "400,000"),

        Item(6, R.drawable.car4, "Nissan Silvia","The Nissan Silvia is the series of small sports cars produced by Nissan. Versions of the Silvia have been marketed as the 200SX or 240SX for export, with some export versions being sold under the Datsun brand.", "126,000"),

        Item(7, R.drawable.car2, "Lamborghini Urus","The Lamborghini Urus is a luxury SUV manufactured by Italian automobile manufacturer Lamborghini. It was introduced in December 2017 as a 2018 model year", "300,000"),
        Item(8, R.drawable.car3, "Jaguar E-Type","The Jaguar E-Type, or the Jaguar XK-E for the North American market," +
                " is a British sports car that was manufactured by Jaguar Cars Ltd between" +
                " 1961 and 1974. Its combination of aesthetics, high performance, and " +
                "competitive pricing established the model as an icon of the motoring world.", "180,000"),
        Item(9, R.drawable.car5, "Lamborghini Huracan","The Lamborghini Huracán is a sports car manufactured by Italian automotive manufacturer Lamborghini replacing the previous V10 offering, the Gallardo.", "400,000"),
        Item(10, R.drawable.car1, "BMW I7","G70 is the internal designation for the seventh generation of the BMW 7 Series, a range of luxury cars produced by the German luxury vehicle manufacturer BMW since July 2022.", "105,000"),

        // Add more items as needed
    )
}

