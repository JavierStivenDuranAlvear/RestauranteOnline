import java.text.ParseException;
import org.junit.Test;
import co.edu.unicauca.parqueadero.domain.*;
import static org.junit.Assert.*;
public class TestTarifaMoto {
    Parqueadero parqueadero = new Parqueadero();
    @Test
    public void testMotoRedondeo() throws ParseException {
        System.out.println("Moto Con redondeo");
        Ticket ticket = new Ticket(AutoEnum.MOTO,80); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(1200, precio);
        }

    @Test
    public void testCarroMenosTiempo() throws ParseException {
        System.out.println("Moto menos de 60 minutos");
        Ticket ticket = new Ticket(AutoEnum.MOTO,10); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(1000, precio);
        }
    public void testCarroNoRedondeo() throws ParseException {
        System.out.println("Moto sin redondeo");
        Ticket ticket = new Ticket(AutoEnum.MOTO,120); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(1500, precio);
        }
    }
