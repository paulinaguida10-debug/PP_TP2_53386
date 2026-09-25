package modelo;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import modelo.actividades.*;
import java.io.*;

public class EventoUniversitario implements Serializable {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private Sala sala;
    private List<Actividad> actividades = new ArrayList<>();



    private static int cantidadEventos;

    public EventoUniversitario (String id1, String titulo1, double costoBase1, boolean gratuito1){
        this.titulo = titulo1;
        this.costoBase = costoBase1;
        this.gratuito = gratuito1;
        this.id = id1;
        cantidadEventos++;
    }
    public EventoUniversitario (EventoUniversitario otro){
        id = otro.id;
        titulo = otro.titulo;
        costoBase = otro.costoBase;
        gratuito = otro.gratuito;
        cantidadEventos++;
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }
    public void mostrarDatos (){
        System.out.println("ID:"+id);
        System.out.println("Titulo:"+titulo);
        System.out.println("Costo base:"+ costoBase);
        System.out.println("¿Es gratuito?"+gratuito);
        System.out.println("Cantidad de eventos:"+cantidadEventos);
        for (Actividad a : actividades){
            a.mostrarIdentificacion();
            a.mostrarInscripciones();
        }
    }
    public double calcularCostoEstimado (){
        if (gratuito == true){
            return 0;
        } else {
            double totalMateriales = 0;
            for (Actividad a : actividades) {
                totalMateriales += a.calcularCostoMateriales();
            }
            return (costoBase + totalMateriales) * 1.21;
        }
    }
    public void asignarSala (Sala sala1){
        this.sala = sala1;

    }
    public Actividad crearActividad (int id, String titulo,int nivel, int cupo, String tipo, String disertante, boolean requiereNotebook){
        Actividad nuevaActividad;
        if (tipo.equals("Charla")){
            nuevaActividad = new Charla(id,titulo, cupo, disertante);

        }else if (tipo.equals("Taller")){
            nuevaActividad = new Taller(id, titulo, cupo, requiereNotebook);

        } else if (tipo.equals("Curso")) {
            nuevaActividad = new Curso( nivel, id, titulo,  cupo);

        } else {
            nuevaActividad = null;
        }

        actividades.add(nuevaActividad);
        System.out.println("ACTIVIDAD: ID: " + id + " Titulo: "+ titulo + " Cupo: " + cupo);
        return nuevaActividad;
    }
    public boolean persistirEvento(){
        String archivo = "evento_"+id+".dat";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream (archivo))){
            out.writeObject(this);
            System.out.println("archivo guardado"+archivo);
            return true;
        }catch (NotSerializableException e) {
            System.out.println("Error: hay una clase que no es serializable: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Error: no se pudo crear el archivo " + archivo);
        } catch (IOException e) {
            System.out.println("Error al guardar el evento: " + e.getMessage());
        }
        return false;
    }
    public EventoUniversitario recuperarEvento (String id){
        String archivo = "evento_"+id+".dat";
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))){
            EventoUniversitario obj = (EventoUniversitario) in.readObject();
            System.out.println("Recuperado"+archivo);
            return obj;
        }catch (FileNotFoundException e){
            System.out.println("No existe"+archivo);
        }catch (IOException e){
            System.out.println("Error al leer"+ e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("Clase no encontrada"+ e.getMessage());
        }
        return null;
    }
    public double calcularCostoMateriales(List<? extends Actividad> actividades){
        double total = 0;
        for (Actividad a : actividades) {
            total += a.calcularCostoMateriales();
        }
        return total;
    }
    public <T extends Actividad> List<T> filtrarActividadesPorTipo(Class<T> tipo) {
        List<T> resultado = new ArrayList<>();
        for (Actividad a : actividades) {
            if (tipo.isInstance(a)) {
                resultado.add(tipo.cast(a));
            }
        }
        return resultado;
    }

}



