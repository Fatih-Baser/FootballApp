package com.fatihbaser.footballapp.model.topscorer


import com.google.gson.annotations.SerializedName

data class Shots(
    @SerializedName("total")
    var total: Int,
    @SerializedName("on")
    var on: Int
)