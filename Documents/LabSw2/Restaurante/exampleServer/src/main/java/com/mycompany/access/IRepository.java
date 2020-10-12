/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access;

/**
 * Interface del respositorio de clientes
 * @author Libardo Pantoja
 */
import com.mycompany.access.Persona;

public interface IRepository {
    /**
     * Busca un Customer por su ceduka
     * @param id cedula del cliente
     * @return  objeto de tipo Persona
     */
    public Persona findPersona(String id);
    
    public void createPersona(Persona customer);
    
    public void ImprimirPersona();
    
    public boolean encontrarPersona(String id);
            
}
