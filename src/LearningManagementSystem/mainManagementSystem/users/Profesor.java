
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


    public void crearActividad(){

    }

    public void crearLearingPath(){

    }
    
    public void clonarActividad(){

    }

    public void cambiarEstadoActividad(Actividad actividad, String estado) {
        actividad.setEstado(estado); // impelementar setEstado
        System.out.println("El estado de la actividad ha sido cambiado a: " + estado);
    }


    public void visualizarEncuestas() {

    }

    public void addPreguntaEncuesta(){

    }

    public void addFeedBack(){

    }


    
    public LearningPath crearLearningPath(String titulo, String descripcion) {
        return new LearningPath(titulo, descripcion);
    }
    
    // Clonacion -- Falta 

    public void cambiarEstadoActividad(Actividad actividad, String estado) {
        actividad.setEstado(estado);
    }



}