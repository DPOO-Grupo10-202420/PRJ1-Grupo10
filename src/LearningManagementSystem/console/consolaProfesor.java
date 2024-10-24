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

public class consolaProfesor extends ConsolaBasica {

    //------------------------------------------------------
    // Definicion de los atributos

    public boolean appExecutionProfesor = true;


    //Opciones
    private final String[] opcionesMenuProfesor = new String[]{ "Crear LearningPath", "Crear Actividad en un LearningPath", "Clonar Actividad de un LearnignPath existente", "Modificar LearningPath", "Modificar Actividad de un LearningPath", "Visualizar los resultados de las Encuestas", "Calificar Actividad de Estudiante", "Cerrar sesión."};


    //==================================================================================================================

    // Funciones del Profesor.

    public void crearLearningPath () {}

    public void crearActividadEnLearningPath () {}

    public void clonarActividadDeLearningPath () {}

    public void modificarLearningPath () {}

    public void visualizarResultadosEncuestas () {}

    public void calificarActividadDeEstudiante () {}



    //==================================================================================================================

    // Definicion del metodo que ejecuta la consola del Profesor.

    public void ejecutarConsolaProfesor(){
        
        appExecutionProfesor = true;

        while (appExecutionProfesor){

            int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL PROFESOR", opcionesMenuProfesor );

            if( opcionSeleccionada == 1 )
            {
                crearLearningPath ();
            }

            else if( opcionSeleccionada == 2 )
            {
                crearActividadEnLearningPath();
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

    }

    }


}
