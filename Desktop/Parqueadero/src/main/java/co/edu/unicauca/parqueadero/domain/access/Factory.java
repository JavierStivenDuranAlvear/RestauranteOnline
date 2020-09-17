package co.edu.unicauca.parqueadero.domain.access;

import co.edu.unicauca.parqueadero.domain.*;
import java.util.EnumMap;
import java.util.Map;

/**
 * Fábrica que utiliza el patrón de diseño Singleton
 *
 */
public class Factory {

    private Map<AutoEnum, CalcularTarifa> deliveryDictionary;

    // Singleton
    private static Factory instance;

    private Factory() {
        deliveryDictionary = new EnumMap<>(AutoEnum.class);
        deliveryDictionary.put(AutoEnum.CAMION, new TarifaCamion());
        deliveryDictionary.put(AutoEnum.CARRO, new TarifaCarro());
        deliveryDictionary.put(AutoEnum.MOTO, new TarifaMoto());
        // Si se requie otro vehículo, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }

    /**
     * Devuelve la instancia de la clase
     *
     * @return instancia unica de la la fábrica
     */
    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public CalcularTarifa getVehiculo(AutoEnum vehiculo) {

        CalcularTarifa result = null;

        if (deliveryDictionary.containsKey(vehiculo)) {
            result = deliveryDictionary.get(vehiculo);
        }
        return result;
    }

    public IIngresoRepository getRepository(String type) {

        IIngresoRepository result = null;

        switch (type) {
            case "default":
                result = new IngresoRepository();
                break;
        }
        return result;
    }
}
