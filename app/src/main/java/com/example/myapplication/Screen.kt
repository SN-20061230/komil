package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.Navigation.Screens
import androidx.compose.ui.res.imageResource
@Composable
fun HomeScreen(navController: NavController) {

    var isClicked by remember {
        mutableStateOf(false)
    }

    val painterResource: Painter = if (isClicked) {
        painterResource(id = R.drawable.liked_fill)
    } else {
        painterResource(id = R.drawable.liked)
    }
    val itemList = remember { generateItemList() } // Your list of items
    val firaSansFamily = FontFamily(
        Font(R.font.pop_300, FontWeight.Light),
        Font(R.font.montserrat_regular, FontWeight.Normal),
        Font(R.font.montserrat_medium, FontWeight.Medium),
        Font(R.font.montserrat_bold, FontWeight.Bold)
    )


    LazyVerticalGrid( modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(count = 2)) {
        items(itemList) {
            Card(
                modifier = Modifier
                    .wrapContentWidth()

                    .padding(8.dp)
            ) {

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
                        painter = painterResource(id = it.imageId),
                        contentDescription = null, // Provide a meaningful description
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("${Screens.detail.route}/${it.id}")
                            }
                            .height(210.dp),
                        contentScale = ContentScale.Crop // Adjust as needed


                    )





                }













                Text(  modifier = Modifier
                    .clickable {
                        navController.navigate("${Screens.detail.route}/${it.id}")
                    }
                    .padding(8.dp),
                    text = it.title,
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

                    Text(text = it.price,
                        fontWeight = FontWeight.Medium, fontFamily = firaSansFamily

                        )

                }




            }
        }
    }
}


