package com.mycompany.exampleserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.access.RepositoryArrays;
import com.mycompany.access.Persona;
import com.mycompany.access.RepositorySqlite;

import static java.awt.Frame.NORMAL;

public class Servidor {
    //private RepositorySqlite Sqlite;
 
    public static void main(String[] args) {
        //Sqlite = new RepositorySqlite();
        ServerSocket servidor = null;
        Socket sc = null;
        boolean escuchar = false;
        DataInputStream idPersona;
        DataInputStream nombrePersona;
        DataInputStream telefonoPersona;

        DataOutputStream out;
        final int PUERTO = 2000;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor Iniciado");

            IServer ins = new IServer();
            ins.setExtendedState(NORMAL);
            ins.setVisible(true);

            while (escuchar == false) {
                sc = servidor.accept();

                out = new DataOutputStream(sc.getOutputStream());

                idPersona = new DataInputStream(sc.getInputStream());
                nombrePersona = new DataInputStream(sc.getInputStream());
                telefonoPersona = new DataInputStream(sc.getInputStream());

                String varIdPersona = idPersona.readUTF();
                String varNombrePersona = nombrePersona.readUTF();
                String varTelefonoPersona = telefonoPersona.readUTF();

                System.out.println(varIdPersona);
                System.out.println(varNombrePersona);
                System.out.println(varTelefonoPersona);

                Persona persona = new Persona(varIdPersona, varNombrePersona, varTelefonoPersona);

                RepositorySqlite reSq = new RepositorySqlite();

                reSq.createPersona(persona);

                RepositoryArrays Repository = new RepositoryArrays();
               
                

                if (Repository.encontrarPersona(varIdPersona)) {
                    ins.InsertarUsuario(varIdPersona, varNombrePersona, varTelefonoPersona);
                    System.out.println("Se cargaron los datos");
                    out.writeUTF("1");
                    System.out.println("El usuario es un administrador, Bienvenido");

                } else {
                    out.writeUTF("2");
                }

                //else{
                // Repository.createPersona(persona);
                // System.out.println("El usuario no es un administrador, Lo sentimos");
                // }
                sc.close();

                //escuchar = true;
                //System.out.println("Cliente Desconectado");
                //System.out.println(persona.getMobile());
                //System.out.println(persona.getName());
                //System.out.println(persona);
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        //crear("98000001","juanito","154555");
    }

}
