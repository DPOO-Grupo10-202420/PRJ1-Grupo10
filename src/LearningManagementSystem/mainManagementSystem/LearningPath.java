package LearningManagementSystem.mainManagementSystem;



import LearningManagementSystem.mainManagementSystem.activities.*;
import LearningManagementSystem.mainManagementSystem.*;


import java.util.ArrayList;
import java.util.List;

public class LearningPath {
    private String titulo;
    private String descripcionGeneral;
    private int duracion;
    private int rating;
    private List<Actividad> secuenciaActividades;
    private java.util.Date fechaCreacion;
    private java.util.Date fechaModificacion;
    private String version;


    public LearningPath(String titulo, String descripcionGeneral) {
        this.titulo = titulo;
        this.descripcionGeneral = descripcionGeneral;
        this.secuenciaActividades = new ArrayList<>();
    }

    public void addActivity(Actividad actividad) {
        secuenciaActividades.add(actividad);
        calcularDuracion();
    }

    public void removeActivity(Actividad actividad) {
        secuenciaActividades.remove(actividad);
        calcularDuracion();
    }

    public int calcularDuracion() {
        duracion = 0;
        for (Actividad actividad : secuenciaActividades) {
            duracion += 30; // No hay meotdo que se llame getDuracionEsperada // Solamente un get
        }
        return duracion;
    }

    public List<Actividad> getsecuenciaActividades() {
        return secuenciaActividades;
    }
}