package com.example.customerlistdemo

data class ApiResponse(
    val statusCode: String,
    val statusMessage: String,
    val responseData: List<Customer>,
    val responseData1: PageInfo
)

data class Customer(
    val customerId: Int,
    val fName: String,
    val mobileNo: String,
    val lName:String,
    val isCow: Int,
    val isBuffalo: Int
)

data class PageInfo(
    val pageNo: Int,
    val totalPages: Int,
    val pageCount: Int
)
