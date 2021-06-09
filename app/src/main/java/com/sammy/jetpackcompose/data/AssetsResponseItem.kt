package com.sammy.jetpackcompose.data


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AssetsResponseItem(
    @Json(name = "batchNumber")
    val batchNumber: String,
    @Json(name = "createdBy")
    val createdBy: String,
    @Json(name = "customerCode")
    val customerCode: String,
    @Json(name = "customerName")
    val customerName: String,
    @Json(name = "deliveryPointCode")
    val deliveryPointCode: String,
    @Json(name = "deliveryPointName")
    val deliveryPointName: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "orderTotal")
    val orderTotal: Double,
    @Json(name = "salesAreaCode")
    val salesAreaCode: String,
    @Json(name = "salesAreaName")
    val salesAreaName: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "userPhoneNumber0")
    val userPhoneNumber0: String
)