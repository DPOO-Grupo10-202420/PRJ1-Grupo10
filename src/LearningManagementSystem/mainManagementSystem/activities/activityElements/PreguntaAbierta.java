//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities.activityElements;
//====================================================================================
//Definicion de la clase Quiz
//====================================================================================
public class PreguntaAbierta extends Pregunta {
	
	//----------------------------------------------------------------------
	// Definicion de atributos
	private String respuesta;

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public PreguntaAbierta(String enunciado, String retroalimentacion, boolean isAbierta) {
        super(enunciado, retroalimentacion, isAbierta);
    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
}





