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
            case 1:
                
                String tipoRecurso = pedirCadenaAlUsuario("Digite el tipo de recurso");
                String URLRecurso = pedirCadenaAlUsuario("Digite la URL del recurso");

                try{
                    nuevoLearningPath.addRecurso(nombreActividad ,  descripcionActividad,  objetivoActividad,  dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad, tipoRecurso, URLRecurso);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            break;
            case 2:
                String tipoTarea = pedirCadenaAlUsuario("Digite el tipo de tarea");
                try{
                    nuevoLearningPath.addTarea(nombreActividad ,  descripcionActividad,  objetivoActividad,  dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad, tipoTarea);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            break;
            case 3:
                //String metodoEnvio = pedirCadenaAlUsuario("Digite el método de envío");
                try{
                    int numeroPreguntas = pedirEnteroAlUsuario("Digite el número de preguntas del examen");
                    double calificionMinima = (double) pedirEnteroAlUsuario("Digite la calificación mínima del examen");

                    Actividad examen = nuevoLearningPath.addExamen(nombreActividad ,  descripcionActividad,  objetivoActividad,  dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad, calificionMinima);

                    int i = 0;
                    while(i < numeroPreguntas){
                        String enunciadoPregunta = pedirCadenaAlUsuario("Digite la pregunta " + (i+1));
                        String retroalimentacion = pedirCadenaAlUsuario("Digite la retroalimentación de la pregunta " + (i+1));
                        nuevoLearningPath.addPregunta(examen, enunciadoPregunta, retroalimentacion,true);
                        i++;
                    }
                    
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            case 4:
                //String metodoEnvio = pedirCadenaAlUsuario("Digite el método de envío");
                try{
                    int numeroPreguntas = pedirEnteroAlUsuario("Digite el número de preguntas del quiz");
                    double calificionMinima = (double) pedirEnteroAlUsuario("Digite la calificación mínima del quiz");

                    Actividad quiz = nuevoLearningPath.addQuiz(nombreActividad ,  descripcionActividad,  objetivoActividad,  dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad);

                    int i = 0;
                    while(i < numeroPreguntas){
                        String enunciadoPregunta = pedirCadenaAlUsuario("Digite la pregunta " + (i+1));
                        String retroalimentacion = pedirCadenaAlUsuario("Digite la retroalimentación de la pregunta " + (i+1));
                        nuevoLearningPath.addPregunta(quiz, enunciadoPregunta, retroalimentacion,false);
                        i++;
                    }
                    
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
        }
    }

    public void eliminarActividadDeLearningPath (LearningPath nuevoLearningPath) {}

    public void visualizarResultadosEncuestas () {}

    public void calificarActividadDeEstudiante () {}

    public void visualizarMisLearingPaths () {}

    public void clonarActividadDeLearningPath() {}

    public void modificarLearningPath() {}


    //==================================================================================================================

    // Definicion del metodo que ejecuta la consola del Profesor.

    public void ejecutarConsolaProfesor(LearningManagementSystem LearningManagementSystem, Usuario usuario){
        this.currentLearningManagementSystem = LearningManagementSystem;
        this.currentUser = (Profesor) usuario;
        appExecutionProfesor = true;

        while (appExecutionProfesor){

            int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL PROFESOR", opcionesMenuProfesor );

            if( opcionSeleccionada == 1 )
            {
                crearLearningPath ();
            }

            else if( opcionSeleccionada == 2 )
            {

                String nombreLearningPath = pedirCadenaAlUsuario("Digite el nombre del LearningPath al que quiere agregar la actividad");

                if (!currentLearningManagementSystem.existeLearningPath(nombreLearningPath)){
                    
                    while (!currentLearningManagementSystem.existeLearningPath(nombreLearningPath)){
        
                        nombreLearningPath = pedirCadenaAlUsuario("El LearningPath digitado no existe. Digito otro que si se encuentre en la base de datos");
            
                    }
        
                }
        
                LearningPath nuevoLearningPath = currentLearningManagementSystem.getLearningPath(nombreLearningPath);

                crearActividadEnLearningPath(nuevoLearningPath);
            }

            else if( opcionSeleccionada == 3 )
            {
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
