
//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.users;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import LearningManagementSystem.mainManagementSystem.LearningPath;
import LearningManagementSystem.mainManagementSystem.activities.Actividad;
import LearningManagementSystem.mainManagementSystem.activities.Encuesta;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.Pregunta;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.PreguntaAbierta;

// import Usuario;


//====================================================================================
// Definicion de la clase Profesor
//====================================================================================

public class Profesor extends Usuario  {
    
	//----------------------------------------------------------------------
	// Definicion de atributos
	

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    
    public Profesor(String username, String password, String email) {
        super(username, password,email);
    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    

    // Getters


    public void crearActividadEnLearningPath(){

    }

    public void crearLearingPath(){

    }
    
    public void clonarActividad(){

    }

    public void cambiarEstadoActividad(Actividad actividad, String estado) {
        actividad.setEstado(estado); // impelementar setEstado
        System.out.println("El estado de la actividad ha sido cambiado a: " + estado);
    }

    public void addPreguntaEncuesta(Encuesta encuesta, String enunciado, String retroalimentacion){
        Pregunta pregunta = new PreguntaAbierta(enunciado, retroalimentacion, true);
        
        encuesta.agregarPregunta(pregunta);
    }


    public void visualizarEncuestas() {

    }


    public void addFeedBack(){

    }

    public LearningPath crearLearningPath(String titulo, String descripcion, String duracion) {
        return new LearningPath(titulo, descripcion, duracion);
    }

    // Clonacion -- Falta 





}