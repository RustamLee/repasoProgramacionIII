package repositorios.implementaciones;

import excepciones.IdDuplicadoException;
import excepciones.IdNoEncontradoException;
import modelo.InputHelper;
import modelo.Media;
import modelo.enumeraciones.Genero;
import repositorios.interfaces.BibliotecaBase;

import java.util.*;

public class BibliotecaImpl<T extends Media> implements BibliotecaBase<T> {
    private Map<String, T>  colleccion;

    public BibliotecaImpl(){
        this.colleccion = new HashMap<>();
    }



    @Override
    public void agregar(T item) throws IdDuplicadoException {
        if (colleccion.containsKey(String.valueOf(item.getId()))) {
            throw new IdDuplicadoException("El identificador " + item.getId() + " ya está en uso.");
        }
        colleccion.put(String.valueOf(item.getId()), item);
    }

    @Override
    public void eliminar(Scanner scanner) throws IdNoEncontradoException {
        System.out.println("Ingrese un id de juego o expancion para eliminar:");
        String idEliminar = scanner.nextLine();
        if(!colleccion.containsKey(idEliminar)){
            throw new IdNoEncontradoException("Item con id= "+ idEliminar + " no encontrado! ");
        } else{
            System.out.println("Elemento esta eliminado! ");
            colleccion.remove(idEliminar);
        }
    }

    @Override
    public void mostrar() {
        List<T> colleccionOrdenada = new ArrayList<>(colleccion.values());
        Collections.sort(colleccionOrdenada);
        if (!colleccionOrdenada.isEmpty()){
            for(T i: colleccionOrdenada){
                System.out.println(i);
            }
        } else {System.out.println("Colleccion esta vacia!");}
    }

    @Override
    public List<T> filtrar (Scanner sc){
        List<T> listaFiltrada = new ArrayList<>();
        System.out.println("Ingrese el genero para filtrar (ACCION /AVENTURA /FANTASIA): ");
        String generoInput = sc.nextLine().toUpperCase();
        Genero genero;
        try {
            genero = Genero.valueOf(generoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Genero no encontrado!");
            return new ArrayList<>();
        }
        for(T item: colleccion.values()){
            if(Objects.equals(item.getGenero(),genero)){
                listaFiltrada.add(item);
            }
        }
        return listaFiltrada;
    }

    @Override
    public void modificar (Scanner scanner){
        System.out.println("Ingrese id de elemento para modificar");
        String id = scanner.nextLine();
        T item = colleccion.get(id);
        if(item==null){
            throw new IdNoEncontradoException("Error, el item con id = "+id+" no encontrado!" );
        }
        modificarMenu();
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                String titulo = InputHelper.input("titulo");
                item.setTitulo(titulo);
                System.out.println("Titulo actualizado!");
                break;
            case "2":
                String creador = InputHelper.input("creador");
                item.setCreador(creador);
                System.out.println("Creador actualizado!");
                break;
            case "3":
                try {
                    String generoInput = InputHelper.input("genero");
                    Genero nuevoGenero = Genero.valueOf(generoInput.toUpperCase());
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
