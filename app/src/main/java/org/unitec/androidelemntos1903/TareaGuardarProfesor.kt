package org.unitec.androidelemntos1903

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class TareaGuardarProfesor(var ctx: Context, var activity:MainActivity)
    :AsyncTask<Void,Void,Void>() {

    var profesor=Profesor()
    var estatus=Estatus()

    override fun onPreExecute() {
        super.onPreExecute()
        //Vamos a pedir la info al layou asociado a nuestra activity
      profesor.clave=  activity.txtClave.text.toString().toInt()
      profesor.nombre=  activity.txtNombre.text.toString()
      profesor.email=   activity.txtEmail.text.toString()
    }

    override fun doInBackground(vararg p0: Void?): Void? {

        // Aqui vamos a preparar nuestro objeto alumno que ya tenemos para enviar a
        // El back-end
        //Aqui usaremos la bibloteca REtrofir que es muy iportante

        var retrofit= Retrofit.Builder()
            .baseUrl("https://topotiyo.herokuapp.com/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        var servicioProfesor=retrofit.create(ServicioProfesor::class.java)
        var envio=servicioProfesor.guardar(profesor)
        estatus=envio.execute().body()!!



        return null
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)

        Toast.makeText(ctx,estatus.mensaje,Toast.LENGTH_LONG).show()
    }
}