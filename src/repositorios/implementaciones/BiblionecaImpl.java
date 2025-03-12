package repositorios.implementaciones;

import excepciones.IdentificadorDuplicadoException;
import excepciones.IdentificadorNoEncontrado;
import modelo.Media;
import modelo.enumeraciones.Genero;
import repositorios.interfaces.IBiblioteca;

import javax.swing.*;
import java.util.*;

public class BiblionecaImpl<T extends Media> implements IBiblioteca<T> {
    private Map<String, T>  colleccion;

    public BiblionecaImpl (){
        this.colleccion = new HashMap<>();
    }

    @Override
    public void agregar(T item) throws IdentificadorDuplicadoException {
        if (colleccion.containsKey(String.valueOf(item.getId()))) {
            throw new IdentificadorDuplicadoException("El identificador " + item.getId() + " ya está en uso.");
        }
        colleccion.put(String.valueOf(item.getId()), item);
    }

    @Override
    public void eliminar(String id) throws IdentificadorNoEncontrado {
        if(!colleccion.containsKey(id)){
            throw new IdentificadorNoEncontrado("Item con "+ id + " no encontrado! ");
        }
        colleccion.remove(id);
    }

    @Override
    public void mostrar() {
        List<T> colleccionOrdenada = new ArrayList<>(colleccion.values());
        Collections.sort(colleccionOrdenada);
        for(T i: colleccionOrdenada){
            System.out.println(i);
        }
    }

    @Override
    public List<T> filtrar (Genero genero){
        List<T> listaFiltrada = new ArrayList<>(colleccion.values());
        for(T item: colleccion.values()){
            if(Objects.equals(item.getGenero(),genero)){
                listaFiltrada.add(item);
            }
        }
        return listaFiltrada;
    }

    @Override
    public void modificar (String id, String atributoNuevo){
        Scanner scanner = new Scanner(System.in);
        T item = colleccion.get(id);
        if(item==null){
            throw new IdentificadorNoEncontrado("Error, el item con id = "+id+" no encontrado!" );
        }
        modificarMenu();
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                item.setTitulo(atributoNuevo);
                System.out.println("Titulo actualizado!");
                break;
            case "2":
                item.setCreador(atributoNuevo);
                System.out.println("Creador actualizado!");
                break;
            case "3":
                try {
                    Genero nuevoGenero = Genero.valueOf(atributoNuevo.toUpperCase());
                    item.setGenero(nuevoGenero);
                    System.out.println("Genero actualizado!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: Genero no encontrado!");
                }
                break;
            case "0":
                System.out.println("Saliendo del menú de edición.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void modificarMenu (){
        System.out.println("Selecciona qué quieres modificar:");
        System.out.println("1 - Título");
        System.out.println("2 - Creador");
        System.out.println("3 - Género");
        System.out.println("0 - Salir");
    }

}
