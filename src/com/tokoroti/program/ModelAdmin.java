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
    private String nama;
    private String alamat;
    private String gender;
    private String email;
    private String noTelp;
    
    
    KoneksiDB kon = new KoneksiDB();
    
    public ModelAdmin() {
    }

    public ModelAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ModelAdmin(String nama, String alamat, String gender, String email, String noTelp) {
        this.nama = nama;
        this.alamat = alamat;
        this.gender = gender;
        this.email = email;
        this.noTelp = noTelp;
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

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getNoTelp() {
        return noTelp;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }
    
}
