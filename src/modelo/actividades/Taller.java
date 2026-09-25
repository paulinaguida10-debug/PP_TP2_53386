package modelo.actividades;
import modelo.certificacion.Certificable;
import modelo.Estudiante;

public class Taller extends Actividad implements Certificable {
    private boolean requiereNotebook;

    public Taller ( int id1, String titulo1, int cupoMaximo1, boolean requiereNotebook1){
        super (id1, titulo1, cupoMaximo1);
        this.requiereNotebook = requiereNotebook1;
    }
    @Override
    public String getTipo (){
        return "Taller";
    }
    public double calcularCostoMateriales (){
        if (requiereNotebook == false){
            return 2000;}
        else {
        return 5000;
        }
    }
    @Override
    public String generarCertificado (Estudiante estudiante){
        return "Certificado emitido por: " + ENTIDAD_EMISORA + "a" + estudiante.getNombre() + "por particiar en el taller";
    }
}
