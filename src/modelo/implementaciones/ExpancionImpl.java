package modelo.implementaciones;

import modelo.Media;
import modelo.enumeraciones.Genero;
import modelo.interfaces.ExpancionBase;

import java.time.LocalDateTime;

public class ExpancionImpl extends Media implements ExpancionBase {

    public String type = "expansion";
    public ExpancionImpl(String creador, String titulo, Genero genero) {
        super(creador, titulo, genero);
    }

    @Override
    public String toString() {
        return "Expancione{" +
                super.toString() +
                '}';
    }


}
