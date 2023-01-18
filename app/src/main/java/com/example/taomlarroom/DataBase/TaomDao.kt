package com.example.taomlarroom.DataBase

import androidx.room.*
import com.example.taomlarroom.Taomlar

@Dao
interface TaomDao {
    @Query("SELECT * FROM Taomlar")
    fun getAllTaoms(): List<Taomlar>

    @Query("SELECT id FROM TAOMLAR WHERE name =:uName")
    fun getTaomlarById(uName: String): Int

    @Insert
    fun addTaomlar(taolma: Taomlar)

    @Update
    fun editTaomlar(taolma: Taomlar)

    @Delete
    fun deleteTaomlar(taolma: Taomlar)
}