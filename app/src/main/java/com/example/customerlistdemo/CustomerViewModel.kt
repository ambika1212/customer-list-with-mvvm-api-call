package com.example.customerlistdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomerViewModel : ViewModel() {

    private val _customerList = MutableLiveData<List<Customer>>()
    val customerList: LiveData<List<Customer>> = _customerList

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun fetchCustomerDetails() {
        val apiService = RetrofitClient.instance
        apiService.getCustomerDetails().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val customers = response.body()?.responseData ?: emptyList()
                    _customerList.postValue(customers)
                } else {
                    _error.postValue("Failed to retrieve data")
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                _error.postValue("Error: ${t.message}")
            }
        })
    }
}
