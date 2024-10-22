//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.users;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// import Usuario;


//====================================================================================
// Definicion de la clase Estudiante
//====================================================================================

public class Estudiante extends Usuario  {
    
	//----------------------------------------------------------------------
	// Definicion de atributos
	
    private LearningPath studentCurrentLearningPath;
    private HashMap<String, LearningPath> completedLearningPaths;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    
    public Estudiante(String username, String password, String email) {

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

    public void cambiarEstadoActividad() {

    }

    public void visualizarEncuestas() {

    }

    public void addPreguntaEncuesta(){

    }

    public void addFeedBack(){

    }
        







}
