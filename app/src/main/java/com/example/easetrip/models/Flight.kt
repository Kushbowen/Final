package com.example.easetrip.models

class Flight {
    var name:String = ""
    var status:String = ""
    var price:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, status: String, price: String, imageUrl: String, id: String) {
        this.name = name
        this.status = status
        this.price = price
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}