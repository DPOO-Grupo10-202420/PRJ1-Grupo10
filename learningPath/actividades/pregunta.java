package learningPath.actividades;

public abstract class pregunta {

    private String enunciado;
    private String retroalimentacion;
    private boolean isAbierta; 


    public pregunta(String enunciado, String retroalimentacion, boolean isAbierta) {
        this.enunciado = enunciado;
        this.retroalimentacion = retroalimentacion;
        this.isAbierta = isAbierta;
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public String getRetroalimentacion() {
        return this.retroalimentacion;
    }

    public boolean getIsAbierta() {
        return this.isAbierta;
    }

}
