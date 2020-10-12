/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.access.Persona;

public final class RepositoryArrays implements IRepository {


    public static List<Persona> personas;

    public RepositoryArrays() {
        if (personas == null){
            personas = new ArrayList();
        }
        
        if (personas.isEmpty()){
            inicializar();
        }
    }
    
    public void ImprimirPersona(){
        System.out.println("Estamos esperando...");
        for (int i=0 ; i < personas.size();i++) {
            System.out.println(personas.size());
            System.out.println(personas);
        }
    }
    public void inicializar() {
        personas.add(new Persona("98000001", "Andrea", "3145878752"));
        personas.add(new Persona("98000002", "Libardo", "3141257845"));
        personas.add(new Persona("98000003", "Carlos", "3141257846"));
        personas.add(new Persona("98000004", "Fernanda",  "3154562133"));
        personas.add(new Persona("98000005", "Manuel", "3154575845"));
        personas.add(new Persona("98000006", "Alejandro","3154575845"));
        personas.add(new Persona("98000007", "Cesar","3154575845"));
        personas.add(new Persona("98000008", "Julio","3154575845"));
        personas.add(new Persona("98000009", "Alberto","3154575845"));
        personas.add(new Persona("98000010", "Alexander","3154575845"));
    }

    /**
     * Busca u Customer en el arreglo
     *
     * @param id cedula del customer
     * @return objeto Customer
     */
    @Override
    public Persona findPersona(String id) {
        for (Persona persona : personas) {
            if (persona.getId().equals(id)) {
                return persona;
            }
        }
        return null;
    }
    
    @Override
    public boolean encontrarPersona(String id) {
        for (Persona persona : personas) {
            if (persona.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void createPersona(Persona persona) {
        personas.add(persona);
        //return persona.getId();
    }

}
