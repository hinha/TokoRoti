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
public class ModelProduk {
    KoneksiDB kon = new KoneksiDB();
    private String namaProduk;
    private String jenis;
    private int harga;
    private int stok;

    public ModelProduk() {
    }
    
    public ModelProduk(String namaProduk, String jenis, int harga, int stok) {
        this.namaProduk = namaProduk;
        this.jenis = jenis;
        this.harga = harga;
        this.stok = stok;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public String getJenis() {
        return jenis;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
    
    public boolean insertProduk() {
        try {
            String sql = "INSERT INTO produk (nama_produk, jenis, harga, stok) "
                    + "VALUES ('" + getNamaProduk() + "', ' " + getJenis() + " ', ' "+ getHarga() +" ', ' "+ getStok() +" ')";
            
            kon.stat.executeUpdate(sql);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelProduk.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean updatePelanggan(int id) {
        try {
            String sql = "UPDATE produk SET nama_produk='"+ getNamaProduk() +"', jenis='"+ getJenis()
                +"', harga='"+ getHarga()+"', stok='"+ getStok() +"' WHERE id_produk='" + id + "'";
            kon.stat.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    public boolean editPelanggan(int id) {
        
        try {
            String sql = "SELECT nama_produk, jenis, harga, stok FROM produk WHERE id_produk=" + id;
            kon.res = kon.stat.executeQuery(sql);
            if (kon.res.next()) {
                setNamaProduk(kon.res.getString(1));
                setJenis(kon.res.getString(2));
                setHarga(kon.res.getInt(3));
                setStok(kon.res.getInt(4));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
 }
