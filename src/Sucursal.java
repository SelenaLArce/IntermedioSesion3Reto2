import java.util.List;

public class Sucursal {
    private String nombre;
    private List<Encuesta> encuestas; // Asumiendo que Encuesta está en el mismo paquete o importada

    public Sucursal(String nombre, List<Encuesta> encuestas) {
        this.nombre = nombre;
        this.encuestas = encuestas;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Encuesta> getEncuestas() {
        return encuestas;
    }
}