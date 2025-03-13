package modelo.interfaces;

import java.time.LocalDateTime;

public interface ExpancionBase {
    String getTitulo();
    void setTitulo(String titulo);
    LocalDateTime getFechaDeLanzamiento();
    void setFechaDeLanzamiento(LocalDateTime fecha);

}
