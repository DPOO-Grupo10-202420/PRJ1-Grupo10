//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem;

import LearningManagementSystem.mainManagementSystem.users.*;
import learningPath.actividades.actividad;
import LearningManagementSystem.mainManagementSystem.*;
import LearningManagementSystem.mainManagementSystem.activities.Actividad;

//Estructuras de datos
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

//====================================================================================
//Definicion de la clase LearningManagementSysytem
//====================================================================================

public class LearningManagementSystem {
	
	//----------------------------------------------------------------------
	// Definicion de atributos
	private HashMap<String, Usuario > usuarios;
	private HashMap<String, LearningPath > learningPaths;
	private HashMap<String, HashMap<String, Actividad> > actividadesHechas; 

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
	public LearningManagementSystem () {
		this.usuarios = new HashMap<String,Usuario>();
		this.learningPaths = new HashMap<String, LearningPath>();
	}

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase

    // Getters
	public HashMap<String ,Usuario> getUsuarios(){
		return this.usuarios;
	} 
		
	public HashMap<String, LearningPath> getLearningPaths(){
		return this.learningPaths;
	} 

	// Metodos
    public void addNewLearningPath(String titulo, String descripcion, String nivelDificultad, int duracion) throws Exception {
		
		if (learningPaths.containsKey(titulo)) {
			throw new Exception("Ya existe un learning path con ese titulo");
		}

		LearningPath path = new LearningPath(titulo, descripcion, nivelDificultad, duracion);
		learningPaths.put(titulo, path);
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

	public void terminarActividad(String username, String tituloLearningPath, actividad tituloActividad) {
		Usuario usuario = usuarios.get(username);
		if (usuario instanceof Estudiante) {
			Estudiante estudiante = (Estudiante) usuario;
			estudiante.terminarActividad();
			LearningPath learningPath = learningPaths.get(tituloLearningPath);
			// Actividad actividad = learningPath.getActividad(tituloActividad);
		}
	}

}