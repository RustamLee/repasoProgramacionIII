package repositorios.interfaces;

import modelo.Media;
import modelo.enumeraciones.Genero;

import java.util.List;

public interface IBiblioteca<T extends Media> {

    void agregar(T item);
    void eliminar(String id);
    void mostrar();
    List<T> filtrar (Genero genero);
    void modificar(String id, String atributoNuevo);
}
