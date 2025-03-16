package repositorios.implementaciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import excepciones.IdDuplicadoException;
import excepciones.IdNoEncontradoException;
import modelo.InputHelper;
import modelo.Media;
import modelo.enumeraciones.Genero;
import modelo.implementaciones.ExpancionImpl;
import modelo.implementaciones.JuegoImpl;
import repositorios.interfaces.BibliotecaBase;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BibliotecaImpl<T extends Media> implements BibliotecaBase<T> {
    private Map<String, T> colleccion;
    private Gson gson;

    public BibliotecaImpl(Class<T> claseT) {
        this.colleccion = new HashMap<>();
        RuntimeTypeAdapterFactory<Media> adapterFactory = RuntimeTypeAdapterFactory
                .of(Media.class, "type")
                .registerSubtype(JuegoImpl.class, "juego")
                .registerSubtype(ExpancionImpl.class, "expansion");

        this.gson = new GsonBuilder()
                .registerTypeAdapterFactory(adapterFactory)
                .create();
    }

    @Override
    public Map<String, T> getColleccion() {
        return colleccion;
    }

    // a Json
    public void quardarAJson(String nombreArchivo) {
        try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
            gson.toJson(colleccion, fileWriter);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // desde Json
    public void cargarDesdeJson(String nombreArchivo) {
        try (FileReader fileReader = new FileReader(nombreArchivo)) {
            Map<String, Media> datos = gson.fromJson(fileReader, new TypeToken<Map<String, Media>>() {}.getType());
            if (datos != null) {
                datos.forEach((id, media) -> colleccion.put(id, (T) media));
            }
            System.out.println("Colleccion cargado! ");
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
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
        if (!colleccion.containsKey(idEliminar)) {
            throw new IdNoEncontradoException("Item con id= " + idEliminar + " no encontrado!");
        } else {
            System.out.println("Elemento está eliminado!");
            colleccion.remove(idEliminar);
        }
    }

    @Override
    public void mostrar() {
        List<T> colleccionOrdenada = new ArrayList<>(colleccion.values());
        Collections.sort(colleccionOrdenada);
        if (!colleccionOrdenada.isEmpty()) {
            colleccionOrdenada.forEach(System.out::println);
        } else {
            System.out.println("Colección está vacía!");
        }
    }

    @Override
    public List<T> filtrar(Scanner sc) {
        List<T> listaFiltrada = new ArrayList<>();
        System.out.println("Ingrese el genero para filtrar (ACCION / AVENTURA / FANTASIA): ");
        String generoInput = sc.nextLine().toUpperCase();
        Genero genero;
        try {
            genero = Genero.valueOf(generoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Género no encontrado!");
            return listaFiltrada;
        }

        for (T item : colleccion.values()) {
            if (Objects.equals(item.getGenero(), genero)) {
                listaFiltrada.add(item);
            }
        }
        return listaFiltrada;
    }

    @Override
    public void modificar(Scanner scanner) {
        System.out.println("Ingrese id de elemento para modificar");
        String id = scanner.nextLine();
        T item = colleccion.get(id);
        if (item == null) {
            throw new IdNoEncontradoException("Error, el item con id = " + id + " no encontrado!");
        }
        modificarMenu();
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                String titulo = InputHelper.input("titulo");
                item.setTitulo(titulo);
                System.out.println("Título actualizado!");
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
                    System.out.println("Género actualizado!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: Género no encontrado!");
                }
                break;
            case "0":
                System.out.println("Saliendo del menú de edición.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void modificarMenu() {
        System.out.println("Selecciona qué quieres modificar:");
        System.out.println("1 - Título");
        System.out.println("2 - Creador");
        System.out.println("3 - Género");
        System.out.println("0 - Salir");
    }
}
