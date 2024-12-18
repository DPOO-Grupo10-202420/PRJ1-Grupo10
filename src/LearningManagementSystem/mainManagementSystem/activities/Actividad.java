//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
// import Usuario;
//====================================================================================
//Definicion de la clase Actividad
//====================================================================================
public abstract class Actividad implements Cloneable {
	//----------------------------------------------------------------------
	// Definicion de atributos
    private String nombre; // no puede estar repetido en un learningPath
    private String descripcion;
    private String objetivo;
    private String dificultad;
    private int tiempoEstimado; //MINUTOS;
    private Date fechaDeCierre;
    private boolean obligatoria;
    private String creador;

    private List<Actividad> ActividadesPrevias = new ArrayList<Actividad>();
    private List<Actividad> ActividadesDeSeguimiento = new ArrayList<Actividad>();
    private List<Review> reviews = new ArrayList<Review>();

    private String resultado;
    private String estado; // EXITOSA - NO EXITOSA - ENVIADA - NO ENVIADA - COMPLETADA
    private double rating;
    private List<String> comentarios = new ArrayList<String>();
    // private String feedback; //feedback de la Actividad

    private List<String> estudiantesQueCompletaronActividad = new ArrayList<String>();

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public Actividad(String nombre, String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.dificultad = dificultad;
        this.tiempoEstimado = tiempoEstimado;
        this.fechaDeCierre = fechaDeCierre;
        this.obligatoria = obligatoria;
        this.creador = creador;
    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    
    //Getters

    public Map<String,Object> getInfoActividad () {
        HashMap<String, Object> infoActividad = new HashMap<String, Object>();
        infoActividad.put("descripcion", this.descripcion);
        infoActividad.put("objetivo", this.objetivo);
        infoActividad.put("dificultad", this.dificultad);
        infoActividad.put("tiempoEstimado", this.tiempoEstimado);
        infoActividad.put("fechaDeCierre", this.fechaDeCierre);
        infoActividad.put("obligatoria", this.obligatoria);
        infoActividad.put("creador", this.creador);
        infoActividad.put("resultado", this.resultado);
        infoActividad.put("rating", this.rating);
        infoActividad.put("comentarios", this.comentarios);
        return infoActividad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public String getDificultad() {
        return this.dificultad;
    }

    public int getTiempoEstimado() {
        return this.tiempoEstimado;
    }

    public Date getFechaDeCierre() {
        return this.fechaDeCierre;
    }

    public boolean getIsObligatoria() {
        return this.obligatoria;
    }

    public String getCreador() {
        return this.creador;
    }

    public List<Actividad> getActividadesPrevias() {
        return this.ActividadesDeSeguimiento;
    }

    public String getResultado() {
        return this.resultado;
    }

    public String getEstado() {
        return this.estado;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getComentaros() {
        return this.comentarios;
    }

    // Metodos
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setComentario (String comentario) {
        this.comentarios.add(comentario);
    }

    public void addActividadPrevia(Actividad Actividad) {
        this.ActividadesPrevias.add(Actividad);
    }

    public void addActividadDeSeguimiento(Actividad Actividad) {
        this.ActividadesDeSeguimiento.add(Actividad);
    }



    public void marcarComoEnviada() {
        this.estado = "ENVIADA";
    }

    public void marcarComoExitosa() {
        this.estado = "EXITOSA";
    }

    public void marcarComoNoExitosa() {
        this.estado = "NO EXITOSA";
    }

    public void addReview(String contenido, int rating, String nombreUsuario) {
        Review review = new Review(contenido, rating, nombreUsuario);
        
        reviews.add(review);
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    @Override
    public Actividad clone() throws CloneNotSupportedException {
        Actividad clon = (Actividad) super.clone();
        for (Actividad actividad : ActividadesPrevias) {
            clon.addActividadPrevia(actividad);
        }
        for (Actividad actividad : ActividadesDeSeguimiento) {
            clon.addActividadDeSeguimiento(actividad);
        }

        if(this instanceof Quiz) {
            // CLONAMOS LAS PREUGNTAS
            Quiz quiz = (Quiz) this;
            Quiz clonQuiz = (Quiz) clon;
            for (Pregunta pregunta : quiz.getPreguntas()) {
                Pregunta clonPregunta = (Pregunta) pregunta.clone();
                clonQuiz.agregarPregunta(clonPregunta);
            }
        }else if(this instanceof Examen) {
            // CLONAMOS LAS PREUGNTAS
            Examen examen = (Examen) this;
            Examen clonExamen = (Examen) clon;
            for (Pregunta pregunta : examen.getPreguntas()) {
                PreguntaAbierta clonPregunta = (PreguntaAbierta) pregunta.clone();
                clonExamen.agregarPregunta(clonPregunta);
            }
        }else if(this instanceof Encuesta) {
            // CLONAMOS LAS PREUGNTAS
            Encuesta encuesta = (Encuesta) this;
            Encuesta clonEncuesta = (Encuesta) clon;
            for (Pregunta pregunta : encuesta.getPreguntas()) {
                Pregunta clonPregunta = (Pregunta) pregunta.clone();
                clonEncuesta.agregarPregunta(clonPregunta);
            }
        }
        return clon;
    }



}