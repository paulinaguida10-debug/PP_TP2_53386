package modelo.actividades;

import exepciones.CupoExcedidoException;
import modelo.Estudiante;
import modelo.Inscripcion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public abstract class Actividad implements Serializable{
    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int CUPO_MINIMO = 5;
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Actividad (int id1, String titulo1, int cupoMaximo1){
        this.id = id1;
        this.titulo = titulo1;
        this.cupoMaximo = cupoMaximo1;

    }
    public Inscripcion Inscribir(Estudiante estudiante) throws CupoExcedidoException {
        if (inscripciones.size()>= cupoMaximo) {
            throw new CupoExcedidoException("No hay mas lugar en" + titulo);
        }

        Inscripcion nuevaInscripcion = new Inscripcion(LocalDate.now(), "activa", estudiante);
        inscripciones.add(nuevaInscripcion);
        return nuevaInscripcion;
    }
    public void mostrarInscripciones (){
        for (Inscripcion i : inscripciones){
            System.out.println("modelo.Estudiante: " + i.getEstudiante().getNombre()+ "Fecha: "+ i.getFecha() + "Estado: "+ i.getEstado() );
        }
    }
    public final void mostrarIdentificacion (){
        System.out.println("ID: "+ id);
        System.out.println("Titulo: " + titulo );
        System.out.println("Tipo"+ getTipo());
    }
    public abstract String getTipo ();
    public abstract double calcularCostoMateriales();

}
