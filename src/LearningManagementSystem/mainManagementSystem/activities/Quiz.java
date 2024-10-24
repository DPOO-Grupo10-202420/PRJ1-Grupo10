//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.Pregunta;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.PreguntaMultiple;

//Estructuras de datos
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;


//====================================================================================
//Definicion de la clase Quiz
//====================================================================================

public class Quiz extends Actividad {
	
	//----------------------------------------------------------------------
	// Definicion de atributos
	
    private List<Pregunta> Preguntas = new ArrayList<Pregunta>();
    private double calificacionMinima;
    
    
    
	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    
    public Quiz(String descripcion, String objetivo, String dificultad, int tiempoEstimado, Date fechaDeCierre, boolean obligatoria, String creador, double calificacionMinima) {
        
    	super(descripcion, objetivo, dificultad,  tiempoEstimado, fechaDeCierre, obligatoria, creador);
        this.calificacionMinima = calificacionMinima;
    
    }
    
    
	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    
    public void agregarPregunta(Pregunta Pregunta) {
        this.Preguntas.add(Pregunta);
    }

    public List<Pregunta> getPreguntas() {
        return this.Preguntas;
    }

    public double getCalificacionMinima() {
        return this.calificacionMinima;
    }

    public double calificar() {
        int respuestasCorrectas = 0;
        int totalPreguntas = Preguntas.size();

        for (Pregunta pregunta : Preguntas) {
            if (pregunta instanceof PreguntaMultiple) {
                PreguntaMultiple handle = (PreguntaMultiple) pregunta;
                if (handle.esCorrecta()) {
                    respuestasCorrectas++;
                }
            }
        }

        return (double) respuestasCorrectas / totalPreguntas * 100;  // Calificación en porcentaje
    }


}





