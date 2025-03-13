package modelo.implementaciones;

import modelo.enumeraciones.Genero;
import modelo.interfaces.FactoryBase;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FactoryImpl implements FactoryBase {


    @Override
    public JuegoImpl crearJuego() {
        // String creador, String titulo, Genero genero, double numeroVersion
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de creador: ");
        String creador = scanner.nextLine();
        System.out.println("Ingrese el titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el genero (Accion, Aventura o Fantasia):");
        String generoInput = scanner.nextLine().toUpperCase();
        Genero generoNuevo;
        try{
            generoNuevo= Genero.valueOf(generoInput);
        } catch (IllegalArgumentException e){
            System.out.println("Genero " +generoInput+ " no encontrado! ");
            return null;
        }
        System.out.println("Ingrese el numero de version: ");
        while (!scanner.hasNextDouble()){
            System.out.println("Numero de version no valido! ");
            scanner.nextLine();
        }
        double numeroVersion = scanner.nextDouble();
        return new JuegoImpl(creador,titulo,generoNuevo,numeroVersion);
    }

    @Override
    public ExpancionImpl crearExpancion() {
        // String creador, String titulo, Genero genero
        // LocalDateTime fechaLanzamiento - utilizar la fecha actual
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de creador: ");
        String creador = scanner.nextLine();

        System.out.println("Ingrese el titulo: ");
        String titulo = scanner.nextLine();

        Genero generoNuevo;
        System.out.println("Ingrese el genero (Accion, Aventura o Fantasia):");
        String generoInput = scanner.nextLine().toUpperCase();
        try{
            generoNuevo= Genero.valueOf(generoInput);
        } catch (IllegalArgumentException e){
            System.out.println("El genero "+generoInput+" no encontrado!");
            return null;
        }
        return new ExpancionImpl(creador,titulo,generoNuevo,LocalDateTime.now());
    }
}
