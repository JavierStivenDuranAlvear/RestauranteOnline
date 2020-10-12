
package com.mycompany.examplecliente;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Cliente {
    private String id;
    private String nombre;
    private String telefono;
    private String existe;
    
    public Cliente(String id,String nombre,String telefono){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        
        final String HOST = "127.0.0.1";
        final int PUERTO = 2000;
        DataInputStream in;
        DataOutputStream out;

        try{
           Socket sc = new Socket (HOST, PUERTO);
           in = new DataInputStream(sc.getInputStream());
           out = new DataOutputStream(sc.getOutputStream());
           
           String idPersona = (id);
           String nombrePersona = (nombre);
           String telefonoPersona = (telefono);
           
           
           out.writeUTF(idPersona);
           out.writeUTF(nombrePersona);
           out.writeUTF(telefonoPersona);
           
           
           existe = in.readUTF();
           
           //System.out.println(mensaje);
           
           sc.close();

        }catch(IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    public boolean getExiste(){
        int varExiste = Integer.parseInt(existe);
        if((varExiste) == 1){
            return true;
        }
      return false;
    }
    
}
