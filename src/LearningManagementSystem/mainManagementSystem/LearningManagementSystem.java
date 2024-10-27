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
	private HashMap<String, Usuario > usuarios = new HashMap<String, Usuario>();
	private HashMap<String, LearningPath > learningPaths = new HashMap<String, LearningPath>();
	private HashMap<String, HashMap<String, Actividad> > actividadesHechasPorEstudiantes = new HashMap<String, HashMap<String, Actividad>>();
	private HashMap<String, Actividad> actividadesEnElSistema = new HashMap<String, Actividad>(); // String = Id actividad;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
	public LearningManagementSystem () {
		this.usuarios = new HashMap<String,Usuario>();
		this.learningPaths = new HashMap<String, LearningPath>();
		this.actividadesEnElSistema = new HashMap<String, Actividad>();
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

	public Collection<LearningPath> getLearningPaths(){
		return learningPaths.values();
	}

	public boolean existeLearningPath(String name){
		return learningPaths.containsKey(name);
	} 

	// Metodos
    public LearningPath addNewLearningPath(String titulo, String descripcion, String nivelDificultad, String creador) throws Exception {
		if (learningPaths.containsKey(titulo)) {
			throw new Exception("Ya existe un learning path con ese titulo");
		}

		LearningPath path = new LearningPath(titulo, descripcion, nivelDificultad, creador);
		path.setFechaCreacion(new Date());
		learningPaths.put(titulo, path);
		return path;
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

	public void addNewActivity(Actividad actividad) {
		actividadesEnElSistema.put(actividad.getNombre(), actividad);
	}

	public void deleteActivity(String nombre) {
		actividadesEnElSistema.remove(nombre);
	}

	public boolean existeActividad(String nombre) {
		return actividadesEnElSistema.containsKey(nombre);
	}

	public Actividad getActividad(String nombre) {
		return actividadesEnElSistema.get(nombre);
	}

	public HashMap<String, Actividad> getActividadesHechasPorEstudiantes(String nombreActividad) {
		return actividadesHechasPorEstudiantes.get(nombreActividad);
	}

	public Collection<Actividad> getActividadesEnElSistema() {
		return actividadesEnElSistema.values();
	}
	

	public Actividad getActividadPorNombre(String nombre) {
		return actividadesEnElSistema.get(nombre);
	}

	public void terminarActividad(String username, Actividad tituloActividad) {
		Usuario usuario = usuarios.get(username);
		if (usuario instanceof Profesor) {
			Profesor Profesor = (Profesor) usuario;
			//Profesor.terminarActividad();
			String nombreActividad = tituloActividad.getNombre();
			HashMap<String, Actividad> usuarios = actividadesHechasPorEstudiantes.get(nombreActividad);
			if (usuarios == null) {
				usuarios = new HashMap<String, Actividad>();
				actividadesHechasPorEstudiantes.put(nombreActividad, usuarios);
			}
			usuarios.put(username, tituloActividad);
		}
	}

}