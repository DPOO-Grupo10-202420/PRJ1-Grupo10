//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// import Usuario;


//====================================================================================
//Definicion de la clase Actividad
//====================================================================================
public abstract class Actividad  {
	//----------------------------------------------------------------------
	// Definicion de atributos
    // private String id; // id de la Actividad (generado por el sistema)
    private String descripcion;
    private String objetivo;
    private String dificultad;
    private int tiempoEstimado; //MINUTOS;
    private Date fechaDeCierre;
    private boolean obligatoria;
    private String creador;

    private List<Actividad> ActividadesPrevias = new ArrayList<Actividad>();
    private List<Actividad> ActividadesDeSeguimiento = new ArrayList<Actividad>();

    private String resultado;
    private double rating;
    private List<String> comentarios = new ArrayList<String>();
    // private String feedback; //feedback de la Actividad

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public Actividad(String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador) {
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
    
    private Map<String,Object> getInfoActividad () {
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

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return this.resultado;
    }

    public double getRating() {
        return this.rating;
    }

    public int getTiempoEstimado() {
        return this.tiempoEstimado;
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

}