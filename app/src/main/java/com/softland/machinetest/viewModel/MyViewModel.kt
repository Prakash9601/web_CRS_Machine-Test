package com.softland.machinetest.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softland.machinetest.model.Items
import com.softland.machinetest.model.ItemsItem
import com.softland.machinetest.model.itemsId
import com.softland.machinetest.utils.AppDatabase
import com.softland.machinetest.utils.Const
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(val serviceRepository: ServiceRepository?,@ApplicationContext var context: Context,val appDatabase: AppDatabase?) : ViewModel() {
    var fetchProduct: LiveData<List<ItemsItem?>>? = appDatabase?.ProductDao()?.getAllCategory()
    var getMember = MutableLiveData<itemsId?>()

    init {
        fetchProduct()
    }

    fun fetchProduct() {
        viewModelScope.launch {
            try {
                val response = serviceRepository?.getProduct()
                if (response != null) {
                    if (response.isSuccessful) {
                       insertCategories(response.body())
                    } else {
                        val jObjError = JSONObject(response?.errorBody()?.string()?.trim())
                        Const.showToast(context, jObjError.getString("message"))
                    }
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
                // You can also log the exception or display an error message
            }
        }
    }


    fun fetchProductId(Id:Int) {
        viewModelScope.launch {
            try {
                val response = serviceRepository?.getProductId(Id)
                if (response != null) {
                    if (response.isSuccessful) {
                        getMember.value = response.body()
                    } else {
                        val jObjError = JSONObject(response?.errorBody()?.string()?.trim())
                        Const.showToast(context, jObjError.getString("message"))
                    }
                }
            } catch (e: Exception) {
                // Handle network or other exceptions
                // You can also log the exception or display an error message
            }
        }
    }


     suspend fun insertCategories(body: Items?) {
        body?.map {
            appDatabase?.ProductDao()?.insertItem(it)
        }

    }
}

