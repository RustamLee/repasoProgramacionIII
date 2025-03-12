package modelo.expansiones;

import modelo.Media;
import modelo.enumeraciones.Genero;

import java.time.LocalDateTime;

public class Expancione extends Media {

    private LocalDateTime fechaLanzamiento;

    public Expancione(String creador, String titulo, Genero genero, LocalDateTime fechaLanzamiento) {
        super(creador, titulo, genero);
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "Expancione{" +
                super.toString() +
                "fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }
}
