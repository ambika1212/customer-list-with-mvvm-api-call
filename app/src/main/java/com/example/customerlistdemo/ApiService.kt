package com.example.customerlistdemo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/CustomerDetails/GetCustomerDetails")
    fun getCustomerDetails(
        @Query("pageno") pageNo: Int = 1,
        @Query("pagesize") pageSize: Int = 10,
        @Query("UnitId") unitId: Int = 787
    ): Call<ApiResponse>
}
