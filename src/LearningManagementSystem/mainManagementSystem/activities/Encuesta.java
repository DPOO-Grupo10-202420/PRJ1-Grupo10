//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================
package LearningManagementSystem.mainManagementSystem.activities;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.*;

//Estructuras de datos
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
//====================================================================================
//Definicion de la clase Encuesta
//====================================================================================
public class Encuesta extends Actividad {

	private List<Pregunta> preguntas = new ArrayList<Pregunta>();

    //----------------------------------------------------------------------
	// Metodo constructor de la clase.
	public Encuesta (String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador) {
        super(descripcion, objetivo, dificultad,  tiempoEstimado, fechaDeCierre, obligatoria, creador);
    }

    // Getters
    public String getRespuestasDePregunta (Pregunta pregunta){
        if (pregunta instanceof PreguntaAbierta){
            return ((PreguntaAbierta) pregunta).getRespuesta();
        } else {
            return ((PreguntaMultiple) pregunta).getRespuestaCorrecta();
        }
    }

    //Metodos
    public void agregarPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
    }

    // public void agregarRespuesta(String pregunta, String respuesta) {
    //     Pregunta pregunta = this.preguntas.get(pregunta).add(respuesta); // Este metodo es de pregunta
    // }

    public void enviarEncuesta () {}
}

