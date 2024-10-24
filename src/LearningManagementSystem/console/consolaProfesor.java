//====================================================================================
// Importacion de modulos
//====================================================================================

package LearningManagementSystem.console;

import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.console.ConsolaBasica;

import java.io.IOException;
import LearningManagementSystem.mainManagementSystem.users.*;
import LearningManagementSystem.persistence.*;

public class consolaProfesor extends ConsolaBasica {


    //------------------------------------------------------
    // Definicion de los atributos
    private final String[] opcionesMenuProfesor = new String[]{ "Ingresar como ESTUDIANTE", "Ingresar como PROFESOR", "Salir" };


    public void ejecutarConsolaProfesor(){

        int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL SISTEMA", opcionesMenuProfesor );
        if( opcionSeleccionada == 1 )
        {
            ingresarComoEstudiante( );
        }
        else if( opcionSeleccionada == 2 )
        {
            ingresarComoProfesor( );
        }
        //else if( opcionSeleccionada == 3 )
        //{
            //ingresarComoAdmin( );
        //}
        else if( opcionSeleccionada == 3 )
        {
            System.out.println( "Saliendo ..." );
            System.exit( 0 );
        }







    }
    
}
