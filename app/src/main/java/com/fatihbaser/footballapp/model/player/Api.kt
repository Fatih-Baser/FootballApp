package com.fatihbaser.footballapp.model.player


import com.google.gson.annotations.SerializedName

data class Api(
    @SerializedName("results")
    var results: Int,
    @SerializedName("players")
    var players: List<Player>
)