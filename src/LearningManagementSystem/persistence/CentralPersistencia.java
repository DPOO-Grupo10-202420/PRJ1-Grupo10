//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================
package LearningManagementSystem.persistence;

import LearningManagementSystem.mainManagementSystem.LearningManagementSystem;
import LearningManagementSystem.persistence.FirebaseConnection;


//====================================================================================
//Definicion de la clase CentralPersistencia
//====================================================================================

public class CentralPersistencia {

    //----------------------------------------------------------------------
	// Definicion de atributos
    private FireBaseConnection fireBaseConnection;
    private LearningManagementSystem currentLearningManagementSystem;

    //----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public CentralPersistencia(LearningManagementSystem currentLearningManagementSystem) {
        fireBaseConnection = new FireBaseConnection();
        this.currentLearningManagementSystem = currentLearningManagementSystem;
    }

    public void cargarInformacion() {

    }

    public void guardarInformacion() {

    }
}
