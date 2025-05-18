package com.alex.reservaautobuses

data class Trayecto(
    val id: Long,
    val origen: String,
    val destino: String,
    val fechaHora: String,
    val autobus: Autobus,
    val reservas: List<Any>? = null
)