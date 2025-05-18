package com.alex.reservaautobuses

data class Reserva(
    val id: Long,
    val trayecto: Trayecto,
    val fechaReserva: String
)