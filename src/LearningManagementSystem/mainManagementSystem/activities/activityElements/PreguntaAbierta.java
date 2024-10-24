//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities.activityElements;
//====================================================================================
//Definicion de la clase PREGUNTA
//====================================================================================
public class PreguntaAbierta extends Pregunta {
	
	//----------------------------------------------------------------------
	// Definicion de atributos
	private String respuestaProfesor;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public PreguntaAbierta(String enunciado, String retroalimentacion, boolean isAbierta) {
        super(enunciado, retroalimentacion, true);
    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase

    public void agregarRespuesta(String respuesta) {
        this.respuestaProfesor = respuesta;
    }

    public String getRespuesta() {
        return this.respuestaProfesor;
    }
    public boolean esRespondida() {
        return this.respuestaProfesor == "";
    }
}