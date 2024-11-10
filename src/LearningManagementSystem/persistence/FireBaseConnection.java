//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.persistence;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;

import LearningManagementSystem.mainManagementSystem.users.*;
import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.mainManagementSystem.*;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//====================================================================================
//Definicion de la clase FireBaseConnection
//====================================================================================

public class FirebaseConnection {
    
    //----------------------------------------------------------------------
	// Definicion de atributos
    private DatabaseReference database;

    private LearningManagementSystem currentLearningManagementSystem;
    
    //----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public FirebaseConnection(LearningManagementSystem currentLearningManagementSystem) {
        // Inicializar la configuración de Firebase
        this.currentLearningManagementSystem = currentLearningManagementSystem;

        FileInputStream serviceAccount = new FileInputStream("learningmanagementsystem-g10-firebase-adminsdk-f4147-e38cd81bea.json");
        
        FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .setDatabaseUrl("https://learningmanagementsystem-g10-default-rtdb.firebaseio.com")
          .build();
        
        FirebaseApp.initializeApp(options);
        
        // Obtener una referencia a la base de datos
        database = FirebaseDatabase.getInstance().getReference();
    }


	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    //----------------------------------------------------------------------


    //-------------------------------------------------------------------------------------------------
    // Escritura de datos

    // Metodo para agregar un usuario
    public void addUsuario(String nombreUsuario, Usuario usuario) {
        database.child("usuarios").child(nombreUsuario).setValue(usuario);
    }

    // Metodo para agregar una actividad al sistema
    public void addActividad(String idActividad, Actividad actividad) {
        database.child("actividadesEnElSistema").child(idActividad).setValue(actividad);
    }

    // Metodo para agregar un LearningPath
    public void addLearningPath(String idLearningPath, LearningPath learningPath) {
        database.child("learningPaths").child(idLearningPath).setValue(learningPath);
    }

    // Metodo para registrar una actividad hecha por un estudiante
    public void addActividadHechaPorEstudiante(String idActividad, String nombreUsuario, Actividad actividad) {
        database.child("actividadesHechasPorEstudiantes").child(idActividad).child(nombreUsuario).setValue(actividad);
    }



    //-------------------------------------------------------------------------------------------------
    // Lectura de datos

    public void loadUsuarios() {
        database.child("usuarios").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    Usuario usuario = userSnapshot.getValue(Usuario.class);
                    if (usuario != null) {
                        usuarios.add(usuario);
                    }
                }
                System.out.println("Usuarios cargados: " + usuarios.size());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Error al cargar usuarios: " + databaseError.getMessage());
            }
        });
    }


    public void loadActividadesEnElSistema() {
    database.child("actividadesEnElSistema").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot actividadSnapshot : dataSnapshot.getChildren()) {
                Actividad actividad = actividadSnapshot.getValue(Actividad.class);
                if (actividad != null) {
                    actividadesEnElSistema.add(actividad);
                }
            }
            System.out.println("Actividades cargadas: " + actividadesEnElSistema.size());
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            System.out.println("Error al cargar actividades: " + databaseError.getMessage());
        }
    });
    }



    public void loadLearningPaths() {
    database.child("learningPaths").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot pathSnapshot : dataSnapshot.getChildren()) {
                LearningPath learningPath = pathSnapshot.getValue(LearningPath.class);
                if (learningPath != null) {
                    learningPaths.add(learningPath);
                }
            }
            System.out.println("Learning Paths cargados: " + learningPaths.size());
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            System.out.println("Error al cargar learning paths: " + databaseError.getMessage());
        }
    });
    }


    public void loadActividadesHechasPorEstudiantes() {
    database.child("actividadesHechasPorEstudiantes").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot actividadSnapshot : dataSnapshot.getChildren()) {
                String idActividad = actividadSnapshot.getKey();
                Map<String, Actividad> estudiantesActividades = new HashMap<>();
                
                for (DataSnapshot estudianteSnapshot : actividadSnapshot.getChildren()) {
                    String nombreUsuario = estudianteSnapshot.getKey();
                    Actividad actividad = estudianteSnapshot.getValue(Actividad.class);
                    estudiantesActividades.put(nombreUsuario, actividad);
                }
                
                actividadesHechasPorEstudiantes.put(idActividad, estudiantesActividades);
            }
            System.out.println("Actividades hechas por estudiantes cargadas: " + actividadesHechasPorEstudiantes.size());
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            System.out.println("Error al cargar actividades hechas por estudiantes: " + databaseError.getMessage());
        }
    });
}







}
