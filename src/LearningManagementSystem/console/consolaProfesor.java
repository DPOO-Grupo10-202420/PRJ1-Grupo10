//====================================================================================
// Importacion de modulos
//====================================================================================
package LearningManagementSystem.console;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.mainManagementSystem.activities.Actividad;
import LearningManagementSystem.console.*;
import LearningManagementSystem.console.ConsolaBasica;
import LearningManagementSystem.mainManagementSystem.users.*;
// import LearningManagementSystem.persistence.*;

public class consolaProfesor extends ConsolaBasica {

    //------------------------------------------------------
    // Definicion de los atributos
    public boolean appExecutionProfesor = true;
    public LearningManagementSystem currentLearningManagementSystem;
    public Profesor currentUser;

    //Opciones
    private final String[] opcionesMenuProfesor = new String[]{ "Crear LearningPath", "Agregar Actividad en un LearningPath", "Clonar Actividad de un LearnignPath existente", "Modificar LearningPath", "Modificar Actividad de un LearningPath", "Visualizar los resultados de las Encuestas", "Calificar Actividad de Estudiante", "Cerrar sesión."};
    private final String[] opcionesPostCrearLeaningPath = new String[]{ "Crear Actividad", "Eliminar Actividad", "Volver a menu anterior."};

    //==================================================================================================================
    // Funciones del Profesor.
    public void crearLearningPath () {

        String nombreLearningPath = pedirCadenaAlUsuario("Digite el nombre del LearningPath");
        String descripcionLearningPath = pedirCadenaAlUsuario("Digite la descripción del LearningPath");
        String nivelDificultad = pedirCadenaAlUsuario("Digite el nivel de dificultad del LearningPath (BASICO, INTERMEDIO, AVANZADO)");
        try{
            currentLearningManagementSystem.addNewLearningPath(nombreLearningPath, descripcionLearningPath, nivelDificultad);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
        
        LearningPath nuevoLearningPath = new LearningPath(nombreLearningPath, descripcionLearningPath, nivelDificultad);
        System.out.println("LearningPath creado con éxito.");
        boolean continuar = true;
        while(nuevoLearningPath.getsecuenciaActividades().size() == 0 && continuar){
            int opcionSeleccionada = mostrarMenu( "¿Qué desea hacer ahora?", opcionesPostCrearLeaningPath );
            switch(opcionSeleccionada){
                case 1:
                    crearActividadEnLearningPath(nuevoLearningPath);
                    break;
                case 2:
                    eliminarActividadDeLearningPath(nuevoLearningPath);
                    break;
                case 3:
                    if (nuevoLearningPath.getsecuenciaActividades().size() == 0){
                        System.out.println("Debe agregar al menos una actividad al LearningPath.");
                    }else{
                        continuar = false;
                        return;
                    }
            }
        }
        return;
    }

    public void crearActividadEnLearningPath (LearningPath nuevoLearningPath) {
        //------------------------------------------------------//
        // ATRIBUTOS DEL CONTRUCTOR DE ACTIVIDAD
        String[] tipoActivvidad = new String[]{"Nuevo recurso", "Nueva tarea", "Nuevo examen", "Nuevo quiz", "Nueva encuesta"};
        int opcionSeleccionada = mostrarMenu( "Seleccione el tipo de actividad que desea crear", tipoActivvidad );

        String creadorActividad = currentUser.getUsername();
        String nombreActividad = pedirCadenaAlUsuario("Digite el nombre de la actividad");
        String descripcionActividad = pedirCadenaAlUsuario("Digite la descripción de la actividad");
        String objetivoActividad = pedirCadenaAlUsuario("Digite el objetivo de la actividad");
        String dificultadActividad = pedirCadenaAlUsuario("Digite la dificultad de la actividad (BASICO, INTERMEDIO, AVANZADO)");
        int tiempoEstimadoActividad = pedirEnteroAlUsuario("Digite el tiempo estimado de la actividad en minutos");

        // la fecha de cierre de la actividad
        String fechaCierreActividadString = pedirCadenaAlUsuario("Digite la fecha de cierre de la actividad (yyyy-MM-dd)");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaCierreActividad;
        try{
            fechaCierreActividad = formato.parse(fechaCierreActividadString);
        } catch (Exception e){
            System.out.println("Error en el formato de la fecha");
            return;
        }

        // La actividad es obligatoria
        String obligatoriaActividadString = pedirCadenaAlUsuario("¿La actividad es obligatoria (si/no)?");
        boolean obligatoriaActividad = obligatoriaActividadString.equals("si") ? true : false;

        switch(opcionSeleccionada){
            // ================================================================================================ //
            // RECURSO
            case 1:
                
                String tipoRecurso = pedirCadenaAlUsuario("Digite el tipo de recurso");
                String URLRecurso = pedirCadenaAlUsuario("Digite la URL del recurso");

                try{
                    Actividad recurso = nuevoLearningPath.addRecurso(nombreActividad ,  descripcionActividad,  objetivoActividad,  dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad, tipoRecurso, URLRecurso);
                    currentLearningManagementSystem.addNewActivity(recurso);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            break;
            // ================================================================================================ //
            // TAREA
            case 2:
                String tipoTarea = pedirCadenaAlUsuario("Digite el tipo de tarea");
                try{
                    Actividad tarea = nuevoLearningPath.addTarea(nombreActividad ,  descripcionActividad,  objetivoActividad,  dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad, tipoTarea);
                    currentLearningManagementSystem.addNewActivity(tarea);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            break; 
            // ================================================================================================ //
            // EXAMEN
            case 3:
                try{
                    int numeroPreguntas = pedirNumeroPreguntas();
                    double calificionMinima = (double) pedirEnteroAlUsuario("Digite la calificación mínima del examen");

                    Actividad examen = nuevoLearningPath.addExamen(nombreActividad ,  descripcionActividad,  objetivoActividad,  dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad, calificionMinima);

                    int i = 0;
                    while(i < numeroPreguntas){
                        String enunciadoPregunta = pedirCadenaAlUsuario("Digite la pregunta " + (i+1));
                        String retroalimentacion = pedirCadenaAlUsuario("Digite la retroalimentación de la pregunta " + (i+1));
                        nuevoLearningPath.addPregunta(examen, enunciadoPregunta, retroalimentacion,true);
                        i++;
                    }

                    currentLearningManagementSystem.addNewActivity(examen);
                    
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            break;
            // ================================================================================================ //
            // QUIZ
            case 4:
                try{
                    int numeroPreguntas = pedirNumeroPreguntas();
                    double calificionMinima = (double) pedirEnteroAlUsuario("Digite la calificación mínima del quiz");

                    Actividad quiz = nuevoLearningPath.addQuiz(nombreActividad ,  descripcionActividad,  objetivoActividad,  dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad, calificionMinima);

                    int i = 0;
                    while(i < numeroPreguntas){
                        String enunciadoPregunta = pedirCadenaAlUsuario("Digite la pregunta " + (i+1));
                        String retroalimentacion = pedirCadenaAlUsuario("Digite la retroalimentación de la pregunta " + (i+1));
                        nuevoLearningPath.addPregunta(quiz, enunciadoPregunta, retroalimentacion,false);
                        i++;
                    }

                    currentLearningManagementSystem.addNewActivity(quiz);

                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            break;
            // ================================================================================================ //
            // ENCUESTA
            case 5:
                try{
                    int numeroPreguntas = pedirNumeroPreguntas();

                    Actividad encuesta = nuevoLearningPath.addEncuesta(nombreActividad ,  descripcionActividad,  objetivoActividad,  dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad);

                    int i = 0;
                    while(i < numeroPreguntas){
                        String enunciadoPregunta = pedirCadenaAlUsuario("Digite la pregunta " + (i+1));
                        String retroalimentacion = pedirCadenaAlUsuario("Digite la retroalimentación de la pregunta " + (i+1));
                        nuevoLearningPath.addPregunta(encuesta, enunciadoPregunta, retroalimentacion,false);
                        i++;
                    }
                    currentLearningManagementSystem.addNewActivity(encuesta);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            break;
            default:
                System.out.println("Opción no válida");
                return;
        }
    }

    public void eliminarActividadDeLearningPath (LearningPath nuevoLearningPath) {
        if (nuevoLearningPath.getsecuenciaActividades().size() == 0){
            System.out.println("No hay actividades para eliminar.");
            return;
        }else if (nuevoLearningPath.getsecuenciaActividades().size() == 1){
            System.out.println("Este learningPath solo tiene una actividad. No se puede eliminar.");
            return;
        }

        String[] actividades = new String[nuevoLearningPath.getsecuenciaActividades().size()];
        for (int i = 0; i < nuevoLearningPath.getsecuenciaActividades().size(); i++){
            actividades[i] = nuevoLearningPath.getsecuenciaActividades().get(i).getNombre();
        }

        int opcionSeleccionada = mostrarMenu( "Seleccione la actividad que desea eliminar", actividades );
        nuevoLearningPath.removeActividad(nuevoLearningPath.getsecuenciaActividades().get(opcionSeleccionada));
        System.out.println("Actividad eliminada con éxito.");
        return;
    }

    public void clonarActividadDeLearningPath() {
        //------------------------------------------------------//
        // LISTAMOS LOS LEARNING PATHS PARA QUE ESCOJA DE CUAL CLONAR
        String[] learningPaths = new String[currentLearningManagementSystem.getLearningPaths().size()];
        int i = 0;
        for (LearningPath learningPath : currentLearningManagementSystem.getLearningPaths()){
            learningPaths[i] = learningPath.getTitulo();
            i++;
        }
        int opcionSeleccionada = mostrarMenu( "Seleccione el LearningPath del cual desea clonar la actividad", learningPaths );
        LearningPath learningPathSeleccionado = currentLearningManagementSystem.getLearningPath(learningPaths[opcionSeleccionada]);

        //------------------------------------------------------//
        // LISTAMOS LAS ACTIVIDADES PARA QUE ESCOJA CUAL CLONAR
        String[] actividades = new String[learningPathSeleccionado.getsecuenciaActividades().size()];
        i = 0;
        for (Actividad actividad : learningPathSeleccionado.getsecuenciaActividades()){
            actividades[i] = actividad.getNombre();
            i++;
        }
        opcionSeleccionada = mostrarMenu("Seleccione la actividad que desea clonar", actividades );
        Actividad actividadSeleccionada = learningPathSeleccionado.getsecuenciaActividades().get(opcionSeleccionada);

        //------------------------------------------------------//
        // CLONAMOS LA ACTIVIDAD
        try{
            Actividad actividadClonada = actividadSeleccionada.clone();
            currentLearningManagementSystem.addNewActivity(actividadClonada);
            System.out.println("Actividad clonada con éxito.");
        } catch (Exception e){
            System.out.println(e.getMessage());
            return;
        }
    }

    public void visualizarResultadosEncuestas () {}

    public void calificarActividadDeEstudiante () {}

    public void visualizarMisLearingPaths () {}


    public void modificarLearningPath() {}

    private int pedirNumeroPreguntas(){
        int numeroPreguntas = pedirEnteroAlUsuario("Digite el número de preguntas de la actividad");
        while (numeroPreguntas <= 0){
            numeroPreguntas = pedirEnteroAlUsuario("El número de preguntas debe ser mayor a 0. Digite el número de preguntas de la actividad");
        }
        return numeroPreguntas;
    }


    //==================================================================================================================
    // Definicion del metodo que ejecuta la consola del Profesor.

    public void ejecutarConsolaProfesor(LearningManagementSystem LearningManagementSystem, Usuario usuario){
        this.currentLearningManagementSystem = LearningManagementSystem;
        this.currentUser = (Profesor) usuario;
        appExecutionProfesor = true;

        while (appExecutionProfesor){

            int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL PROFESOR", opcionesMenuProfesor );
            if( opcionSeleccionada == 1 ){
                crearLearningPath ();
            }

            else if( opcionSeleccionada == 2 ){
                String nombreLearningPath = pedirCadenaAlUsuario("Digite el nombre del LearningPath al que quiere agregar la actividad");
                if (!currentLearningManagementSystem.existeLearningPath(nombreLearningPath)){
                    
                    while (!currentLearningManagementSystem.existeLearningPath(nombreLearningPath)){
                        nombreLearningPath = pedirCadenaAlUsuario("El LearningPath digitado no existe. Digito otro que si se encuentre en la base de datos");
                    }
                }
                LearningPath nuevoLearningPath = currentLearningManagementSystem.getLearningPath(nombreLearningPath);
                crearActividadEnLearningPath(nuevoLearningPath);
            }

            else if( opcionSeleccionada == 3 ) {
                clonarActividadDeLearningPath();
            }

            else if( opcionSeleccionada == 4 )
            {
                modificarLearningPath();
            }

            else if( opcionSeleccionada == 5 )
            {
                visualizarResultadosEncuestas();
            }

            else if( opcionSeleccionada == 6 )
            {
                calificarActividadDeEstudiante();
            }

            else if( opcionSeleccionada == 7 )
            {
                appExecutionProfesor = false;
            }
            else if( opcionSeleccionada == 8 )
            {
                appExecutionProfesor = false;
            }

        }

    }


}
