//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities;

import LearningManagementSystem.mainManagementSystem.activities.activityElements.*;


//Estructuras de datos
import java.util.ArrayList;
import java.util.Date;
//====================================================================================
//Definicion de la clase Examen
//====================================================================================

public class Examen extends Actividad {
	
    //----------------------------------------------------------------------
	// Definicion de atributos
	private ArrayList<PreguntaAbierta> preguntas = new ArrayList<PreguntaAbierta>();
    private double calificacionMinima = 3;
    private double calificacionObtenida;

    //----------------------------------------------------------------------
	// Metodo constructor de la clase.
	
	public Examen (String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador) {
        super(descripcion, objetivo, dificultad,  tiempoEstimado, fechaDeCierre, obligatoria, creador);
    }

    //Getters
    public double getCalificacionObtenida (){
        return this.calificacionObtenida;
    }

    //Setters
    public void setCalificacionObtenida (Double newCalificacion){
        this.calificacionObtenida = newCalificacion;
    }

    public void agregarPregunta(PreguntaAbierta pregunta) {
        this.preguntas.add(pregunta);
    }

    //Metodos
    public void enviarExamen(){}
}

