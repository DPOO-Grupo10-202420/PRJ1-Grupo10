//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem;

import LearningManagementSystem.mainManagementSystem.users.*;
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

	public Usuario getUsuario(String nombre){
		return usuarios.get(nombre);
	} 

	public boolean existeUsuario (String nombre){
		return usuarios.containsKey(nombre);
	} 
		
	public LearningPath getLearningPath(String nombre){
		return learningPaths.get(nombre);
	} 

	public boolean existeLearningPath(String name){
		return learningPaths.containsKey(name);
	} 

	// Metodos
    public void addNewLearningPath(String titulo, String descripcion, String nivelDificultad) throws Exception {
		
		if (learningPaths.containsKey(titulo)) {
			throw new Exception("Ya existe un learning path con ese titulo");
		}

		LearningPath path = new LearningPath(titulo, descripcion, nivelDificultad);
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

	public void terminarActividad(String username, Actividad tituloActividad) {
		Usuario usuario = usuarios.get(username);
		if (usuario instanceof Profesor) {
			Profesor Profesor = (Profesor) usuario;
			//Profesor.terminarActividad();
			String nombreActividad = tituloActividad.getNombre();
			HashMap<String, Actividad> usuarios = actividadesHechas.get(nombreActividad);
			if (usuarios == null) {
				usuarios = new HashMap<String, Actividad>();
				actividadesHechas.put(nombreActividad, usuarios);
			}
			usuarios.put(username, tituloActividad);
		}
	}

}