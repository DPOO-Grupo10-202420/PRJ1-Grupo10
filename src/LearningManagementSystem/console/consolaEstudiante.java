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

public class consolaEstudiante extends ConsolaBasica {

    //------------------------------------------------------
    // Definicion de los atributos

    public boolean appExecutionProfesor = true;


    //Opciones
    private final String[] opcionesMenuProfesor = new String[]{ "Visualizar LearinigPath en curso", "Inscribirse a LearnignPath", "Visualizar Actividades del LearningPath", "LLevar a cabo Actividad", "Cerrar sesión." };


    //==================================================================================================================

    // Funciones del Profesor.


    public void visualizarLearningPathEnCurso (){

        


    }

    public void inscribirseALearningPath () {}

    public void visualizarActividadesDeLearningPathInscrito () {}

    public void realizarActividad () {}


    //==================================================================================================================

    // Definicion del metodo que ejecuta la consola del Profesor.

    public void ejecutarConsolaProfesor(){
        
        appExecutionProfesor = true;

        while (appExecutionProfesor){

            int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL Profesor", opcionesMenuProfesor );

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

            else if( opcionSeleccionada == 5 )
            {
               
                appExecutionProfesor = false;


            }

    }

    }


}
