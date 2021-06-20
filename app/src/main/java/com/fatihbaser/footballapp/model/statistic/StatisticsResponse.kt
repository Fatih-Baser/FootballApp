package com.fatihbaser.footballapp.model.statistic


import com.google.gson.annotations.SerializedName


data class StatisticsResponse(
    @SerializedName("api")
    var api: Api
)