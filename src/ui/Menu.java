package ui;

import modelo.Media;
import modelo.implementaciones.FactoryImpl;
import repositorios.implementaciones.BiblionecaImpl;
import repositorios.interfaces.IBiblioteca;

import java.util.Scanner;

public class Menu {
    BiblionecaImpl<Media> biblioteca;
    FactoryImpl factory;

    public Menu(){
        this.biblioteca = new BiblionecaImpl<>();
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
                    System.out.println("Agregando juego a la colección...");
                    biblioteca.agregar(factory.crearJuego());
                    break;
                case 2:
                    System.out.println("Agregando expancion a la colección...");
                    biblioteca.agregar(factory.crearExpancion());
                    break;
                case 3:
                    System.out.println("Mostrando colección...");
                    biblioteca.mostrar();
                    break;
                case 4:
                    System.out.println("Filtrando por género...");
                    biblioteca.filtrar(scanner);
                    break;
                case 5:
                    System.out.println("Modificando un juego o expanción...");
                    biblioteca.modificar(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del menú. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("⚠ Opción inválida. Intenta nuevamente.");
            }

        } while (option != 6);
        scanner.close();
    }

    public void listarMenu() {
        System.out.println("----- MENU -----");
        System.out.println("1. Crear un Juego");
        System.out.println("2. Crear una expancion");
        System.out.println("3. Mostrar colleccion de juegos y expanciones");
        System.out.println("4. Filtrar clleccion por genero");
        System.out.println("5. Modificar un juego o expansión");
        System.out.println("6. Salir");
        System.out.println("Elegi el numero de option: ");
    }

}
