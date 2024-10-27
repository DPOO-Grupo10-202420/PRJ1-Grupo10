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
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class consolaEstudiante extends ConsolaBasica {

    //------------------------------------------------------
    // Definicion de los atributos

    public boolean appExecutionProfesor = true;
    public LearningManagementSystem currentLearningManagementSystem;
    public Estudiante currentUser;

    //Opciones
    private final String[] opcionesMenuEstudiante = new String[]{ "Visualizar LearinigPath en curso", "Inscribirse a LearnignPath", "LLevar a cabo Actividad", "Agregar reseña a Actividad", "Cerrar sesión." };

    //==================================================================================================================

    // Funciones del Profesor.


    public void visualizarLearningPathEnCurso (){

        if (!currentUser.estaEscritoEnUnLearningPath()){
            
            System.out.println( "\n" );
            System.out.println("No se encuentra inscrito en ningún LearningPath.");

        }
        else {

            LearningPath studentCurrentLearningPath = currentUser.getStudentCurrentLearningPath();

            System.out.println( "\n" );
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

        } else {

            String tituloLearningPath = pedirCadenaAlUsuario("Digite el titulo del LearningPath al que desea inscribirse ");

            if (currentLearningManagementSystem.existeLearningPath(tituloLearningPath)){
                currentUser.iniciarLearningPath(currentLearningManagementSystem.getLearningPath(tituloLearningPath));
            }
            else {
             
                System.out.println("El LearningPath no se encuentra en la base de datos.");
                
            }

        }

    }


    public void realizarActividad () {

        if (!currentUser.estaEscritoEnUnLearningPath()){

            System.out.println("-----------------------------------------------");
            System.out.println("Debe estar inscrito en un LearningPath para poder desarrollar sus Actividades.");

        }
        else {

            LearningPath studentCurrentLearningPath = currentUser.getStudentCurrentLearningPath();
            List<Actividad> secuenciaActividades = studentCurrentLearningPath.getSecuenciaActividades();
            
            HashMap<String, Actividad> studentCompletedActivities = currentUser.getCompletedActivities() ;

            System.out.println("\n");
            System.out.println("Las Actividades que faltan por realizar del LearningPath son las siguientes: ");

            List<String> nombreActividadesNoRealizadasDelLearningPath = new ArrayList<String>();

            for (Actividad elementActividad: secuenciaActividades){

                String nombreActividad = elementActividad.getNombre();

                if (!studentCompletedActivities.containsKey(nombreActividad)){
                    System.out.println("-----------------------");
                    System.out.println(nombreActividad);
                    System.out.println("\n");
                    nombreActividadesNoRealizadasDelLearningPath.add(nombreActividad);
                }

            }

            System.out.println("--------------------------------------------------------");
            String nombreActividadARealizar = pedirCadenaAlUsuario("Digite la Actividad que desea realizar");

            while (!nombreActividadesNoRealizadasDelLearningPath.contains(nombreActividadARealizar)){
                nombreActividadARealizar = pedirCadenaAlUsuario("La Actividad digitada no pertenece al LearningPath mostrado anteriormente. Digite otra de nuevo");

            }

            Actividad actividadARealizar = currentLearningManagementSystem.getActividad(nombreActividadARealizar);

            HashMap<String, Actividad> actividadesHechas = currentUser.getCompletedActivities();

            boolean noHayPrevia = true;

            if (currentUser.getStudentCurrentActivity() != null) {
                for (Actividad elementActividad: currentUser.getStudentCurrentActivity().getActividadesPrevias()){

                    String nombreActividad = elementActividad.getNombre();

                    if (!actividadesHechas.containsKey(nombreActividad)) {
                        System.out.println("La Actividad ' " + actividadARealizar.getNombre() + " ' debe ser hecha antes de realizar la Actividad ' " + nombreActividad  +"'. ");
                        noHayPrevia = false;

                    }

            }
        
        }
            

            boolean continuar = true;

            if (!noHayPrevia){

                System.out.println("\n");
                String opcionContinuar = pedirCadenaAlUsuario("¿Desea realizar la actividad aún asi? (si/no) ");

                if (opcionContinuar.toUpperCase() == "NO"){
                    continuar = false;
                }
            }


            if (continuar) {

                //Actividad actividadClonada = actividadARealizar.clone();

                currentUser.iniciarActividad(actividadARealizar);
            
                // Realizar Recurso

                if (currentUser.getStudentCurrentActivity() instanceof Recurso) {

                    Recurso recurso = (Recurso) currentUser.getStudentCurrentActivity();

                    System.out.println("-----------------------------------------------");
                    System.out.println("Información del Recurso:");
                    System.out.println("-----------------------------------------------");
                    System.out.println("Nombre: " + recurso.getNombre());
                    System.out.println("Descripción: " + recurso.getDescripcion());
                    System.out.println("Objetivo: " + recurso.getObjetivo());
                    System.out.println("Dificultad: " + recurso.getDificultad());
                    System.out.println("Fecha de cierre: " + recurso.getFechaDeCierre()); 
                    System.out.println("Tipo de recurso: " + recurso.getTipoRecurso());
                    System.out.println("-----------------------------------------------");
                    System.out.println("Contenido: ");
                    System.out.println("URL: " + recurso.getURLRecurso());
                    System.out.println("-----------------------------------------------");
                    System.out.println("\n");

                    String cualquierCadena = pedirCadenaAlUsuario("Presione cualquier tecla para marcar como leido el recurso: ");

                    currentUser.terminarActividad();

                }
                // Realizar Tarea
                else if (currentUser.getStudentCurrentActivity() instanceof Tarea){

                    Tarea tarea = (Tarea) currentUser.getStudentCurrentActivity();

                    System.out.println("-----------------------------------------------");
                    System.out.println("Información del Recurso:");
                    System.out.println("-----------------------------------------------");
                    System.out.println("Nombre: " + tarea.getNombre());
                    System.out.println("Descripción: " + tarea.getDescripcion());
                    System.out.println("Objetivo: " + tarea.getObjetivo());
                    System.out.println("Dificultad: " + tarea.getDificultad());
                    System.out.println("Fecha de cierre: " + tarea.getFechaDeCierre()); 
                    System.out.println("Metodo de envio: " + tarea.getMetodoEnvio());
                    System.out.println("-----------------------------------------------");
                    System.out.println("\n");

                    String cualquierCadena = pedirCadenaAlUsuario("Presione cualquier tecla para enviar la tarea: ");    

                    currentUser.terminarActividad();

                }

                // Realizar Quiz

                else if (currentUser.getStudentCurrentActivity() instanceof Quiz) {

                    Quiz quiz = (Quiz) currentUser.getStudentCurrentActivity();

                    System.out.println("-----------------------------------------------");
                    System.out.println("Información del Quiz:");
                    System.out.println("-----------------------------------------------");
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
                        System.out.println("-----------------------------------------------");
                        System.out.println("Quiz finalizado: Ha aprobado el Quiz");
                    } else {
                        System.out.println("-----------------------------------------------");
                        System.out.println("Quiz finalizado: No ha aprobado el Quiz");
                    }

                    for (Pregunta pregunta : quiz.getPreguntas()) {
                        System.out.println("\nEnunciado: " + pregunta.getEnunciado());
                        System.out.println("Retroalimentación: " + pregunta.getRetroalimentacion());
                    }

                    currentUser.terminarActividad();

                } 

                // Realizar Examen
            
                else if (currentUser.getStudentCurrentActivity() instanceof Examen) {

                    Examen examen = (Examen) currentUser.getStudentCurrentActivity();

                    System.out.println("-----------------------------------------------");
                    System.out.println("Información del Examen:");
                    System.out.println("-----------------------------------------------");
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

                    System.out.println("\n");
                    System.out.println("Retroalimentacion.");

                    for (Pregunta pregunta : examen.getPreguntas()) {
                        System.out.println("\nEnunciado: " + pregunta.getEnunciado());
                        System.out.println("Retroalimentación: " + pregunta.getRetroalimentacion());
                    }
                    
                    currentUser.terminarActividad();

                    System.out.println("-----------------------------------------------");
                    System.out.println("Examen completado y enviado. Espere la retroalimentación del profesor.");

                } 

                // Realizar Encuesta
                    
                else if (currentUser.getStudentCurrentActivity() instanceof Encuesta) {
                    Encuesta encuesta = (Encuesta) currentUser.getStudentCurrentActivity();
                    
                    System.out.println("-----------------------------------------------");
                    System.out.println("Información de la Encuesta:");
                    System.out.println("-----------------------------------------------");
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

                    currentUser.terminarActividad();
                    System.out.println("-----------------------------------------------");
                    System.out.println("Encuesta completada y enviada. Gracias por tus respuestas.");
                }

                }
            }
        
    }



    public void addReview (){

        String nombreActividad = pedirCadenaAlUsuario("Digite la Actividad a la que quiere agregar una reseña (Unicamente se permite en aquellas que ya fueron desarrolladas)");

        if (currentUser.getCompletedActivities().size() > 0){

            for (Map.Entry<String, Actividad> tupla: currentUser.getCompletedActivities().entrySet()){

                System.out.println(tupla.getKey());
    
            }


            if (!currentUser.getCompletedActivities().containsKey(nombreActividad) ){

                System.out.println("La Actividad digitada no se encuentra dentro de las desarrolladas ");
    
            }
            else{
    
                Actividad actividadSeleccionada = currentLearningManagementSystem.getActividad(nombreActividad);
    
                int rating = pedirEnteroAlUsuario("Digite la calificación de la actividad (1-5)");
                while (rating < 1 || rating > 5){
                    rating = pedirEnteroAlUsuario("La calificación debe ser un número entre 1 y 5. Digite la calificación de la actividad (1-5)");
                }
                String comentario = pedirCadenaAlUsuario("Digite el comentario de la actividad");
                actividadSeleccionada.addReview(comentario, rating, currentUser.getUsername());
                System.out.println("Reseña creada con éxito.");
    
            }


        }

        else {
            System.out.println("No hay Actividades disponibles para agregar una reseña. ");
        }

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
                visualizarLearningPathEnCurso( );
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
                addReview( );
            }

            else if( opcionSeleccionada == 5 )
            {
               
                appExecutionProfesor = false;


            }

    }

    }


}