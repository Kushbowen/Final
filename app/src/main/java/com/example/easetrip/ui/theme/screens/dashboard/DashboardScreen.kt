package com.example.easetrip.ui.theme.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import android.animation.ObjectAnimator
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.easetrip.R
import com.example.easetrip.navigation.ROUT_HOME
import com.example.easetrip.ui.theme.blue1
import com.example.easetrip.ui.theme.screens.login.LoginScreen
import com.google.android.gms.dynamic.IFragmentWrapper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val mContext = LocalContext.current
        TopAppBar(title = { Text(text = "EaseTrip", color = Color.White) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Blue),
            navigationIcon =
            {
                IconButton(onClick = {
                    
                }) {

                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "menu",
                        tint = Color.White,
                        modifier = Modifier
                        .clickable {
                            navController.navigate(ROUT_HOME)
                            Toast.makeText(mContext,
                                "Opening HomeScreen",
                                Toast.LENGTH_SHORT).show()
                        }

                    )


                }
            }
        )


        //End of TopAppbar

        Text(
            text = "Inspiration for you",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = "Recommended destinations",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 35.sp,
            fontFamily = FontFamily.SansSerif
        )


        Spacer(modifier = Modifier.height(20.dp))
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            //start of row
            Row(
                modifier = Modifier
                    .horizontalScroll(
                        rememberScrollState()
                    )
            ) {

                Card(
                    modifier = Modifier
                        .height(400.dp)
                        .width(200.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = com.example.easetrip.R.drawable.nairobi1),
                                contentDescription = "Savannah",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 200.dp, height = 400.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Let's Discover together",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.BottomStart)
                            )


                        }


                    }


                }
                Spacer(modifier = Modifier.width(10.dp))



                Card(
                    modifier = Modifier
                        .height(400.dp)
                        .width(200.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = com.example.easetrip.R.drawable.m1),
                                contentDescription = "Savannah",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 200.dp, height = 400.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Save up to 40% on flights",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.BottomStart)
                            )


                        }


                    }


                }
                Spacer(modifier = Modifier.width(10.dp))

                Card(
                    modifier = Modifier
                        .height(400.dp)
                        .width(200.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = com.example.easetrip.R.drawable.k1),
                                contentDescription = "Savannah",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 200.dp, height = 400.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Let's go on a tour",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.BottomStart)
                            )


                        }


                    }


                }
                Spacer(modifier = Modifier.width(10.dp))
                Card(
                    modifier = Modifier
                        .height(400.dp)
                        .width(200.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = com.example.easetrip.R.drawable.e1),
                                contentDescription = "Savannah",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 200.dp, height = 400.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Begin your adventure",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.BottomStart)
                            )


                        }


                    }


                }

                //end of cards
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .horizontalScroll(
                        rememberScrollState()
                    )
            ) {

                Card(
                    modifier = Modifier
                        .height(400.dp)
                        .width(200.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = com.example.easetrip.R.drawable.nairobi2),
                                contentDescription = "Savannah",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 200.dp, height = 400.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Visit and enjoy",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.BottomStart)
                            )


                        }


                    }


                }
                Spacer(modifier = Modifier.width(10.dp))



                Card(
                    modifier = Modifier
                        .height(400.dp)
                        .width(200.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = com.example.easetrip.R.drawable.m2),
                                contentDescription = "Savannah",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 200.dp, height = 400.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Dive into paradise",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.BottomStart)
                            )


                        }


                    }


                }
                Spacer(modifier = Modifier.width(10.dp))

                Card(
                    modifier = Modifier
                        .height(400.dp)
                        .width(200.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = com.example.easetrip.R.drawable.k2),
                                contentDescription = "Savannah",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 200.dp, height = 400.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "A haven for nature lovers",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.BottomStart)
                            )


                        }


                    }


                }
                Spacer(modifier = Modifier.width(10.dp))
                Card(
                    modifier = Modifier
                        .height(400.dp)
                        .width(200.dp)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(500.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(id = com.example.easetrip.R.drawable.e2),
                                contentDescription = "Savannah",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 200.dp, height = 400.dp),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                text = "Enjoy your visit",
                                fontSize = 25.sp,
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                modifier = Modifier.align(Alignment.BottomStart)
                            )


                        }


                    }


                }

            }


        }
    }
}



@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())

}
