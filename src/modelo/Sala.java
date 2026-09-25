package modelo;
import java.io.Serializable;

public class Sala implements Serializable {
    private int id;
    private String nombre;
    public Sala (int id1, String nombre1){
        this.id = id1;
        this.nombre = nombre1;
    }
}
