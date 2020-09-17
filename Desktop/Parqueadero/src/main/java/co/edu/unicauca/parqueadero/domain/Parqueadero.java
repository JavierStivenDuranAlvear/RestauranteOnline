/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.parqueadero.domain;

import co.edu.unicauca.parqueadero.domain.access.Factory;

/**
 *
 * @author User
 */
public class Parqueadero {

    /**
     * Calcular costo de entrega
     *
     * @param order orden sobre la cual se calcula el costo de entrega
     * @return costo de entrega
     */
    public int calcularTarifa(Ticket ticket) {

        if (ticket == null) {
            return -1;
        }
        // La fábrica devuelve una instancia de la jerarquia IDelivery  
        CalcularTarifa tarifa = Factory.getInstance().getVehiculo(ticket.getVehiculo());
        int result = tarifa.CalcularTarifa(ticket.getMinutos());
        return result;

    }
}
