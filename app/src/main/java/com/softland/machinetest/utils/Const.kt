package com.softland.machinetest.utils

import android.content.Context
import android.widget.Toast


object Const {
    const val BASE_URL = "https://fakestoreapi.com/"
    const val DATABASE_NAME = "Product"
    const val LISTINGPAGE="ListingPage"
    const val LISTINGPAGEDETAILS="ListingDetails"


    fun showToast(context: Context?, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}