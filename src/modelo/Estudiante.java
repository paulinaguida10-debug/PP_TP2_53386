package modelo;
import java.io.Serializable;

public class Estudiante implements Serializable{
    private String legajo;
    private String nombre;

    public Estudiante(String legajo1, String nombre1){
        this.legajo = legajo1;
        this.nombre = nombre1;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }
}
