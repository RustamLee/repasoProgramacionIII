package modelo.interfaces;

import modelo.enumeraciones.Genero;
import modelo.implementaciones.ExpancionImpl;
import modelo.implementaciones.FactoryImpl;
import modelo.implementaciones.JuegoImpl;

import java.time.LocalDateTime;

public interface FactoryBase {
    JuegoImpl crearJuego();
    ExpancionImpl crearExpancion();
}
