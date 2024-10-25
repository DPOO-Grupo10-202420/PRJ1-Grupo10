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
import LearningManagementSystem.mainManagementSystem.activities.*;;


import java.util.List;

public class consolaEstudiante extends ConsolaBasica {

    //------------------------------------------------------
    // Definicion de los atributos

    public boolean appExecutionProfesor = true;
    public LearningManagementSystem currentLearningManagementSystem;
    public Estudiante currentUser;

    //Opciones
    private final String[] opcionesMenuEstudiante = new String[]{ "Visualizar LearinigPath en curso", "Inscribirse a LearnignPath", "LLevar a cabo Actividad", "Cerrar sesión." };

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

            System.out.println("Debes estar inscrito en un LearningPath para poder desarrollar sus Actividades.");

        }
        else {

            String nombreActividad = pedirCadenaAlUsuario("Digite el nombre de la actividad que desea desarrollar");

            


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
               
                appExecutionProfesor = false;


            }

    }

    }


}
