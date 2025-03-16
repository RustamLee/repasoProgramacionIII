package repositorios.interfaces;

import modelo.Media;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public interface BibliotecaBase<T extends Media> {

    void agregar(T item);
    void eliminar(Scanner sc);
    void mostrar();
    List<T> filtrar (Scanner sc);
    void modificar(Scanner sc);
    void quardarAJson (String nombreArchivo);
    void cargarDesdeJson (String nombreArchivo);
    Map<String, T> getColleccion();
}
