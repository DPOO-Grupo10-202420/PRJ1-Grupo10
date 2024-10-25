package LearningManagementSystem.mainManagementSystem.activities.activityElements;

public class Review {
    private String contenido;
    private int rating;
    private String autor;

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

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    // Necesita una funcion para hacer un calculo de rating? PROMEDIO DE RATING
}