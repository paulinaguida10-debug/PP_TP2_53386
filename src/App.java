import modelo.Inscripcion;
import modelo.certificacion.Certificable;
import modelo.Estudiante;
import modelo.EventoUniversitario;
import modelo.Sala;
import modelo.actividades.Actividad;
import exepciones.CupoExcedidoException;
import java.util.List;
import modelo.actividades.*;

public class App {
    public static void main( String[] args){
        EventoUniversitario evento1 = new EventoUniversitario("1131", "Consulta de programación", 15000, false);
        EventoUniversitario evento2 = new EventoUniversitario("122", "Consulta de Java", 0, true);
        EventoUniversitario copia1 = new EventoUniversitario(evento1);
        EventoUniversitario copia2 = new EventoUniversitario(evento2);
        evento1.mostrarDatos();
        evento2.mostrarDatos();
        copia1.mostrarDatos();
        copia2.mostrarDatos();
        System.out.println("Cantidad de eventos " + EventoUniversitario.getCantidadEventos());

        //incribrir estudiantes
        Estudiante e1 = new Estudiante("1111", "juan Perez");
        Estudiante e2 = new Estudiante("1222", "Ana Gomez");
        Estudiante e3 = new Estudiante("133", "Maria Garcia");
        //crear un evento
        EventoUniversitario evento3 = new EventoUniversitario("133", "Consulta de matematica", 20000, false);
        //crear sala
        Sala sala1 = new Sala(10, "Aula LISUN");
        //asignar sala al evetno
        evento3.asignarSala(sala1);
        //crear atividad del mismo evento y mostrar datos se borraron pq se corrigio crearActividad.



            //Registrar 3 estudiantes
        Estudiante e11 = new Estudiante("11111", "Juan Gomez");
        Estudiante e12 = new Estudiante("21111", "Ana Perez");
        Estudiante e13 = new Estudiante("31111", "Maria Lopez");

        //Se crea un evento
        EventoUniversitario evento11 = new EventoUniversitario("111", "Clase de Paradigmas", 12000 , false);

        //Se crea una sala
        Sala sala11 = new Sala(1111, "Sala de programacion");

        //Se crea una actividad (modelo.actividades.Charla) para el evento
        Actividad act11 = evento11.crearActividad(1112, "Clases y objetos", 0, 10,"Charla", "Juan Lopez", false);

        //Se crea una actividad (modelo.actividades.Taller) para el evento
        Actividad act12 = evento11.crearActividad(1113, "Analizar un sistema", 0, 10, "Taller", "Marta Lopez", true);
        //se crea 1 actividad con tipo curso
        Actividad act22 = evento11.crearActividad(2222,"Programacion", 2, 10, "Curso", "Carlos Perez", false);


        try {
            //se inscriben dos estudiantes al curso
            act22.Inscribir(e11);
            act22.Inscribir(e12);
        }

        catch (CupoExcedidoException e) {
            System.out.println("Error de inscripción: " + e.getMessage());
        }finally {
            System.out.println("Fin del proceso de inscripción");
        }

        try {
            //se inscriben 2 estudiantes a la charla
            act11.Inscribir(e11);
            act11.Inscribir(e12);

            //Se inscriben 2 estudiantes al taller
            act12.Inscribir(e12);
            act12.Inscribir(e11);
            System.out.println("Inscripciones realizadas correctamente");
            evento11.persistirEvento();
            EventoUniversitario recuperado = evento11.recuperarEvento("111");
            recuperado.mostrarDatos();
        }
        catch (CupoExcedidoException e) {
            System.out.println("Error de inscripción: " + e.getMessage());
        } finally {
            System.out.println("Fin del proceso de inscripción");
        }
        // f y g. Emitir y mostrar certificados
        System.out.println("\n--- Certificados emitidos ---");

        // Charla
        if (act11.getTipo().equals("Taller") || act11.getTipo().equals("Curso")) {
            Certificable c = (Certificable) act11;
            System.out.println(c.generarCertificado(e11));
        } else {
            System.out.println("La charla no es certificable");
        }

        // Taller
        if (act12.getTipo().equals("Taller") || act12.getTipo().equals("Curso")) {
            Certificable c = (Certificable) act12;
            System.out.println(c.generarCertificado(e11));
            System.out.println(c.generarCertificado(e12));
        }

        // Curso
        if (act22.getTipo().equals("Taller") || act22.getTipo().equals("Curso")) {
            Certificable c = (Certificable) act22;
            System.out.println(c.generarCertificado(e11));
            System.out.println(c.generarCertificado(e12));
        }

        // h. Datos del evento
        evento11.mostrarDatos();
        //Caso fallido: taller con cupo 1
        Actividad act123 = evento11.crearActividad(1133, "Ingenieria", 0 , 1 ,"Taller", "Maria Perez", false);
        try {
            act123.Inscribir(e12);
            act123.Inscribir(e11);
        } catch (CupoExcedidoException e) {
            System.out.println("Error de inscripción: " + e.getMessage());
        } finally {
            System.out.println("Fin del proceso de inscripción");
        }
        List<Charla> charlas = evento11.filtrarActividadesPorTipo(Charla.class);
        List<Taller> talleres = evento11.filtrarActividadesPorTipo(Taller.class);
        List<Curso> cursos = evento11.filtrarActividadesPorTipo(Curso.class);


        System.out.println("Cantidad de charlas: " + charlas.size());
        System.out.println("cantidad de Talleres " + talleres.size());
        System.out.println("Cantidad de curso: " + cursos.size());

        System.out.println("Costo materiales charlas: " + evento11.calcularCostoMateriales(charlas));
        System.out.println("Costo materiales talleres: " + evento11.calcularCostoMateriales(talleres));
        System.out.println("Costo materiales cursos: " + evento11.calcularCostoMateriales(cursos));


    }










}
