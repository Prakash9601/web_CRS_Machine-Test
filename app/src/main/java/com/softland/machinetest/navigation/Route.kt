package com.softland.machinetest.navigation

import com.softland.machinetest.utils.Const.LISTINGPAGE
import com.softland.machinetest.utils.Const.LISTINGPAGEDETAILS


sealed class Route(val route: String) {
    object Listing: Route(LISTINGPAGE)
    object ListingDetails: Route(LISTINGPAGEDETAILS)
}
