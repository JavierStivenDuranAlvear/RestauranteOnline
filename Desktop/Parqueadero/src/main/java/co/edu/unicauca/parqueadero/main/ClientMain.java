package co.edu.unicauca.parqueadero.main;

import co.edu.unicauca.parqueadero.domain.*;
import co.edu.unicauca.parqueadero.domain.access.Factory;
import co.edu.unicauca.parqueadero.domain.access.IIngresoRepository;
import co.edu.unicauca.parqueadero.service.Service;

public class ClientMain {

    public static void main(String[] args) {
        // Le decimos a la fábrica que nos de el repositorio por defecto
        IIngresoRepository repository = Factory.getInstance().getRepository("default");
        Service service = new Service(repository);

        Ingreso newIngreso = new Ingreso(1,AutoEnum.CARRO,70);
    
        service.saveIngreso(newIngreso);

        newIngreso = new Ingreso(2,AutoEnum.CAMION,1770);
        service.saveIngreso(newIngreso);
        
        newIngreso = new Ingreso(3,AutoEnum.MOTO,10);
        service.saveIngreso(newIngreso);
        
        for (Ingreso p : service.listIngresos()) {
            System.out.println(p);
        }

    }

}