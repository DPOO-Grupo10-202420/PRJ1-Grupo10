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
import LearningManagementSystem.mainManagementSystem.activities.Quiz;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.Pregunta;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.PreguntaMultiple;
import java.util.Scanner;
// import Usuario;


//====================================================================================
// Definicion de la clase Estudiante
//====================================================================================

public class Estudiante extends Usuario  {
    
	//----------------------------------------------------------------------
	// Definicion de atributos
    private LearningPath studentCurrentLearningPath;
    private Actividad studenCurrenteActivity;
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

    // NUEVOOOOO Para QUI
    public void responderQuiz(Quiz quiz) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Respondiendo el quiz: " + quiz.getDescripcion());

        for (Pregunta pregunta : quiz.getPreguntas()) {
            if (pregunta instanceof PreguntaMultiple) {
                PreguntaMultiple preguntaMultiple = (PreguntaMultiple) pregunta;
                System.out.println(preguntaMultiple.getEnunciado());
                preguntaMultiple.mostrarOpciones();
                
                System.out.print("Ingresa tu respuesta (a, b, c, d): ");
                String respuestaEstudiante = scanner.nextLine();
                preguntaMultiple.setRespuestaEstudiante(respuestaEstudiante);
            }
            scanner.close();
        }

        // Verificar si aprobó el quiz
        if (quiz.aprobado()) {
            System.out.println("¡Felicidades, aprobaste el quiz!");
        } else {
            System.out.println("Lo siento, no aprobaste el quiz.");
        }
    }
        

}
