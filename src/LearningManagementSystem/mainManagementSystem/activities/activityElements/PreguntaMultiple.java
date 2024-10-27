

package LearningManagementSystem.mainManagementSystem.activities.activityElements;
import java.util.HashMap;

public class PreguntaMultiple extends Pregunta {
    private HashMap<String, String> opciones = new HashMap<String, String>();
    private String respuestaCorrecta;
    private String respuestaEstudiante;

    public PreguntaMultiple(String enunciado, String retroalimentacion, boolean isAbierta) {
        super(enunciado, retroalimentacion, false);
        this.opciones = new HashMap<>();
        this.respuestaCorrecta  = ""; 
        this.respuestaEstudiante = "";
    }


    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public HashMap<String, String> getOpciones() {
        return opciones;
    }

    
    public void addRespuesta(String clave, String valor) {
        if (opciones.size() < 4) {
            if (clave.equals("A") || clave.equals("B") || clave.equals("C") || clave.equals("D")) {
                opciones.put(clave, valor);
            } else {
                System.out.println("Clave de opción inválida. Debe ser 'A', 'B', 'C' o 'D'.");
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
    public boolean esCorrecta() {
        return respuestaEstudiante.equals(respuestaCorrecta);
    }

    public void setRespuestaEstudiante(String clave) {
        if (opciones.containsKey(clave)) {
            this.respuestaEstudiante = clave;
        } else {
            System.out.println("La clave no existe en las opciones disponibles.");
        }
    }
    public void mostrarOpciones() {
        System.out.println("Opciones disponibles:");
        for (String clave : opciones.keySet()) {
            System.out.println(clave + ": " + opciones.get(clave));
        }
    }
}
