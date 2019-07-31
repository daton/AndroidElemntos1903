package org.unitec.androidelemntos1903

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ServicioProfesor {


    @POST("api/profesor")
    fun guardar(@Body profesor:Profesor): Call<Estatus>

    @POST("api/profesor/autenticar")
    fun autenticar(@Body profesor:Profesor):Call<Profesor>

    @GET("api/profesor/{clave}")
    fun buscarPorClave(@Path("clave") clave:String?):Call<Profesor>

    @GET("api/profesor")
    fun buscarTodos():Call<ArrayList<Profesor>>
}