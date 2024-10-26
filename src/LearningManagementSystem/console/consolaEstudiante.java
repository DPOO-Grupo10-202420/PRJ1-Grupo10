//====================================================================================
// Importacion de modulos
//====================================================================================
package LearningManagementSystem.console;

import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.console.*;
import LearningManagementSystem.console.ConsolaBasica;

import java.io.IOException;
import LearningManagementSystem.mainManagementSystem.users.*;
import LearningManagementSystem.persistence.*;
import LearningManagementSystem.mainManagementSystem.activities.*;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.Pregunta;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.PreguntaAbierta;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.PreguntaMultiple;

import java.util.List;

public class consolaEstudiante extends ConsolaBasica {

    //------------------------------------------------------
    // Definicion de los atributos

    public boolean appExecutionProfesor = true;
    public LearningManagementSystem currentLearningManagementSystem;
    public Estudiante currentUser;

    //Opciones
    private final String[] opcionesMenuEstudiante = new String[]{ "Visualizar LearinigPath en curso", "Inscribirse a LearnignPath", "LLevar a cabo Actividad", "Cerrar sesión." };
    // Menu para actividades:
    private final String[] opcionesMenuRecurso = new String[]{ "Visualizar LearinigPath en curso", "Marcar como entregado" };
    private final String[] opcionesMenuQuiz = new String[]{ "Visualizar Informacion", "Realizar Quiz" };
    //==================================================================================================================

    // Funciones del Profesor.


    public void visualizarLearningPathEnCurso (){

        if (!currentUser.estaEscritoEnUnLearningPath()){

            System.out.println("No se encuentra inscrito en ningún LearningPath.");

        }
        else {

            LearningPath studentCurrentLearningPath = currentUser.getStudentCurrentLearningPath();

            System.out.println("El LearningPath en el que está inscrito es el siguiente: " + studentCurrentLearningPath.getTitulo());
            System.out.println("\n");
            System.out.println("Actividades del LearningPath: ");

            List <Actividad> secuenciaActividades = studentCurrentLearningPath.getSecuenciaActividades();

            if (secuenciaActividades.size() == 0){

                System.out.println("Ninguna.");

            }

            else {

                for (Actividad elementActividad: secuenciaActividades) {
                    
                    System.out.println("\n");
                    System.out.println("------------------------------------------");
                    System.out.println("Nombre: " + elementActividad.getNombre());
                    System.out.println("------------------------------------------");

                    System.out.println("Descripcion: " + elementActividad.getDescripcion());
                    System.out.println("Objetivo: " + elementActividad.getObjetivo());
                    System.out.println("Dificultad: " + elementActividad.getDificultad());
                    System.out.println("Tiempo estimado: " + elementActividad.getTiempoEstimado() + " minutos.");
                    System.out.println("¿Es obligatoria?: " + elementActividad.getIsObligatoria());
                    System.out.println("Creador: " + elementActividad.getCreador());
                    System.out.println("Rating: " + Double.toString(elementActividad.getRating()) );
                    System.out.println("\n");
                    System.out.println("Estado de la actividad: " + elementActividad.getEstado());
                
                    System.out.println("------------------------------------------");
                    System.out.println("\n");

                }
            }

        }


    }

    public void inscribirseALearningPath () {

        if (currentUser.estaEscritoEnUnLearningPath()){

            System.out.println("Ya se encuentra inscrito en un LearningPath. Debe finalizarlo para inicar uno nuevo.");

        }

    }


    public void realizarActividad () {

        if (!currentUser.estaEscritoEnUnLearningPath()){
            System.out.println("Debe estar inscrito en un LearningPath para poder desarrollar sus Actividades.");
        }
        else {
            String nombreActividad = pedirCadenaAlUsuario("Digite el nombre de la actividad que desea desarrollar");
        }

        Actividad actividad = new 



        if (nombreActividad instanceof Quiz) {
            Quiz quiz = (Quiz) nombreActividad;

            System.out.println("Información del Quiz:");
            System.out.println("Nombre: " + quiz.getNombre());
            System.out.println("Descripción: " + quiz.getDescripcion());
            System.out.println("Objetivo: " + quiz.getObjetivo());
            System.out.println("Dificultad: " + quiz.getDificultad());
            System.out.println("Fecha de cierre: " + quiz.getFechaDeCierre());    

            for (Pregunta pregunta: quiz.getPreguntas()) {
             System.out.println("\nEnunciado: " + pregunta.getEnunciado());
                PreguntaMultiple preguntaMultiple = (PreguntaMultiple) pregunta;
                preguntaMultiple.mostrarOpciones();

                String respuesta = pedirCadenaAlUsuario("Ingrese la opcion correcta (A, B, C o D)");

            }
            double calificacion = quiz.calificar(); // es un porcentaje
            System.out.println("Calificacion obtenida: " + calificacion + "%");
            if (quiz.aprobado()) {
                System.out.println("Ha aprobado el Quiz");
            } else {
                System.out.println("No ha aprobado el Quiz");
            }

            for (Pregunta pregunta : quiz.getPreguntas()) {
                System.out.println("\nEnunciado: " + pregunta.getEnunciado());
                System.out.println("Retroalimentación: " + pregunta.getRetroalimentacion());
            }


            currentUser.terminarActividad();
        } 
        else if (nombreActividad instanceof Examen) {

            Examen examen = (Examen) nombreActividad;

            System.out.println("Información del Examen:");
            System.out.println("Nombre: " + examen.getNombre());
            System.out.println("Descripción: " + examen.getDescripcion());
            System.out.println("Objetivo: " + examen.getObjetivo());
            System.out.println("Dificultad: " + examen.getDificultad());
            System.out.println("Fecha de cierre: " + examen.getFechaDeCierre());
            for (Pregunta pregunta: examen.getPreguntas()) {

                PreguntaAbierta preguntaAbierta = (PreguntaAbierta) pregunta;

                System.out.println("\nEnunciado: " + preguntaAbierta.getEnunciado());
                String respuestaEstudiante = pedirCadenaAlUsuario("Ingrese su respuesta:");

                preguntaAbierta.responder(respuestaEstudiante);
            }
            examen.enviarExamen();

            for (Pregunta pregunta : examen.getPreguntas()) {
                System.out.println("\nEnunciado: " + pregunta.getEnunciado());
                System.out.println("Retroalimentación: " + pregunta.getRetroalimentacion());
            }

            currentUser.terminarActividad();

            System.out.println("Examen completado y enviado. Espere la retroalimentación del profesor.");
        } else if (nombreActividad instanceof Encuesta) {
            Encuesta encuesta = (Encuesta) nombreActividad;
        
            System.out.println("Información de la Encuesta:");
            System.out.println("Nombre: " + encuesta.getNombre());
            System.out.println("Descripción: " + encuesta.getDescripcion());
            System.out.println("Objetivo: " + encuesta.getObjetivo());
            System.out.println("Dificultad: " + encuesta.getDificultad());
            System.out.println("Fecha de cierre: " + encuesta.getFechaDeCierre());
        
            for (Pregunta pregunta : encuesta.getPreguntas()) {
                PreguntaAbierta preguntaAbierta = (PreguntaAbierta) pregunta;
                
                System.out.println("\nEnunciado: " + preguntaAbierta.getEnunciado());
                String respuestaEstudiante = pedirCadenaAlUsuario("Ingrese su respuesta:");
        
                preguntaAbierta.responder(respuestaEstudiante);
            }
        
            encuesta.enviarEncuesta();
            currentUser.terminarActividad();
            System.out.println("Encuesta completada y enviada. Gracias por tus respuestas.");
        }


        //  if (studentCurrentActivity instanceof Encuesta)

    }


    //==================================================================================================================

    // Definicion del metodo que ejecuta la consola del Profesor.

    public void ejecutarConsolaEstudiante(LearningManagementSystem LearningManagementSystem, Usuario usuario){
        
        appExecutionProfesor = true;
        this.currentUser = (Estudiante) usuario;
        this.currentLearningManagementSystem = LearningManagementSystem;

        while (appExecutionProfesor){

            int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL ESTUDIANTE", opcionesMenuEstudiante );

            if( opcionSeleccionada == 1 )
            {
                visualizarLearningPathEnCurso();
            }

            else if( opcionSeleccionada == 2 )
            {
                inscribirseALearningPath( );
            }

            else if( opcionSeleccionada == 3 )
            {
                realizarActividad( );
            }

            else if( opcionSeleccionada == 4 )
            {
               
                appExecutionProfesor = false;


            }

    }

    }


}
