package com.example.easetrip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class InsertActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            firebaseUI()

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firebaseUI() {
    val context= LocalContext.current
    val fullname = remember { mutableStateOf("") }
    val departure = remember { mutableStateOf("") }
    val destination = remember { mutableStateOf("") }
    val departuredate = remember { mutableStateOf("") }



    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Book Flights",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive
        )

        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = R.drawable.plane),
            contentDescription = "flights",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = fullname.value,
            onValueChange = { fullname.value = it },
            placeholder = { Text(text = "Enter your fullname") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = destination.value,
            onValueChange = { destination.value = it },
            placeholder = { Text(text = "Enter your destination") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            value = departure.value,
            onValueChange = { departure.value = it },
            placeholder = { Text(text = "Enter your departure") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        OutlinedTextField(
            value = departuredate.value,
            onValueChange = { departuredate.value = it },
            placeholder = { Text(text = "Enter your departure date") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )


        Spacer(modifier = Modifier.height(5.dp))

        Button(
            onClick = {
                if (TextUtils.isEmpty(fullname.value.toString())) {
                    Toast.makeText(context, "Please enter your fullname", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(destination.value.toString())) {
                    Toast.makeText(context, "Please enter your destination", Toast.LENGTH_SHORT)
                        .show()
                } else if (TextUtils.isEmpty(departure.value.toString())) {
                    Toast.makeText(
                        context,
                        "Please enter your departure ",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                else if (TextUtils.isEmpty(departuredate.value.toString())) {
                    Toast.makeText(
                        context,
                        "Please enter your departure date ",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }else {
                    addDataToFirebase(
                        fullname.value, destination.value, departure.value, departuredate.value,context
                    )
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(Blue),
            shape = RoundedCornerShape(5.dp)
        ) {

            Text(text = "Add Flight", modifier = Modifier.padding(8.dp))
        }

        Spacer(modifier = Modifier.height(5.dp))


        Text(
            text = "View Flights booked",
            color = Blue,
            modifier = Modifier
                .clickable {
                    context.startActivity(Intent(context, DetailsActivity::class.java))
                }
                .padding(8.dp))
    }

}



fun addDataToFirebase(fullName: String, destination: String, departure: String,
                      departuredate: String,
                      context: Context
) {
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val dbflights: CollectionReference = db.collection("Flights")
    val flights = flight(fullName, destination, departure, departuredate)
    dbflights.add(flights).addOnSuccessListener {
        Toast.makeText(context, "Your Flight has been added to Firebase Firestore", Toast.LENGTH_SHORT).show()

    }.addOnFailureListener { e ->
        Toast.makeText(context, "Fail to add flight", Toast.LENGTH_SHORT).show()
    }

}

@Preview(showBackground = true)
@Composable
fun FirebaseUiPreview() {
    firebaseUI()
}