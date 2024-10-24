//====================================================================================
// Importacion de modulos
//====================================================================================
package LearningManagementSystem.console;

import java.io.IOException;
import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.mainManagementSystem.users.*;
import LearningManagementSystem.persistence.*;

//====================================================================================
//Definicion de la clase MainConsole
//====================================================================================

public class MainConsole extends ConsolaBasica
{   

    //------------------------------------------------------
    // Definicion de los atributos

    private LearningManagementSystem currentLearningManagementSystem = new LearningManagementSystem();
    private final String[] opcionesMenuPrincipal = new String[]{ "Ingresar como ESTUDIANTE", "Ingresar como PROFESOR", "Salir" };


    //------------------------------------------------------
    // Llama los modulos de persisitencia de datos.

    public void cargarInformacion(){

        //CentralPersistencia centPers = new CentralPersistencia();
        //LentPers.cargarInformacion(LearningManagementSystem());

    };



    //------------------------------------------------------
    // Crea la consola del estudiante. 

    public void ingresarComoEstudiante(){

        consolaEstudiante estCon = new consolaEstudiante();
        estCon.ejecutarConsolaEstudiante();


    }

    
    //------------------------------------------------------
    // Crea la consola del profesor 

    public void ingresarComoProfesor(){
        
        consolaProfesor profCon = new consolaProfesor();
        profCon.ejecutarConsolaProfesor();
    }


    //------------------------------------------------------
    // Llama los modulos de persisitencia de datos.

    //public void ingresarComoAdmin(){}


    public void ejecutarAplicacion( )
    {
       
        System.out.println("================================================================================");
        System.out.println("              WELCOME TO THE LEARNING PATH RECOMMENDATION SYSTEM                ");
        System.out.println("================================================================================");


        //------------------------------------------------------
        // Se carga la informacion antes de usar la aplicacion.
        cargarInformacion();



        //------------------------------------------------------
        // Muestra el menu principal

        int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL SISTEMA", opcionesMenuPrincipal );
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
    

    public static void main( String[] args )
    {
        MainConsole mainCon = new MainConsole( );
        mainCon.ejecutarAplicacion( );
    }



//Final MainConsole
}
