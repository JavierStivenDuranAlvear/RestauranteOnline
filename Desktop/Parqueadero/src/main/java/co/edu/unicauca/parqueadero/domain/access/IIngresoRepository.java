package co.edu.unicauca.parqueadero.domain.access;

import co.edu.unicauca.parqueadero.domain.Ingreso;
import java.util.List;

public interface IIngresoRepository {
    boolean save(Ingreso newProduct);

    List<Ingreso> list();
}
