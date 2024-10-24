//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities;

import LearningManagementSystem.mainManagementSystem.activities.activityElements.*;


//Estructuras de datos
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.lang.String;

//====================================================================================
//Definicion de la clase Tarea
//====================================================================================

public class Tarea extends Actividad {
	
    //----------------------------------------------------------------------
	// Definicion de atributos
    private String metodoEnvio;

    //----------------------------------------------------------------------
	// Metodo constructor de la clase.
	
	public Tarea (String nombre, String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador, String NewMetodoEnvio) {
        super(nombre ,descripcion, objetivo, dificultad, tiempoEstimado, fechaDeCierre, obligatoria, creador);
        this.metodoEnvio = NewMetodoEnvio;
    }

    //Getters
    public String getMetodoEnvio (){
        return this.metodoEnvio;
    }
    //Setters
    //Metodos
    // public void enviarExamen(){}
}

