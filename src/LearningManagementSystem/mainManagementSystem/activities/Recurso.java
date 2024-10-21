//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities;

import LearningManagementSystem.mainManagementSystem.activities.activityElements.*;


//Estructuras de datos
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


//====================================================================================
//Definicion de la clase Recurso
//====================================================================================

public class Recurso extends Actividad {
	
    //----------------------------------------------------------------------
	// Definicion de atributos

    private String tipoRecurso;
    private String URLRecurso;

    //----------------------------------------------------------------------
	// Metodo constructor de la clase.
	
	public Recurso (String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador) {

        super(descripcion, objetivo, dificultad,  tiempoEstimado, fechaDeCierre, obligatoria, creador);

    }


    //Getters
    public String getTipoRecurso (){
        return this.tipoRecurso;

    }

    public String getURLRecurso (){
        return this.URLRecurso;

    }


    //Setters


    //Metodos





	
	
}

