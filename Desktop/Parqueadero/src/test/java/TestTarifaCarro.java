import java.text.ParseException;
import org.junit.Test;
import co.edu.unicauca.parqueadero.domain.*;
import static org.junit.Assert.*;
public class TestTarifaCarro {
    
    Parqueadero parqueadero = new Parqueadero();
    @Test
    public void testCarroRedondeo() throws ParseException {
        System.out.println("Carro Con redondeo");
        Ticket ticket = new Ticket(AutoEnum.CARRO,80); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(2400, precio);
        }

    @Test
    public void testCarroMenosTiempo() throws ParseException {
        System.out.println("Carro menos de 60 minutos");
        Ticket ticket = new Ticket(AutoEnum.CARRO,10); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(2000, precio);
        }
    
    @Test
    public void testCarroNoRedondeo() throws ParseException {
        System.out.println("Carro sin redondeo");
        Ticket ticket = new Ticket(AutoEnum.CARRO,120); 
        int precio = parqueadero.calcularTarifa(ticket);
        assertEquals(3000, precio);
        }
    }
    
    
