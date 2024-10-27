//====================================================================================
// Importacion de modulos
//====================================================================================
package LearningManagementSystem.console;

import LearningManagementSystem.mainManagementSystem.LearningManagementSystem;
import LearningManagementSystem.mainManagementSystem.LearningPath;
import LearningManagementSystem.mainManagementSystem.activities.Actividad;
import LearningManagementSystem.mainManagementSystem.activities.Examen;
import LearningManagementSystem.mainManagementSystem.activities.Quiz;
import LearningManagementSystem.mainManagementSystem.users.*;
import java.util.Date;

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

public void configurarLearningPathDePrueba() {
    try {
        // Crear usuario profesor de prueba
        Profesor profesor = new Profesor("profesor1", "password123", "A");
        currentLearningManagementSystem.addNewUser(profesor);

        // Crear un Learning Path
        LearningPath learningPath = currentLearningManagementSystem.addNewLearningPath(
            "Java Programming Basics",
            "Learning Path para principiantes en Java",
            "Básico",
            "profesor1"
        );

        Date fechaCierre = new Date(); // Fecha actual como ejemplo

        // Agregar diferentes tipos de actividades
        learningPath.addRecurso("Introducción a Java", "Recurso de introducción", "Entender conceptos básicos", "Básico", 20, fechaCierre, true, "profesor1", "Video", "https://example.com/introduccion-java");
        learningPath.addTarea("Tarea 1 - Sintaxis Java", "Practicar sintaxis", "Practicar conceptos básicos", "Básico", 30, fechaCierre, true, "profesor1", "Ejercicios de Sintaxis");
        learningPath.addExamen("Examen Básico de Java", "Evaluar conceptos iniciales", "Evaluar conocimiento básico", "Básico", 60, fechaCierre, true, "profesor1", 5.0);
        learningPath.addQuiz("Quiz Inicial de Java", "Reforzar conceptos básicos", "Preguntas rápidas", "Básico", 15, fechaCierre, true, "profesor1", 3.0);
        learningPath.addEncuesta("Encuesta de Opinión", "Recibir feedback", "Recibir feedback de los estudiantes", "N/A", 10, fechaCierre, false, "profesor1");

        // Obtener y filtrar actividades de tipo Examen y Quiz para agregar preguntas
        for (Actividad actividad : learningPath.getSecuenciaActividades()) {
            if (actividad instanceof Examen) {
                learningPath.addPregunta((Examen) actividad, "¿Qué es un método en Java?", "Pregunta sobre conceptos básicos", true);
            } else if (actividad instanceof Quiz) {
                learningPath.addPregunta((Quiz) actividad, "¿Qué operador se usa para comparar igualdad?", "Pregunta sobre operadores", false);
            }
        }

        // Mostrar información del Learning Path de prueba
        System.out.println("Learning Path de prueba creado: " + learningPath.getTitulo());
        System.out.println("Duración total estimada: " + learningPath.calcularDuracion() + " minutos");
        System.out.println("Progreso inicial: " + learningPath.calcularProgreso() + "%");
        System.out.println("Actividades en el Learning Path de prueba:");
        for (Actividad actividad : learningPath.getSecuenciaActividades()) {
            System.out.println(" - " + actividad.getNombre() + ": " + actividad.getDescripcion());
        }
    } catch (Exception e) {
        System.out.println("Ocurrió un error al configurar el Learning Path de prueba: " + e.getMessage());
    }
}

    
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
                System.out.println("---------");
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

        if (opcionSeleccionada != 3){

            System.out.println( "\n" );
            System.out.println("------------------------------------------------------------");
            System.out.println("¿Cómo desea registrarse? ");
            String username = pedirCadenaAlUsuario("Digite el nombre de usuario que desea usar");
    
            while (currentLearningManagementSystem.existeUsuario(username)){
                
                System.out.println("El nombre de usuario elegido ya esta en uso. Digite uno distinto.");
                System.out.println( "\n" );
                username = pedirCadenaAlUsuario("Digite el nombre de usuario que desea usar");
    
            }
    
            System.out.println("------------------------------------------------------------");
            String password = pedirCadenaAlUsuario("Digite su contraseña");
            System.out.println("------------------------------------------------------------");
            String email = pedirCadenaAlUsuario("Digite su correo electrónico");
            System.out.println("------------------------------------------------------------");
            System.out.println( "\n" );

            if (opcionSeleccionada == 1) {
    
                Profesor newProfesor = new Profesor(username, password, email);
    
                currentLearningManagementSystem.addNewUser(newProfesor);
    
            }
            else if (opcionSeleccionada == 2) {
    
                Estudiante newEstudiante = new Estudiante(username, password, email);
    
                currentLearningManagementSystem.addNewUser(newEstudiante);
    
            }


        }

        //Si elije 3, regresa al menu principal.


    }

    //==================================================================================================================//
    //public void ingresarComoAdmin(){}
    public void ejecutarAplicacion( )
    {   
        System.out.println( "\n" );
        System.out.println("================================================================================");
        System.out.println("              WELCOME TO THE LEARNING PATH RECOMMENDATION SYSTEM                ");
        System.out.println("================================================================================");


        //------------------------------------------------------
        // Se carga la informacion antes de usar la aplicacion.
        //configurarLearningPathDePrueba();
        
        cargarInformacion();

        //------------------------------------------------------
        // Muestra el menu principal
        while (appExecution){

            System.out.print("\n");
            System.out.println("-------------------------------------");

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
                System.out.println( "\n" );
                System.out.println( "Guardando información en la base de datos ..." );
                System.out.println( "\n" );
                
                // Guarda la informacion en la base de datos.s
                saveInformation();

                System.out.println( "\n" );
                System.out.println( "Saliendo ..." );
                System.out.println( "\n" );
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
