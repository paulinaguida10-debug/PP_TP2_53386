TP1 - Ejercicio 3

Hice la clase Actividad abstracta y creé dos tipos de actividad que heredan de ella: Charla y Taller. Cada una calcula su costo de materiales a su manera (las charlas son gratis y los talleres cuestan $5000 con notebook y $2000 sin notebook). El método mostrarIdentificacion() es final para que no se pueda cambiar en las subclases.

El costo del evento se calcula como (costo base + costo de las actividades) * 1.21. Si el evento es gratuito, el costo es 0.

TP2 - Ejercicio 1

Organicé las clases en packages (modelo, modelo.actividades y exepciones).

Creé la excepción CupoExcedidoException, que se lanza cuando se intenta inscribir a un estudiante en una actividad que ya está llena. En App la atrapo con try-catch-finally y muestro un mensaje.

También agregué la opción de guardar el evento en un archivo (persistirEvento()) y de leerlo después (recuperarEvento()), usando serialización. Los errores de archivo los manejo con un catch para cada caso.

En App hay un caso que sale bien (se inscribe, se guarda y se lee el evento) y un caso que falla a propósito (un taller con cupo 1 donde intento inscribir a dos personas).

TP2 - Ejercicio 2

Agregué la interfaz Certificable, que tienen las actividades que pueden dar certificado. La implementan Taller y Curso (una actividad nueva), pero no Charla, porque las charlas no dan certificado.

En App creo un curso, inscribo estudiantes y emito los certificados de los talleres y cursos. Para la charla se muestra que no es certificable.

TP2 - Ejercicio 3

Agregué dos métodos a EventoUniversitario:

filtrarActividadesPorTipo(...): devuelve solo las actividades de un tipo (por ejemplo, solo los talleres).
calcularCostoMateriales(...): suma el costo de materiales de una lista de actividades.

En App filtro las actividades por tipo, muestro cuántas hay de cada una y cuánto cuestan los materiales de cada tipo.
