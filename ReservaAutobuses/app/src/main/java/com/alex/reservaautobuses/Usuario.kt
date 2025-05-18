package com.alex.reservaautobuses

data class Usuario(
    val id: Long? = null,
    val nombre: String,
    val email: String,
    val password: String,
    val reservas: List<Reserva>? = null
) {

}
