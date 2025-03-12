package modelo.juegos;

import modelo.Media;
import modelo.enumeraciones.Genero;

public class Juego extends Media {

    private String numeroVersion;

    public Juego(String creador, String titulo, Genero genero, String numeroVersion) {
        super(creador, titulo, genero);
        this.numeroVersion = numeroVersion;
    }

    @Override
    public String toString() {
        return "Juego{" +
                super.toString() +
                "numeroVersion='" + numeroVersion + '\'' +
                '}';
    }
}
