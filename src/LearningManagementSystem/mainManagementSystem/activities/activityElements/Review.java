package LearningManagementSystem.mainManagementSystem.activities.activityElements;

public class Review {
    private String contenido;
    private int rating;

    public Review(String contenido, int rating) {
        this.contenido = contenido;
        this.rating = rating;
    }

    public String getContenido() {
        return contenido;
    }

    public int getRating() {
        return rating;
    }


    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    // Necesita una funcion para hacer un calculo de rating? PROMEDIO DE RATING
}