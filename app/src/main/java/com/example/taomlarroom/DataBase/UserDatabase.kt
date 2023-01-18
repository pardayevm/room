package com.example.taomlarroom.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taomlarroom.Taomlar

@Database(entities = arrayOf(Taomlar::class), version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun taomlar(): TaomDao

    companion object {
        private var instance: UserDatabase? = null

        @Synchronized
        fun getInstance(context: Context): UserDatabase {
            if (instance == null)
                instance = Room
                    .databaseBuilder(context, UserDatabase::class.java, "Taomlar")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            return instance!!
        }
    }
}