//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem;

import LearningManagementSystem.mainManagementSystem.activities.*;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.*;
import learningPath.actividades.pregunta;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// import Usuario;


//====================================================================================
// Definicion de la clase LearningPath
//====================================================================================

public class LearningPath  {
    
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
    List<Actividad> secuenciaActividades = new ArrayList<Actividad>();

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public LearningPath (String titulo, String descripcion, String nivelDificultad) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nivelDificultad = nivelDificultad;
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
    public void addActividad(Actividad actividad) {
        secuenciaActividades.add(actividad);
        calcularDuracion();
    }

    public Actividad addRecurso(String nombre , String descripcion, String objetivo, String nivelDificultad, int tiempoEstimado, Date fechaCierre, boolean obligatoria, String creador, String tipoRecurso, String URLRecurso){
        Recurso recurso = new Recurso(nombre ,descripcion, objetivo, nivelDificultad, tiempoEstimado, fechaCierre, obligatoria, descripcion, tipoRecurso, URLRecurso);
        return recurso;
    }

    public Actividad addTarea(String nombreActividad, String descripcionActividad, String objetivoActividad, String dificultadActividad, int tiempoEstimadoActividad, Date fechaCierreActividad, boolean obligatoriaActividad, String creadorActividad, String tipoTarea) {
        Tarea tarea = new Tarea(nombreActividad ,descripcionActividad, objetivoActividad, dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad, tipoTarea);
        return tarea;
    }

    public Actividad addExamen(String nombreActividad, String descripcionActividad, String objetivoActividad, String dificultadActividad, int tiempoEstimadoActividad, Date fechaCierreActividad, boolean obligatoriaActividad, String creadorActividad, double calificacionMinima) {
        Examen examen = new Examen(nombreActividad ,descripcionActividad, objetivoActividad, dificultadActividad, tiempoEstimadoActividad, fechaCierreActividad, obligatoriaActividad, creadorActividad, calificacionMinima);
        return examen;
    }
    
    public void addPregunta(Actividad actividad, String enunciado, String retroalimentacion, boolean isAbierta) {
        if(isAbierta){
            PreguntaAbierta preguntaNueva = new PreguntaAbierta(enunciado, retroalimentacion, isAbierta);
            if (actividad instanceof Examen){
                Examen examen = (Examen) actividad;
                examen.agregarPregunta(preguntaNueva);
            } else if (actividad instanceof Encuesta){
                Encuesta encuesta = (Encuesta) actividad;
                encuesta.agregarPregunta(preguntaNueva);
            }
        }else{
            PreguntaMultiple preguntaNueva = new PreguntaMultiple(enunciado, retroalimentacion, isAbierta);
            if (actividad instanceof Quiz){
                Quiz examen = (Quiz) actividad;
                examen.agregarPregunta(preguntaNueva);
            } else if (actividad instanceof Encuesta){
                Encuesta encuesta = (Encuesta) actividad;
                encuesta.agregarPregunta(preguntaNueva);
            }
        }
    }

    public void removeActividad(){

    }

    public void calcularProgreso(){

    }

    public void getSiguienteActividad(){

    }

    public void removeActividad(Actividad actividad) {
        secuenciaActividades.remove(actividad);
        calcularDuracion();
    }

    public int calcularDuracion() {
        duracion = 0;
        for (Actividad actividad : secuenciaActividades) {
            duracion += actividad.getTiempoEstimado(); // No hay meotdo que se llame getDuracionEsperada // Solamente un get
        }
        return duracion;
    }

    public List<Actividad> getsecuenciaActividades() {
        return secuenciaActividades;
    }
}