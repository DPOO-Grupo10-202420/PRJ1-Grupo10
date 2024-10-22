//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities.activityElements;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.Pregunta;

//Estructuras de datos
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.lang.String;


//====================================================================================
//Definicion de la clase PREGUNTA
//====================================================================================

public class PreguntaAbierta extends Pregunta {
	
	//----------------------------------------------------------------------
	// Definicion de atributos
	private String respuestaEstudiante;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public PreguntaAbierta(String enunciado, String retroalimentacion, boolean isAbierta) {
        super(enunciado, retroalimentacion, true);
		this.respuestaEstudiante = "";
    }
		//----------------------------------------------------------------------
    // Definicion de metodos de la clase

    public void agregarRespuesta(String respuesta) {
        this.respuestaEstudiante = respuesta;
    }

    public String getRespuesta() {
        return this.respuestaEstudiante;
    }
    public boolean esRespondida() {
        return !this.respuestaEstudiante.isEmpty();
    }
}