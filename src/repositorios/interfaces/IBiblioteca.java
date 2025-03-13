package repositorios.interfaces;

import modelo.Media;
import modelo.enumeraciones.Genero;

import java.util.List;
import java.util.Scanner;

public interface IBiblioteca<T extends Media> {

    void agregar(T item);
    void eliminar();
    void mostrar();
    List<T> filtrar (Scanner sc);
    void modificar(Scanner sc);
}
