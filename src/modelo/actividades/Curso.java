package modelo.actividades;
import modelo.certificacion.Certificable;
import modelo.Estudiante;


public class Curso extends Actividad implements Certificable{
    private int nivel;

    public Curso (int nivel1, int id1, String titulo1, int cupoMaximo1){
        super(id1, titulo1, cupoMaximo1);
        this.nivel = nivel1;

    }
    @Override
    public String getTipo (){
        return "Curso";
    }
    public double calcularCostoMateriales (){
      return 0;
    }
    @Override
    public String generarCertificado (Estudiante estudiante){
        return "Certificado emitido por: " + ENTIDAD_EMISORA + "a" + estudiante.getNombre() + "por particiar en el curso";
    }

}
