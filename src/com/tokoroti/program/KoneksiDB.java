/*
 * Github: martinusdawan
 * Email: martinuz.dawan9@gmail.com
 *
 * Copyright 2018 hinha.
 */
package com.tokoroti.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hinha
 */
public class KoneksiDB {
    
    public Statement stat;
    public ResultSet res;
    public Connection con;
    public PreparedStatement pst;
    String dbname = "pbopraktik";
    String user = "root";
    String pass = "";
    String url = "jdbc:mysql://localhost:3306/" + dbname;
    
    public KoneksiDB() {
                
        if (con==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(
                   this.url, this.user, this.pass);                
                stat = con.createStatement();
                
            } catch (SQLException ea) {
                System.err.println(ea);
            } catch (ClassNotFoundException ex) {            
                Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
