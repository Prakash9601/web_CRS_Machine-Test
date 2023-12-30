package com.softland.machinetest.model


import androidx.annotation.Keep

@Keep
data class itemsId(
    val category: String?,
    val description: String?,
    val id: Int?,
    val image: String?,
    val price: Double?,
    val rating: Rating?,
    val title: String?
)

