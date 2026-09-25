package modelo;
import java.io.Serializable;

import java.time.LocalDate;

public class Inscripcion implements Serializable {
    private LocalDate fecha;
    private String estado;
    private Estudiante estudiante;

    public Inscripcion(LocalDate fecha1, String estado1, Estudiante estudiante1){
        this.fecha = fecha1;
        this.estado = estado1;
        this.estudiante = estudiante1;

    }

    public LocalDate getFecha() {
        return fecha;

    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }
}
