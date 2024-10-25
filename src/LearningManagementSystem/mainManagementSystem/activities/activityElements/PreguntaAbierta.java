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
    private String respuestaAlumno;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public PreguntaAbierta(String enunciado, String retroalimentacion, boolean isAbierta) {
        super(enunciado, retroalimentacion, true);
        this.respuestaAlumno = "";
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

    public void responder(String respuesta) {
        this.respuestaAlumno = respuesta;
    }

    public String getRespuestaAlumno() {
        return this.respuestaAlumno;
    }
}