/*
 * Github: martinusdawan
 * Email: martinuz.dawan9@gmail.com
 *
 * Copyright 2018 hinha.
 */
package com.tokoroti.program;

import com.tokoroti.program.KoneksiDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author hinha
 */
public class ModelAdmin {
    private String username;
    private String password;
    
    KoneksiDB kon = new KoneksiDB();
    
    public ModelAdmin() {
    }

    public ModelAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    
    
    public boolean validasiLogin(String username, String password) {
        try {
            String sql = "SELECT * FROM admin WHERE "
                + "username= '" + username + "' and " + " password='" + password + "'";
            kon.res = kon.stat.executeQuery(sql);
            if (kon.res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelAdmin.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
