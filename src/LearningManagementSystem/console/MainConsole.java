//====================================================================================
// Importacion de modulos
//====================================================================================
package LearningManagementSystem.console;

import java.io.IOException;

import LearningManagementSystem.Exceptions.UsuarioDuplicadoException;
import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.mainManagementSystem.users.*;

import LearningManagementSystem.mainManagementSystem.LearningManagementSystem;

import LearningManagementSystem.persistence.*;

//====================================================================================
//Definicion de la clase MainConsole
//====================================================================================

public class MainConsole extends ConsolaBasica
{   

    //------------------------------------------------------
    // Definicion de los atributos

    private LearningManagementSystem currentLearningManagementSystem = new LearningManagementSystem();
    private Usuario currentUser;

    // Opciones de texto
    private final String[] opcionesMenuPrincipal = new String[]{"INICIAR SESIÓN", "REGISTRARSE", "Salir de la aplicación." };
    private final String[] opcionesResgistrarNuevoUsuario = new String[]{"PROFESOR", "ESTUDIANTE", "Volver al menu principal."};

    public boolean appExecution = true;

    consolaEstudiante estCon = new consolaEstudiante();
    consolaProfesor profCon = new consolaProfesor();


    //------------------------------------------------------
    // Llama los modulos de persisitencia de datos.

    public void cargarInformacion(){

        //CentralPersistencia centPers = new CentralPersistencia();
        //LentPers.cargarInformacion(LearningManagementSystem());

    };


    //==================================================================================================================
    //------------------------------------------------------
    // Inicia sesion.  

    public void iniciarSesion() {

        String nombreUsuario = pedirCadenaAlUsuario("Digite su nombre de usuario");

        // Revisa si existe el usuario. 
        if (currentLearningManagementSystem.existeUsuario(nombreUsuario)){

            Usuario usuario = currentLearningManagementSystem.getUsuario(nombreUsuario);
            currentUser = usuario;
            
            System.out.println("------------------------------------------------------------");
            System.out.println("Bienvenido/a " + usuario.getUsername() + "! ");
        
            if (usuario instanceof Estudiante){
                estCon.ejecutarConsolaEstudiante();
            }
            else if (usuario instanceof Profesor) {
                profCon.ejecutarConsolaProfesor();
            }

        }

        else {

            System.out.println("------------------------------------------------------------");
            System.out.println("El nombre de usuario no está registrado en la base de datos.");

        }
        

    }

    //==================================================================================================================

    public void registrarNuevoUsuario(){

        int opcionSeleccionada = mostrarMenu( "Inicio de sesión", opcionesResgistrarNuevoUsuario );

        System.out.println("------------------------------------------------------------");
        System.out.println("¿Cómo desea registrarse? ");
        String username = pedirCadenaAlUsuario("Digite el nombre de usuario que desea usar");

        while (!currentLearningManagementSystem.existeUsuario(username)){

            System.out.println("El nombre de usuario elegido ya esta en uso. Digite uno distinto.");
            username = pedirCadenaAlUsuario("Digite el nombre de usuario que desea usar");

        }

        System.out.println("------------------------------------------------------------");
        String password = pedirCadenaAlUsuario("Digite su contraseña");
        System.out.println("------------------------------------------------------------");
        String email = pedirCadenaAlUsuario("Digite su correo electrónico");
        System.out.println("------------------------------------------------------------");

        if (opcionSeleccionada == 1) {

            Profesor newProfesor = new Profesor(username, password, email);

            currentLearningManagementSystem.addNewUser(newProfesor);

        }
        else if (opcionSeleccionada == 2) {

            Estudiante newEstudiante = new Estudiante(username, password, email);

            currentLearningManagementSystem.addNewUser(newEstudiante);

        }
        else if (opcionSeleccionada == 3) {
            // Volver al menu principal.
        }   

    }












    //==================================================================================================================

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

        while (appExecution){

            int opcionSeleccionada = mostrarMenu( "MENÚ PRINCIPAL DEL SISTEMA", opcionesMenuPrincipal );
            if( opcionSeleccionada == 1 )
            {
                iniciarSesion( );
            }
            else if( opcionSeleccionada == 2 )
            {
                registrarNuevoUsuario();
            }
            //else if( opcionSeleccionada == 3 )
            //{
                //ingresarComoAdmin( );
            //}
            else if( opcionSeleccionada == 3 )
            {
                System.out.println( "Saliendo ..." );
                appExecution = false;
                System.exit( 0 );
            }
        }


        
    }
    
    //==================================================================================================================
    public static void main( String[] args )
    {
        MainConsole mainCon = new MainConsole( );
        mainCon.ejecutarAplicacion( );
    }

    //==================================================================================================================

//Final MainConsole
}
