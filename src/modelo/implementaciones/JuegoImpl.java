package modelo.implementaciones;

import modelo.Media;
import modelo.enumeraciones.Genero;
import modelo.interfaces.JuegoBase;

public class JuegoImpl extends Media implements JuegoBase {
    private double numeroVersion;
    public String type = "juego";
    public JuegoImpl(String creador, String titulo, Genero genero, double numeroVersion) {
        super(creador, titulo, genero);
        if(numeroVersion <=0){
            throw new IllegalArgumentException("El numero de vercion no puede ser nulo o negativo!");
        }
        this.numeroVersion = numeroVersion;
    }

    @Override
    public String toString() {
        return "Juego{" +
                super.toString() +
                "numeroVersion='" + numeroVersion + '\'' +
                '}';
    }


    @Override
    public double getVersion() {
        return numeroVersion;
    }

    @Override
    public void setVersion(double version) {
        this.numeroVersion = version;
    }
}
