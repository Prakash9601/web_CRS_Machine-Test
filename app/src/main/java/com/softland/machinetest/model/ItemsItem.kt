package com.softland.machinetest.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson

@Entity
data class ItemsItem(
    var category: String?,
    var description: String?,
    @PrimaryKey var id: Int?,
    var image: String?,
    var price: Double?,
    var rating: Rating?,
    var title: String?
)

data class Rating(
    val count: Int?,
    val rate: Double?
)

class Converters {
    @TypeConverter
    fun fromRating(rating: Rating?): String? {
        return rating?.let { Gson().toJson(it) }
    }

    @TypeConverter
    fun toRating(value: String?): Rating? {
        return value?.let { Gson().fromJson(it, Rating::class.java) }
    }
}

