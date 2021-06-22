package com.fatihbaser.footballapp.localdata

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.fatihbaser.footballapp.model.topscorer.Topscorer


@Dao
interface FootballDao {

    @Insert
    suspend fun insertAllTopscorer(vararg topscorer: Topscorer): List<Long>

    @Query("SELECT * FROM topscorer ORDER BY toplam_gol DESC")
    suspend fun getTopscorer(): List<Topscorer>

    @Query("DELETE FROM topscorer")
    suspend fun deleteTopscorer()

}