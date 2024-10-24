package LearningManagementSystem.console;

import java.io.IOException;
import LearningManagementSystem.mainManagementSystem.*;


public class MainConsole extends ConsolaBasica
{   
    private LearningManagementSystem oneLearningManagementSystem;
    private final String[] opcionesMenuPrincipal = new String[]{ "Ingresar como ESTUDIANTE", "Ingresar como PROFESOR", "Ingresar como ADMINSTRADOR DEL SISTEMA", "Salir" };

    public void cargarInformacion(){};

    public void ingresarComoAdmin(){}

    public void ingresarComoEstudiante(){}

    public void ingresarComoProfesor(){}




    public void ejecutarAplicacion( )
    {
       
        System.out.println("================================================================================");
        System.out.println("              WELCOME TO THE LEARNING PATH RECOMMENDATION SYSTEM                ");
        System.out.println("================================================================================");

        cargarInformacion();


        int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL SISTEMA", opcionesMenuPrincipal );
        if( opcionSeleccionada == 1 )
        {
            ingresarComoEstudiante( );
        }
        else if( opcionSeleccionada == 2 )
        {
            ingresarComoProfesor( );
        }
        else if( opcionSeleccionada == 3 )
        {
            ingresarComoAdmin( );
        }
        else if( opcionSeleccionada == 5 )
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
