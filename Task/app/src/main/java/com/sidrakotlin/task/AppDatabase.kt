package com.sidrakotlin.task

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun productDao():ProductDao

    companion object{
        private var instance:AppDatabase?=null


        fun getInstance(context: Context):AppDatabase
        {
            @Volatile
            if(instance==null)
            {


                synchronized(this)
                {


                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "myinventdb"
                    )
                        .build()
                }
            }
            return instance!!
        }

    }
}