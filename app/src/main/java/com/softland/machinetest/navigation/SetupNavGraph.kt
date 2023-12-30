package com.softland.machinetest.navigation


import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.softland.machinetest.Screen.ItemDetails
import com.softland.machinetest.Screen.ListingPage
import com.softland.machinetest.navigation.AllDestinations.navController

object AllDestinations {
    @SuppressLint("StaticFieldLeak")
    lateinit var navController :NavHostController
    var itemsId: MutableLiveData<Int>? = MutableLiveData()

}
@Composable
fun SetupNavGraph() {
    navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Listing.route
    ) {
        composable(route = Route.Listing.route) {
            ListingPage()
        }
        composable(route = Route.ListingDetails.route) {
            ItemDetails()
        }
    }
}