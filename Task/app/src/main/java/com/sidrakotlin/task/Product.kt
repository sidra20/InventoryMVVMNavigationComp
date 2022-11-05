package com.sidrakotlin.task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class Product(@PrimaryKey(autoGenerate = true)
                   var id:Int=0,

                   @ColumnInfo(name = "name")
                   var name: String?,

                   @ColumnInfo(name = "price")
                   var price: Double?,

                   @ColumnInfo(name = "qty")
                   var qty: Int?


)