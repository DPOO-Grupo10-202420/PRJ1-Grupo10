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
	private String respuestaEstudiante;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public PreguntaAbierta(String enunciado, String retroalimentacion, boolean isAbierta) {
        super(enunciado, retroalimentacion, true);
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
        return this.respuestaEstudiante == "";
    }
}