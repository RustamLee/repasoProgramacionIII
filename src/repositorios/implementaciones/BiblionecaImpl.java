package repositorios.implementaciones;

import excepciones.IdDuplicadoException;
import excepciones.IdNoEncontradoException;
import modelo.InputHelper;
import modelo.Media;
import modelo.enumeraciones.Genero;
import repositorios.interfaces.IBiblioteca;

import java.util.*;

public class BiblionecaImpl<T extends Media> implements IBiblioteca<T> {
    private Map<String, T>  colleccion;

    public BiblionecaImpl (){
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
    public void eliminar() throws IdNoEncontradoException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un id de juego o expancion para eliminar:");
        String idEliminar = scanner.nextLine();
        if(!colleccion.containsKey(idEliminar)){
            throw new IdNoEncontradoException("Item con "+ idEliminar + " no encontrado! ");
        }
        colleccion.remove(idEliminar);
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
    public List<T> filtrar (Scanner sc){
        List<T> listaFiltrada = new ArrayList<>();
        System.out.println("Ingrese el genero para filtrar (ACCION /AVENTURA /FANTASIA): ");
        String generoInput = sc.nextLine().toUpperCase();
        Genero genero;
        try {
            genero = Genero.valueOf(generoInput);
            System.out.println("Genero actualizado!");
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
                String titulo = InputHelper.inputParamento("titulo");
                item.setTitulo(titulo);
                System.out.println("Titulo actualizado!");
                break;
            case "2":
                String creador = InputHelper.inputParamento("creador");
                item.setCreador(creador);
                System.out.println("Creador actualizado!");
                break;
            case "3":
                try {
                    String generoInput = InputHelper.inputParamento("genero");
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
