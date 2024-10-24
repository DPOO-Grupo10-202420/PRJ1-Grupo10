//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities;

import LearningManagementSystem.mainManagementSystem.activities.activityElements.*;


//Estructuras de datos
import java.util.Date;
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
    public Recurso (String nombre ,String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador, String tiporecurso, String URLRecurso) {
        super(nombre ,descripcion, objetivo, dificultad, tiempoEstimado, fechaDeCierre, obligatoria, creador);
        this.tipoRecurso = tipoRecurso;
        this.URLRecurso = URLRecurso;
    }

    //Getters
    public String getTipoRecurso (){
        return this.tipoRecurso;
    }

    public String getURLRecurso (){
        return this.URLRecurso;

    }
}

