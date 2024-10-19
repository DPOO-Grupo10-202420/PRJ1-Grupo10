package learningPath.actividades;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
// import Usuario;

public abstract class actividad  {
    
    // private String id; // id de la actividad (generado por el sistema)
    private String descripcion;
    private String objetivo;
    private String dificultad;
    private int tiempoEstimado; //MINUTOS;
    private Date fechaDeCierre;
    private boolean obligatoria;
    private String creador;

    private List<actividad> actividadesPrevias = new ArrayList<actividad>();
    private List<actividad> actividadesDeSeguimiento = new ArrayList<actividad>();

    private String resultado;
    private double rating;
    private List<String> comentarios = new ArrayList<String>();
    // private String feedback; //feedback de la actividad


    public actividad(String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador) {
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.dificultad = dificultad;
        this.tiempoEstimado = tiempoEstimado;
        this.fechaDeCierre = fechaDeCierre;
        this.obligatoria = obligatoria;
        this.creador = creador;
    }

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

    private void setResultado(String resultado) {
        this.resultado = resultado;
    }

    private String getResultado() {
        return this.resultado;
    }

    private double getRating() {
        return this.rating;
    }

    private void setComentario (String comentario) {
        this.comentarios.add(comentario);
    }

    private void addActividadPrevia(actividad actividad) {
        this.actividadesPrevias.add(actividad);
    }

    private void addActividadDeSeguimiento(actividad actividad) {
        this.actividadesDeSeguimiento.add(actividad);
    }

}

