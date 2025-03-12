package modelo;

import modelo.enumeraciones.Genero;

public abstract class Media implements Comparable<Media> {
    private static int contador;
    private Integer id;
    private String titulo;
    private String creador;
    private Genero genero;

    public Media(String creador, String titulo, Genero genero) {
        this.id = ++contador;
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
    }

    @Override
    public int compareTo(Media otra) {
        return this.id.compareTo(otra.id);
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCreador() {
        return creador;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Genero getGenero(){
        return genero;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", creador='" + creador + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }

}
