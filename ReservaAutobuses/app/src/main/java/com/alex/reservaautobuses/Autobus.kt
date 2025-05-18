package com.alex.reservaautobuses

data class Autobus(
    val id: Long,
    val matricula: String,
    val capacidad: Int,
    val modelo: String,
)