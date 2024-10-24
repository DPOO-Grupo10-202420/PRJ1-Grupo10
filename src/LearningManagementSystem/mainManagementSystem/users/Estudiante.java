//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.users;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.mainManagementSystem.activities.Actividad;

// import Usuario;


//====================================================================================
// Definicion de la clase Estudiante
//====================================================================================

public class Estudiante extends Usuario  {
    
	//----------------------------------------------------------------------
	// Definicion de atributos
    private LearningPath studentCurrentLearningPath;
    private Actividad studentCurrentActivity;
    private HashMap<String, LearningPath> completedLearningPaths;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public Estudiante(String username, String password, String email) {
        super(username, password,email);
    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    // Getters
    public void addFeedBack(){
        // TODO implementar donde se que vaya el feedback
    }

    public void iniciarLearningPath(LearningPath learningPath){
        this.studentCurrentLearningPath = learningPath;
    }

    public void salirseLearningPath(){
        this.studentCurrentLearningPath = null;
    }

    public void finalizarLearningPath(){
        this.completedLearningPaths.put(this.studentCurrentLearningPath.getTitulo(), this.studentCurrentLearningPath);
        this.studentCurrentLearningPath = null;
    }

    public void iniciarActividad(Actividad actividad){
        this.studenCurrenteActivity = actividad;
    }

    public void terminarActividad(){
        this.studenCurrenteActivity = null;
    }
}
