/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.parqueadero.domain;
/**
 *
 * @author User
 */
public class TarifaMoto extends CalcularTarifa {
      @Override
    public int CalcularTarifa(int minutos) {
         tarifa=1000;
        if (minutos>60){
            tarifa += (minutos-60)*(25/3);
            tarifa= redondear(tarifa);
         }    
        return tarifa;
    }   
}
        

