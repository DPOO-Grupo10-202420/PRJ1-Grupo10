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
//Definicion de la clase Encuesta
//====================================================================================

public class Encuesta extends Actividad {
	

    //----------------------------------------------------------------------
	// Definicion de atributos

	private HashMap<String, ArrayList<String> > preguntas = new HashMap<String, PreguntaAbierta>();

	
    //----------------------------------------------------------------------
	// Metodo constructor de la clase.
	
	public Encuesta (String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador) {

        super(descripcion, objetivo, dificultad,  tiempoEstimado, fechaDeCierre, obligatoria, creador);


    }


    //Getters

    public ArrayList<PreguntaAbierta> getRespuestasDePregunta (){


    }
	

    //Metodos

    public void agregarPreguntaEncuesta (){


    }


    public void completarEncuesta () {

        
    }




	
	
}

