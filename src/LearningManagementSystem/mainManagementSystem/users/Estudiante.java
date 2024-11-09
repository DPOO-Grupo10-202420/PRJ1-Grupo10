//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.users;
import LearningManagementSystem.mainManagementSystem.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.mainManagementSystem.activities.Actividad;
import LearningManagementSystem.mainManagementSystem.activities.Encuesta;
import LearningManagementSystem.mainManagementSystem.activities.Examen;
import LearningManagementSystem.mainManagementSystem.activities.Quiz;
import LearningManagementSystem.mainManagementSystem.activities.Recurso;
import LearningManagementSystem.mainManagementSystem.activities.Tarea;

// import Usuario;


//====================================================================================
// Definicion de la clase Estudiante
//====================================================================================

public class Estudiante extends Usuario  {
    
	//----------------------------------------------------------------------
	// Definicion de atributos
    private LearningPath studentCurrentLearningPath;
    private HashMap<String, Actividad> studentCompletedActivities = new HashMap<String, Actividad>();
    private Actividad studentCurrentActivity;
    private HashMap<String, LearningPath> completedLearningPaths =  new HashMap<String, LearningPath>();

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

    public boolean estaEscritoEnUnLearningPath () {
        return (studentCurrentLearningPath != null);
    }

    public LearningPath getStudentCurrentLearningPath (){
        return this.studentCurrentLearningPath;
    }

    public Actividad getStudentCurrentActivity (){
        return this.studentCurrentActivity;
    }

    public HashMap<String, Actividad> getCompletedActivities(){
        return this.studentCompletedActivities;
    }



    // Metodos

public void salirseLearningPath(){
        this.studentCurrentLearningPath = null;
    }

    public void finalizarLearningPath(){
        this.completedLearningPaths.put(this.studentCurrentLearningPath.getTitulo(), this.studentCurrentLearningPath);
        this.studentCurrentLearningPath = null;
    }

    public void iniciarActividad(Actividad actividad){
        this.studentCurrentActivity = actividad;
    }


    public void terminarActividad(){

        if (studentCurrentActivity == null) {
            System.out.println("No hay ninguna actividad en curso.");
            return;
        }
        
        if (studentCurrentActivity instanceof Encuesta) {
            studentCurrentActivity.marcarComoExitosa(); 
        } 
        
        else if (studentCurrentActivity instanceof Tarea) {
            studentCurrentActivity.marcarComoEnviada(); 
            
        } 
        
        else if (studentCurrentActivity instanceof Examen) {
            studentCurrentActivity.marcarComoEnviada(); }
            
        else if (studentCurrentActivity instanceof Quiz) {
            if (((Quiz) studentCurrentActivity).aprobado()) {
                studentCurrentActivity.marcarComoExitosa();
            }
            else {
                studentCurrentActivity.marcarComoNoExitosa();
            }

        } 
        
        else if (studentCurrentActivity instanceof Recurso) {
            studentCurrentActivity.marcarComoExitosa();
        }


        

        studentCompletedActivities.put(studentCurrentActivity.getNombre(), studentCurrentActivity);
        studentCurrentActivity = null;

        if (studentCompletedActivities.size() == studentCurrentLearningPath.getSecuenciaActividades().size()) {
            completedLearningPaths.put(studentCurrentLearningPath.getTitulo(), studentCurrentLearningPath);
            studentCurrentLearningPath = null;
            System.out.println("Finalizó el Learning Path, ahora puede inscribirse a uno nuevo.");
        }
    }
}
