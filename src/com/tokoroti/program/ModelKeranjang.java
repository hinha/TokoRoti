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
public class ModelKeranjang {
    KoneksiDB kon = new KoneksiDB();
    private String namaPemesan;
    private int jumPesanan;
    private int total;
    private String ket;
    private int idProduk;
    private int idPelanggan;

    public ModelKeranjang() {
    }

    public ModelKeranjang(String namaPemesan, int jumPesanan, String ket, int idProduk, int idPelanggan, int total) {
        this.namaPemesan = namaPemesan;
        this.jumPesanan = jumPesanan;
        this.ket = ket;
        this.total = total;
        this.idProduk = idProduk;
        this.idPelanggan = idPelanggan;
    }


    public String getNamaPemesan() {
        return namaPemesan;
    }

    public int getJumPesanan() {
        return jumPesanan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public void setJumPesanan(int jumPesanan) {
        this.jumPesanan = jumPesanan;
    }

    public int getTotal() {
        return total;
    }

    public String getKet() {
        return ket;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }
    

    public void setTotal(int total) {
        this.total = total;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    
    public boolean insertKeranjang() {
        try {
            String sql = "INSERT INTO pemesanan (nama_pemesanan, jumlah_pemesanan, id_produk, id_pelanggan, total, "
                    + "tgl_pesan, keterangan) "
                    + "VALUES ('" + getNamaPemesan()+ "', ' " + getJumPesanan()+ " ', ' "+ getIdProduk()+" ', ' "
                    + getIdPelanggan()+" ', ' "+ getTotal()*getJumPesanan()+" ', CURRENT_TIMESTAMP, ' "+ getKet()+" ')";
            
            
            kon.stat.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelProduk.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteKeranjang(int id) {
         int hapus = JOptionPane.showConfirmDialog(null, "Yakin Hapus Data ?" ,"Hapus", 
                JOptionPane.YES_NO_OPTION);
        
        if(hapus==JOptionPane.YES_OPTION){
            try {
                String sql = "DELETE FROM pemesanan WHERE id_pemesanan = '"+id+ "'";
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
