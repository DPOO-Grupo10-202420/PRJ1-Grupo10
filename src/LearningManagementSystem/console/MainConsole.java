//====================================================================================
// Importacion de modulos
//====================================================================================
package LearningManagementSystem.console;

import LearningManagementSystem.mainManagementSystem.LearningManagementSystem;
import LearningManagementSystem.mainManagementSystem.users.*;

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


    
    public Usuario getCurrentUser (){
        return this.currentUser;
    }

    //------------------------------------------------------
    // Llama los modulos de persisitencia de datos.
    public void cargarInformacion(){
        //CentralPersistencia centPers = new CentralPersistencia();
        //LentPers.cargarInformacion(LearningManagementSystem());
    };


    public void saveInformation(){
        //CentralPersistencia centPers = new CentralPersistencia();
        //LentPers.cargarInformacion(LearningManagementSystem());
    }

    //==================================================================================================================
    // Inicia sesion.  

    public void iniciarSesion() {

        String nombreUsuario = pedirCadenaAlUsuario("Digite su nombre de usuario");
        // Revisa si existe el usuario. 
        if (currentLearningManagementSystem.existeUsuario(nombreUsuario)){

            Usuario usuario = currentLearningManagementSystem.getUsuario(nombreUsuario);
            String password = pedirCadenaAlUsuario("Digite su contraseña");
            int intentos = 0;
            boolean Error = false;
            while(!usuario.getPassword().equals(password) && intentos <= 3){
                System.out.println("La contraseña es incorrecta. Intente de nuevo.");
                password = pedirCadenaAlUsuario("Digite su contraseña");
                intentos++;
                if(intentos == 3){
                    Error = true;
                }
            }
            if(Error){
                System.out.println("Ha excedido el número de intentos permitidos. Intente de nuevo más tarde.");
                return;
            }

            currentUser = usuario;
            System.out.println("------------------------------------------------------------");
            System.out.println("Bienvenido/a " + usuario.getUsername() + "! ");
        
            if (usuario instanceof Estudiante){
                estCon.ejecutarConsolaEstudiante(currentLearningManagementSystem, usuario);
            }
            else if (usuario instanceof Profesor) {
                profCon.ejecutarConsolaProfesor(currentLearningManagementSystem, usuario); // MAL
            }

        }
        else {
            System.out.println("------------------------------------------------------------");
            System.out.println("El nombre de usuario no está registrado en la base de datos.");

        }

    }

    //==================================================================================================================
    // Se registra un nuevo usuario. 

    public void registrarNuevoUsuario(){

        int opcionSeleccionada = mostrarMenu( "Registro de usuario", opcionesResgistrarNuevoUsuario );

        System.out.println("------------------------------------------------------------");
        System.out.println("¿Cómo desea registrarse? ");
        String username = pedirCadenaAlUsuario("Digite el nombre de usuario que desea usar");

        while (currentLearningManagementSystem.existeUsuario(username)){

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

            Estudiante newProfesor = new Estudiante(username, password, email);

            currentLearningManagementSystem.addNewUser(newProfesor);

        }
        else if (opcionSeleccionada == 3) {
            // Volver al menu principal.
        }   

    }

    //==================================================================================================================//
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
            else if( opcionSeleccionada == 3 )
            {
                System.out.println( "Guardando información en la base de datos ..." );
                
                // Guarda la informacion en la base de datos.
                saveInformation();

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
