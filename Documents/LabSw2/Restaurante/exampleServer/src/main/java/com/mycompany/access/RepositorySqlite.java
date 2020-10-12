/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio de Clientes en MySWL
 *
 * @author Libardo, Julio
 */
public class RepositorySqlite implements IRepository {

    /**
     * Conección con Mysql
     */
    private Connection conn;

    public RepositorySqlite() {
        initDatabase();
    }
    /**
     * Busca en la bd un customer
     * @param id cedula
     * @return objeto customer, null si no lo encuentra
     */
    @Override
    public Persona findPersona(String id) {
        Persona persona = null;

        this.connect();
        try {
            String sql = "SELECT * from persona where id=? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                persona = new Persona();
                persona.setId(res.getString("id"));
                persona.setName(res.getString("nombre"));
                persona.setMobile(res.getString("mobile"));

            }
            pstmt.close();
            this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RepositorySqlite.class.getName()).log(Level.SEVERE, "Error al consultar Customer de la base de datos", ex);
        }
        return persona;
    }

    @Override
    public void createPersona(Persona persona) {
        
        try {
            initDatabase();
            this.connect();
            
            String sql = "INSERT INTO persona( id, nombre, mobile )" +
                    " VALUES (?,?,?)";
            
            System.out.println("Hola................");
             
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            
            pstmt.setString(1, persona.getId());
            pstmt.setString(2, persona.getName());
            pstmt.setString(3, persona.getMobile());
            
            System.out.println(sql);
            
            pstmt.executeUpdate();
            //pstmt.close();
            //this.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(RepositorySqlite.class.getName()).log(Level.SEVERE, "Error al insertar el registro", ex);
        }
        //return persona.getId();

    }

    public int connect() {
        // SQLite connection string
        //String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);
            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS persona (\n"
                + "	id varchar2 PRIMARY KEY,\n"
                + "	nombre varchar2, \n"
                + "	mobile varchar2 \n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Cierra la conexion con la base de datos
     *
     */
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RepositorySqlite.class.getName()).log(Level.FINER, "Error al cerrar Connection", ex);
        }
    }
    
    public void ImprimirPersona(){
        System.out.println("Que chimbada es esta");
    }
    
    public boolean encontrarPersona(String id){
        System.out.println("Que chimbada es esta");
        return true;
    }
}
