package co.edu.unicauca.parqueadero.domain;

/**
 *
 * @author User
 */
public class Ticket {

    private AutoEnum tipoVehiculo;
    private int minutos;

    public AutoEnum getVehiculo() {
        return tipoVehiculo;
    }

    public int getMinutos() {
        return minutos;
    }

    public Ticket(AutoEnum vehiculo, int minutos) {
        tipoVehiculo = vehiculo;
        this.minutos = minutos;
    }

}
