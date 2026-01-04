package com.jshells.apprestofood.data

data class User (
    val id: Int,
    val name: String,
    val deliveryAddress: String,
    val email: String,
    val password: String
)