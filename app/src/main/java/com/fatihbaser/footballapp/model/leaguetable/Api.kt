package com.fatihbaser.footballapp.model.leaguetable


import com.google.gson.annotations.SerializedName

data class Api(
    @SerializedName("results")
    var results: Int,
    @SerializedName("standings")
    var standings: List<List<Standing>>
)