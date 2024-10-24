
//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.users;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import LearningManagementSystem.mainManagementSystem.LearningPath;
import LearningManagementSystem.mainManagementSystem.activities.Actividad;
import LearningManagementSystem.mainManagementSystem.activities.Quiz;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.PreguntaMultiple;

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

    // QUIZ
    public Quiz crearQuiz() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del Quiz:");
        String nombre = sc.nextLine();

        System.out.println("Ingrese la descripción del Quiz:");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese el objetivo del Quiz:");
        String objetivo = sc.nextLine();

        System.out.println("Ingrese la dificultad del Quiz:");
        String dificultad = sc.nextLine();

        System.out.println("Ingrese el tiempo estimado (en minutos):");
        int tiempoEstimado = sc.nextInt();

        System.out.println("Ingrese la fecha de cierre (formato: yyyy-MM-dd):");
        String fechaCierreStr = sc.next();  

        // Convertir fecha de cierre (esto es opcional y puede variar según tus necesidades)
        Date fechaDeCierre = new Date();  // Aquí podrías implementar un método que parsee la fecha.

        System.out.println("¿El Quiz es obligatorio? (true/false):");
        boolean esObligatorio = sc.nextBoolean();

        System.out.println("Ingrese la calificación mínima para aprobar:");
        double calificacionMinima = sc.nextDouble();

        Quiz quiz = new Quiz(nombre, descripcion, objetivo, dificultad, tiempoEstimado, fechaDeCierre, esObligatorio, this.getUsername(), calificacionMinima);

        boolean seguirAgregando = true;

        // Ciclo para agregar preguntas
        while (seguirAgregando) {
            sc.nextLine();  // Consumir el salto de línea pendiente
            System.out.println("Ingrese el enunciado de la pregunta:");
            String enunciado = sc.nextLine();

            System.out.println("Ingrese la retroalimentación de la pregunta:");
            String retroalimentacion = sc.nextLine();

            PreguntaMultiple pregunta = new PreguntaMultiple(enunciado, retroalimentacion, false);

            // Ciclo para agregar respuestas a la pregunta
            for (char opcion = 'a'; opcion <= 'd'; opcion++) {
                System.out.println("Ingrese la opción " + opcion + ":");
                String respuesta = sc.nextLine();
                pregunta.addRespuesta(String.valueOf(opcion), respuesta);
            }

            System.out.println("¿Cuál es la clave de la respuesta correcta? (a/b/c/d):");
            String respuestaCorrecta = sc.nextLine();
            pregunta.setRespuestaCorrecta(respuestaCorrecta);

            quiz.agregarPregunta(pregunta);

            System.out.println("¿Desea agregar otra pregunta? (si/no):");
            String continuar = sc.nextLine();
            seguirAgregando = continuar.equalsIgnoreCase("si");
        }
        
        sc.close();
        return quiz;
    }
}

