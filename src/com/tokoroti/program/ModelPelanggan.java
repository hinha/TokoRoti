/*
 * Github: martinusdawan
 * Email: martinuz.dawan9@gmail.com
 *
 * Copyright 2018 hinha.
 */
package com.tokoroti.program;

import com.tokoroti.view.Keranjang;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hinha
 */
public class ModelPelanggan extends ModelAdmin{

    public ModelPelanggan() {
    }
    

    public ModelPelanggan(String nama, String alamat, String gender, String email, String noTelp) {
        super(nama, alamat, gender, email, noTelp);
    }
    
    public boolean insertPelanggan() {
        try {
            String sql = "INSERT INTO pelanggan (nama, alamat, gender, email, no_hp)"
                    + "VALUES ('" + getNama()+ "', ' " + getAlamat()+ " ', ' "+ getGender()+" ', ' "
                    + getEmail()+"' , '"+ getNoTelp()+" ')";
            
            System.out.println("Oke" + getNama());
            kon.stat.executeUpdate(sql);
            
            System.out.println("Oke2");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelProduk.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updatePelanggan(int id) {
        try {
            String sql = "UPDATE pelanggan SET nama='"+ getNama() +"', alamat='"+ getAlamat() 
                +"', gender='"+ getGender() +"', email='"+ getEmail() +"', no_hp='"+ getNoTelp() +"' WHERE id_pelanggan='" + id + "'";
            kon.stat.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean deleteKeranjang(int id) {
         int hapus = JOptionPane.showConfirmDialog(null, "Yakin Hapus Data ?" ,"Hapus", 
                JOptionPane.YES_NO_OPTION);
        
        if(hapus==JOptionPane.YES_OPTION){
            try {
                String sql = "DELETE FROM pelanggan WHERE id_pelanggan = '"+id+ "'";
                kon.stat.executeUpdate(sql);
                return true;

            } catch (SQLException ex) {
                Logger.getLogger(Keranjang.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return false;
    }
    
}
