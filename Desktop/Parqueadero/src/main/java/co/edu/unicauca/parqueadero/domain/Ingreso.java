package co.edu.unicauca.parqueadero.domain;

public class Ingreso {

    private int ingresoId;

    private AutoEnum tipo;

    private int tiempo;

    public Ingreso(int ingresoId, AutoEnum tipo, int tiempo) {
        this.ingresoId = ingresoId;
        this.tipo = tipo;
        this.tiempo = tiempo;
    }

    public Ingreso() {
    }

    public int getIngresoId() {
        return ingresoId;
    }

    public void setIngresoId(int ingresoId) {
        this.ingresoId = ingresoId;
    }

    public AutoEnum getTipo() {
        return tipo;
    }

    public void setTipo(AutoEnum tipo) {
        this.tipo = tipo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Ingreso: " + ingresoId + ", tipo de vehículo: " + 
                tipo.toString().toLowerCase()+ ", tiempo =  " + tiempo + " minutos";
    }
}
