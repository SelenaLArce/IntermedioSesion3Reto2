import java.util.Arrays;
import java.util.List;

public class Main { // O el nombre que uses para tu clase principal
    public static void main(String[] args) {
        // Crear las sucursales con sus encuestas
        Sucursal sucursalCentro = new Sucursal("Centro", List.of(
                new Encuesta("Respuesta 1", "La atención estuvo bien", 5),
                new Encuesta("Respuesta 2", "El tiempo de espera fue largo", 3),
                new Encuesta("Respuesta 3", "El tiempo de espera fue largo para mí", 4),
                new Encuesta("Respuesta 4", "Excelente servicio", 5)
        ));

        Sucursal sucursalNorte = new Sucursal("Norte", List.of(
                new Encuesta("Respuesta 5", "La atención estuvo bien", 5),
                new Encuesta("Respuesta 6", "El papeleo fue mucho", 3)
        ));

        Sucursal sucursalSur = new Sucursal("Sur", List.of(
                new Encuesta("Respuesta 7", "La atención estuvo muy bien", 4),
                new Encuesta("Respuesta 8", "La atención fue buena, pero la limpieza puede mejorar", 2),
                new Encuesta("Respuesta 9", "Todo excelente!!", 5)
        ));

        // Lista de todas las sucursales
        List<Sucursal> sucursales = Arrays.asList(sucursalCentro, sucursalNorte, sucursalSur);

        // Procesar las encuestas
        sucursales.stream()
                .flatMap(sucursal -> sucursal.getEncuestas().stream() // Desanidar todas las encuestas
                        .filter(encuesta -> encuesta.getCalificacion() <= 3) // Filtrar por calificación <= 3
                        .flatMap(encuesta -> encuesta.getComentario().map(
                                        comentario -> String.format("Sucursal %s: Seguimiento a paciente con comentario: \"%s\"",
                                                sucursal.getNombre(), comentario)).stream()))
                .forEach(System.out::println); // Mostrar todos los mensajes en consola
    }
}