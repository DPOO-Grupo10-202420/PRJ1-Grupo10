//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem;

import LearningManagementSystem.mainManagementSystem.activities.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

// import Usuario;


//====================================================================================
// Definicion de la clase LearningPath
//====================================================================================

public abstract class LearningPath  {
    
	//----------------------------------------------------------------------
	// Definicion de atributos
	
    String titulo;
    String descripcion;
    String nivelDificultad;
    int duracion;
    double rating;
    Date fechaCreacion;
    Date fechaModificacion;
    String version;


	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    
    public LearningPath (String titulo, String descripcion, String nivelDificultad, int duracion) {

        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nivelDificultad = nivelDificultad;
        this.duracion = duracion;

    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    

    // Getters

    public String getTitulo() {
        return this.titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getNivelDificultad() {
        return this.nivelDificultad;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public double getRating() {
        return this.rating;
    }

    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

    public String getVersion() {
        return this.version;
    }


    // Setters

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNivelDificultad(String nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    // Metodos

    public void addActividad(){

    }

    public void removeActividad(){

    }

    public int calcularDuracion(){
        return 0;
    }

    public void calcularProgreso(){

    }

    public void getSiguienteActividad(){

    }




    // meotodos

    public void addActivity(Actividad actividad) {
        secuenciaActividades.add(actividad);
        calcularDuracion();
    }

    public void removeActivity(Actividad actividad) {
        secuenciaActividades.remove(actividad);
        calcularDuracion();
    }

    public int calcularDuracion() {
        duracion = 0;
        for (Actividad actividad : secuenciaActividades) {
            duracion += 30; // No hay meotdo que se llame getDuracionEsperada // Solamente un get
        }
        return duracion;
    }

    public List<Actividad> getsecuenciaActividades() {
        return secuenciaActividades;
    }
}