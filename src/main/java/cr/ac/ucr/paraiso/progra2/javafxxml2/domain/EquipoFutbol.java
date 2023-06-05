package cr.ac.ucr.paraiso.progra2.javafxxml2.domain;

public class EquipoFutbol {
    private String codEquipo;
    private String nombre;
    private int cantidadJugadoresInscritos;

    public EquipoFutbol() {

    }

    @Override
    public String toString() {
        return String.format("%s-%s", nombre, codEquipo);
    }

    public EquipoFutbol(String codEquipo,
                        String nombre, int cantidadJugadoresInscritos) {
        this.codEquipo = codEquipo;
        this.nombre = nombre;
        this.cantidadJugadoresInscritos = cantidadJugadoresInscritos;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadJugadoresInscritos() {
        return cantidadJugadoresInscritos;
    }

    public void setCantidadJugadoresInscritos(int cantidadJugadoresInscritos) {
        this.cantidadJugadoresInscritos = cantidadJugadoresInscritos;
    }

}
