package com.fatihbaser.footballapp.model.statistic


import com.google.gson.annotations.SerializedName

data class TotalShots(
    @SerializedName("home")
    var home: String,
    @SerializedName("away")
    var away: String
)