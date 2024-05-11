package com.example.easetrip.ui.theme.screens.flights

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text


import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.easetrip.data.FlightViewModel
import com.example.easetrip.flight
import com.example.easetrip.flights
import com.example.easetrip.models.Flight


@Composable
fun ViewFlightsScreen(navController: NavHostController){

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = FlightViewModel(navController, context)


        val emptyProductState = remember { mutableStateOf(Flight("","","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Flight>() }

        var flights = productRepository.allProducts(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All flights",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(flights){
                    FlightItem(
                        name = it.name,
                        status = it.status,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository,
                        flightImage = it.imageUrl
                    )
                }


            }
        }
    }
}




@Composable
fun FlightItem(name:String, status:String, price:String, id:String,
                navController:NavHostController,
                productRepository:FlightViewModel, flightImage:String) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = status)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = price)
        Image(
            painter = rememberAsyncImagePainter(flightImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Button(onClick = {
            productRepository.deleteProduct(id)
        }) {
            Text(text = "Delete")

        }
        Button(onClick = {
            //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text  = "Update")
        }
    }

}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ViewFlightsScreenPreview(){
    ViewFlightsScreen(rememberNavController())
}