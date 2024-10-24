//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities.activityElements;


//====================================================================================
//Definicion de la clase Pregunta
//====================================================================================

public abstract class Pregunta {
	
	//----------------------------------------------------------------------
	// Definicion de atributos
    protected String enunciado;
    protected String respuesta;
    protected String retroalimentacion;
    protected boolean isAbierta; 

	//----------------------------------------------------------------------
	// Metodo constructor de la clase.
    public Pregunta(String enunciado, String retroalimentacion, boolean isAbierta) {
        this.enunciado = enunciado;
        this.retroalimentacion = retroalimentacion;
        this.respuesta = "";
        this.isAbierta = isAbierta;
    }

	//----------------------------------------------------------------------
    // Definicion de metodos de la clase
    public String getEnunciado() {
        return this.enunciado;
    }

    public String getRetroalimentacion() {
        return this.retroalimentacion;
    }

    public boolean getIsAbierta() {
        return this.isAbierta;
    }

    public void cambiarEnunciado(String newEnunciado) {
        this.enunciado = newEnunciado;
    }
}