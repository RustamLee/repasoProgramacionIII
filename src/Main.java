import modelo.Media;
import ui.Menu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.getBiblioteca().cargarDesdeJson("colleccion.json");
        System.out.println("El contenido de colleccion cargado: ");
        for (Media t : menu.getBiblioteca().getColleccion().values()) {
            System.out.println(t);
        }
        menu.mainMenu();
        menu.getBiblioteca().quardarAJson("colleccion.json");
    }
}