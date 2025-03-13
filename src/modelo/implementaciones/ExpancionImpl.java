package modelo.implementaciones;

import modelo.Media;
import modelo.enumeraciones.Genero;
import modelo.interfaces.ExpancionBase;

import java.time.LocalDateTime;

public class ExpancionImpl extends Media implements ExpancionBase {

    private LocalDateTime fechaLanzamiento;

    public ExpancionImpl(String creador, String titulo, Genero genero, LocalDateTime fechaLanzamiento) {
        super(creador, titulo, genero);
        if(fechaLanzamiento == null){
            throw new IllegalArgumentException("La fecha de lanzamiento no puede ser nulo! ");
        }
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "Expancione{" +
                super.toString() +
                "fechaLanzamiento=" + fechaLanzamiento +
                '}';
    }


    @Override
    public LocalDateTime getFechaDeLanzamiento() {
        return null;
    }

    @Override
    public void setFechaDeLanzamiento(LocalDateTime fecha) {

    }

}
