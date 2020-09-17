import java.text.ParseException;
import org.junit.Test;
import co.edu.unicauca.parqueadero.domain.*;
import static org.junit.Assert.*;
public class TestTarifaCamion {
    
    Parqueadero parqueadero = new Parqueadero();
    @Test
    public void testCamionRedondeo() throws ParseException {
        System.out.println("Camion con redondeo");
        Ticket ticket = new Ticket(AutoEnum.CAMION,1600); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(16700, precio);
        }

    @Test
    public void testCamionUnDia() throws ParseException {
        System.out.println("Camion un día");
        Ticket ticket = new Ticket(AutoEnum.CAMION,1000); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(15000, precio);
        }
    @Test
    public void testCamionMedioDia() throws ParseException {
        System.out.println("Camion medio dia");
        Ticket ticket = new Ticket(AutoEnum.CAMION,120); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(10000, precio);
        }
    @Test
    public void testCamionSinRedondeo() throws ParseException {
        System.out.println("Camion sin redondeo");
        Ticket ticket = new Ticket(AutoEnum.CAMION,2640); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(27500, precio);
        }
    }
