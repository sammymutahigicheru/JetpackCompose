package com.sammy.jetpackcompose.data

data class AssetsResponseItem(
    val batchNumber: String,
    val createdBy: String,
    val creatorUserEmail: String,
    val customerCode: String,
    val customerName: String,
    val dateCreated: String,
    val dateModified: String,
    val deliveryPointCode: String,
    val deliveryPointName: String,
    val id: String,
    val modifiedBy: String,
    val modifierUserEmail: Any,
    val orderTotal: Double,
    val remarks: String,
    val rowNumber: Int,
    val salesAreaCode: String,
    val salesAreaName: String,
    val status: String,
    val userPhoneNumber0: String
)