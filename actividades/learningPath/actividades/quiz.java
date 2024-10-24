package learningPath.actividades;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class quiz extends actividad {

    private List<pregunta> preguntas = new ArrayList<pregunta>();
    private double calificacionMinima;

    public quiz(String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador, double calificacionMinima) {
        super(descripcion, objetivo, dificultad,  tiempoEstimado, fechaDeCierre, obligatoria, creador);
        this.calificacionMinima = calificacionMinima;
    }

    public void agregarPregunta(pregunta pregunta) {
        this.preguntas.add(pregunta);
    }

    public List<pregunta> getPreguntas() {
        return this.preguntas;
    }

    public double getCalificacionMinima() {
        return this.calificacionMinima;
    }
}
