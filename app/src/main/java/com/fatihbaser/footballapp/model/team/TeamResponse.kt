package com.fatihbaser.footballapp.model.team


import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("api")
    var api: Api
)