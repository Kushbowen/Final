package com.example.easetrip

import com.google.firebase.firestore.Exclude

data class flights(
    @Exclude var flightID: String? = "",
    var fullname: String? = "",
    var destination: String? = "",
    var departure: String? = "",
    var departuredate : String= ""
)
