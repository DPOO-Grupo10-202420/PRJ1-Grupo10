

package LearningManagementSystem.mainManagementSystem.activities.activityElements;
import LearningManagementSystem.mainManagementSystem.activities.activityElements.Pregunta;
import java.util.HashMap;

public class PreguntaMultiple extends Pregunta {
    private HashMap<String, String> opciones;
    private String respuestaCorrecta; 

    
    public PreguntaMultiple(String enunciado, String retroalimentacion, boolean isAbierta) {

        super(enunciado, retroalimentacion, false);
        this.opciones = new HashMap<>();
        this.respuestaCorrecta  = ""; 
    }


    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public HashMap<String, String> getOpciones() {
        return opciones;
    }

    
    public void addRespuesta(String clave, String valor) {
        if (opciones.size() < 4) {
            if (clave.equals("a") || clave.equals("b") || clave.equals("c") || clave.equals("d")) {
                opciones.put(clave, valor);
            } else {
                System.out.println("Clave de opción inválida. Debe ser a, b, c o d.");
            }
        } else {
            System.out.println("No se pueden agregar más de 4 opciones.");
        }
    }

    public void setRespuestaCorrecta(String clave) {
        if (opciones.containsKey(clave)) {
            this.respuestaCorrecta = clave;
        } else {
            System.out.println("La clave no existe en las opciones disponibles.");
        }
    }

    public boolean esCorrecta(String respuesta) {
        return respuesta.equals(respuestaCorrecta);
    }


    public void mostrarOpciones() {
        System.out.println("Opciones disponibles:");
        for (String clave : opciones.keySet()) {
            System.out.println(clave + ": " + opciones.get(clave));
        }
    }
}
