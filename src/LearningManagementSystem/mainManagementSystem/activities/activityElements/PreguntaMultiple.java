//====================================================================================
// Definicion del package e importacion de modulos
//====================================================================================

package LearningManagementSystem.mainManagementSystem.activities.activityElements;
//====================================================================================
//Definicion de la clase Quiz
//====================================================================================
import java.util.List;
import java.util.ArrayList;
public class PreguntaMultiple extends Pregunta {
        
    //----------------------------------------------------------------------
    // Definicion de atributos
    private int respuestaCorrecta; // Indice de la respuesta seleccionada
    private List<String> opciones = new ArrayList<String>();
    private int respuestaSeleccionada;

    //----------------------------------------------------------------------
    // Metodo constructor de la clase.
    public PreguntaMultiple(String enunciado, String retroalimentacion, boolean isAbierta, ArrayList<String> opciones, int respuestaCorrecta) {
        super(enunciado, retroalimentacion, isAbierta);
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    //----------------------------------------------------------------------
    // Definicion de metodos de la clase
    public void setRespuesta(int respuesta) {
        this.respuestaSeleccionada = respuesta;
    }

    public boolean verificarRespuesta() {
        return this.respuestaSeleccionada == this.respuestaCorrecta;
    }
}