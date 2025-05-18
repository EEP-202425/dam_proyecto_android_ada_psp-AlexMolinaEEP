package com.alex.reservaautobuses


import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/api/usuarios")
    suspend fun getUsuarios(): List<Usuario>

    @POST("/api/usuarios")
    suspend fun crearUsuario(@Body usuario: Usuario): Usuario

    @DELETE("/api/usuarios/{id}")
    suspend fun eliminarUsuario(@Path("id") id: Long): Response<Unit>


    @GET("/api/trayectos")
    suspend fun getTrayectos(): List<Trayecto>

    @GET("/api/autobuses")
    suspend fun getAutobuses(): List<Autobus>

    @PUT("/api/trayectos/{id}/asignar-autobus")
    suspend fun asignarAutobus(
        @Path("id") trayectoId: Long,
        @Body autobus: Autobus
    ): Trayecto
}

