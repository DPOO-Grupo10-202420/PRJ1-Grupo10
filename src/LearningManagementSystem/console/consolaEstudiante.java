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

    private final String[] opcionesMenuEstudiante = new String[]{ "Iniciar sesión", "Registrarse", "Salir" };
















    //------------------------------------------------------
    // Definicion del metodo que ejecuta la consola del estudiante.

    public void ejecutarConsolaEstudiante(){
        
        



        int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL SISTEMA", opcionesMenuEstudiante );
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
