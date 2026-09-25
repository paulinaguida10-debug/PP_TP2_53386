package modelo.certificacion;
import modelo.Estudiante;

public interface  Certificable {
    String ENTIDAD_EMISORA = "UTN frm";

    String generarCertificado (Estudiante  estudiante);

}
