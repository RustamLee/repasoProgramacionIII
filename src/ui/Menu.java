package ui;

import excepciones.IdNoEncontradoException;
import modelo.Media;
import modelo.implementaciones.ExpancionImpl;
import modelo.implementaciones.FactoryImpl;
import modelo.implementaciones.JuegoImpl;
import modelo.interfaces.FactoryBase;
import repositorios.implementaciones.BibliotecaImpl;
import repositorios.interfaces.BibliotecaBase;

import java.util.List;
import java.util.Scanner;

public class Menu {
    BibliotecaBase<Media> biblioteca;
    FactoryBase factory;

    public Menu(){
        this.biblioteca = new BibliotecaImpl<>();
        this.factory = new FactoryImpl();
    }
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do {
            listarMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("El numero no valido! ");
                continue;
            }
            switch (option) {
                case 1:
                    System.out.println("Crear y agregando juego a la colección...");
                    JuegoImpl juego = factory.crearJuego();
                    if (juego != null) {
                        biblioteca.agregar(juego);
                    } else {
                        System.out.println("No se pudo crear el juego debido a un error.");
                    }
                    break;
                case 2:
                    System.out.println("Crear y agregando expansión a la colección...");
                    ExpancionImpl expansion = factory.crearExpancion();
                    if (expansion != null) {
                        biblioteca.agregar(expansion);
                    } else {
                        System.out.println("No se pudo crear la expansión debido a un error.");
                    }
                    break;

                case 3:
                    System.out.println("Mostrando colección...");
                    biblioteca.mostrar();
                    break;
                case 4:
                    System.out.println("Filtrando por género...");
                    List<Media> lista = biblioteca.filtrar(scanner);
                    if(!lista.isEmpty()){
                        for(Media m:lista){
                            System.out.println(m);
                        }
                    } else System.out.println("Lista esta vacia!");
                    break;
                case 5:
                    System.out.println("Modificando un juego o expanción...");
                    biblioteca.modificar(scanner);
                    break;
                case 6:
                    try {
                        System.out.println("Eliminar elemento desde colleccion...");
                        biblioteca.eliminar(scanner);
                    } catch (IdNoEncontradoException e){
                        System.out.println("Error " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del menú. Hasta luego!");
                    break;
                default:
                    System.out.println("⚠ Opción inválida. Intenta nuevamente.");
            }

        } while (option != 7);
        scanner.close();
    }

    public void listarMenu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1. Crear y agregar un Juego a colleccion");
        System.out.println("2. Crear y agregar una expancion a colleccion");
        System.out.println("3. Mostrar colleccion de juegos y expanciones");
        System.out.println("4. Filtrar clleccion por genero");
        System.out.println("5. Modificar un juego o expansión");
        System.out.println("6. Eliminar un juego o expansión desde colleccion");
        System.out.println("7. Salir");
        System.out.println("Elegi el numero de option: ");
    }

}
