package org.unitec.androidelemntos1903

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Invocamos el id que se llama guardarProfesor
        guardarProfesor.setOnClickListener {

            //Creamos un objeto de tipo TareaGurdarProferor
        TareaGuardarProfesor(this, this).execute()

        }
    }
}
