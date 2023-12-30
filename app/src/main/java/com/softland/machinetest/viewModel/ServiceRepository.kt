package com.softland.machinetest.viewModel

import com.softland.machinetest.api.MachineTestRetrofit
import com.softland.machinetest.model.Items
import com.softland.machinetest.model.itemsId
import retrofit2.Response
import javax.inject.Inject

class ServiceRepository@Inject constructor(private val service: MachineTestRetrofit?) {
    suspend fun getProduct(
    ): Response<Items?>? {
        return service?.getProduct()
    }

    suspend fun getProductId(id:Int
    ): Response<itemsId?>? {
        return service?.getProductId(id)
    }
}