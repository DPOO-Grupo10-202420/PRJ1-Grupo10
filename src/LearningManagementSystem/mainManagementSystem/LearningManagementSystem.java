//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem;

import LearningManagementSystem.mainManagementSystem.users.*;
import LearningManagementSystem.mainManagementSystem.*;

//Estructuras de datos
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;
import java.util.HashMap;
import java.util.Collection;


//====================================================================================
//Definicion de la clase LearningManagementSysytem
//====================================================================================

public class LearningManagementSystem {
	
	//----------------------------------------------------------------------
	// Definicion de atributos
	
	private HashMap<String, Usuario > usuarios;
	private HashMap<String, LearningPath > learningPaths;
	
	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
	
	public LearningManagementSystem () {
		
		this.usuarios = new HashMap<String,Usuario>();
		this.learningPaths = new HashMap<String, LearningPath>();
		
	}
	
	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
	
	
    // Getters
	
	public Collection<Usuario> getUsuarios(){
		
		return this.usuarios;
	} 
		
	public Collection<Usuario> getLearningPaths(){
		
		return this.learningPaths;
	} 
	
	
	// Metodos
	
    public void addNewLearningPath(LearningPath path) {
        
    }
	
    public void addNewUser(Usuario usuario) {
        usuarios.put(usuario.getUsername(), usuario);
    }
	
	
	
    public void deleteLearningPath(String titulo) {
        learningPaths.remove(titulo);
    }
	
    public void deleteUser(String username) {
        usuarios.remove(username);
    }
	
	
	

	
	
	
}