/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tokoroti.view;


import com.tokoroti.program.KoneksiDB;
import com.tokoroti.program.ModelKeranjang;
import com.tokoroti.program.ModelProduk;
import java.util.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hinha
 */
public class Keranjang extends javax.swing.JFrame {

    KoneksiDB kon = new KoneksiDB();
    GregorianCalendar kalender = new GregorianCalendar();
    ModelKeranjang modelKeranjang;
    String bulan[] = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Aug", "Sep", 
         "Oct", "Nov", "Des"};
    int ID = 0;
    int tgl = kalender.get(Calendar.DATE);
    String bln = bulan[kalender.get(Calendar.MONTH)];
    int thn = kalender.get(Calendar.YEAR);
    String totals = "";
    int jumTot = 0;
    
    /**
     * Creates new form keranjang
     */
    public Keranjang() {
        initComponents();
        cmbPesanlist_inOne();
        showTotal();
        detailPesanan();
        infoData();
        lblTGL.setText(Integer.toString(tgl) + " " + bln + " " +  Integer.toString(thn));
    }

    public void showTotal(){
        try {
            kon.res = kon.stat.executeQuery("SELECT harga FROM produk, pemesanan where produk.id_produk = pemesanan.id_produk");
            while(kon.res.next()){  
                totals = kon.res.getString(1);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Keranjang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void infoData() {
        DefaultTableModel modelInfoData = new DefaultTableModel();
        modelInfoData.addColumn("No");
        modelInfoData.addColumn("Nama");
        modelInfoData.addColumn("Jumlah");
        modelInfoData.addColumn("Produk");
        modelInfoData.addColumn("Tanggal");
        modelInfoData.addColumn("Harga");
        tblData.setModel(modelInfoData);
        try {
            kon.res = kon.stat.executeQuery("SELECT ps.id_pemesanan, ps.nama_pemesanan, ps.jumlah_pemesanan, pd.nama_produk, ps.tgl_pesan, pd.harga "
                    + "FROM pemesanan ps, produk pd WHERE pd.id_produk = ps.id_produk");
            while(kon.res.next()){  
                modelInfoData.addRow(new Object[]{
                    kon.res.getInt(1),
                    kon.res.getString(2),
                    kon.res.getInt(3),
                    kon.res.getString(4),
                    kon.res.getString(5),
                    kon.res.getInt(6)
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Keranjang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void detailPesanan() {
        DefaultTableModel modelDataPesanan = new DefaultTableModel();
        modelDataPesanan.addColumn("Nama");
        modelDataPesanan.addColumn("Jumlah");
        modelDataPesanan.addColumn("Total");
        modelDataPesanan.addColumn("Keterangan");
        tblPemesan.setModel(modelDataPesanan);
        try {
            kon.res = kon.stat.executeQuery("SELECT nama_pemesanan, jumlah_pemesanan, total, keterangan FROM pemesanan ORDER BY id_pemesanan DESC ");
            while(kon.res.next()){  
                modelDataPesanan.addRow(new Object[]{
                    kon.res.getString(1),
                    kon.res.getInt(2),
                    kon.res.getInt(3),
                    kon.res.getString(4) 
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(Keranjang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cmbPesanlist_inOne() {
        DefaultComboBoxModel cmbPesan = new DefaultComboBoxModel();
        DefaultComboBoxModel cmbAnggota = new DefaultComboBoxModel();
        cmbPesan.addElement("Pilih");
        cmbAnggota.addElement("No Pelanggan");
        jcmbPoduk.setModel(cmbPesan);
        jcmbAnggota.setModel(cmbAnggota);
        try {
            kon.res = kon.stat.executeQuery("SELECT nama_produk FROM produk ORDER BY id_produk ASC");
            while(kon.res.next()){  
                cmbPesan.addElement(kon.res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Keranjang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            kon.res = kon.stat.executeQuery("SELECT nama FROM pelanggan");
            while(kon.res.next()){  
                cmbAnggota.addElement(kon.res.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Keranjang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPemesan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTGL = new javax.swing.JLabel();
        jcmbAnggota = new javax.swing.JComboBox<>();
        jcmbPoduk = new javax.swing.JComboBox<>();
        jumlah_pemesanan1 = new javax.swing.JLabel();
        jumlah_pemesanan = new javax.swing.JLabel();
        txt_jumlah_pemesanan = new javax.swing.JTextField();
        txtKet = new javax.swing.JTextField();
        lblKet = new javax.swing.JLabel();
        btn_lakukan_transaksi = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        btn_hitung = new javax.swing.JButton();
        txtBayar = new javax.swing.JTextField();
        bayar = new javax.swing.JLabel();
        kembali = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtKembali = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pemesanan");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Pesanan"));
        jPanel2.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N

        tblPemesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Jumlah", "Total", "Keterangan"
            }
        ));
        jScrollPane1.setViewportView(tblPemesan);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tgl Pesan");

        jLabel2.setText("Pemesan");

        lblTGL.setText("jLabel3");

        jumlah_pemesanan1.setText("Produk");

        jumlah_pemesanan.setText("Jumlah");

        lblKet.setText("Keterangan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jumlah_pemesanan1)
                    .addComponent(jumlah_pemesanan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcmbPoduk, 0, 179, Short.MAX_VALUE)
                    .addComponent(jcmbAnggota, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTGL)
                    .addComponent(txt_jumlah_pemesanan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKet, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKet))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTGL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcmbAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcmbPoduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlah_pemesanan1))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblKet)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlah_pemesanan)
                    .addComponent(txt_jumlah_pemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btn_lakukan_transaksi.setText("LAKUKAN TRANSAKSI");
        btn_lakukan_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lakukan_transaksiActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        total.setText("Total");

        btn_hitung.setText("HITUNG");
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        bayar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bayar.setText("Bayar");

        kembali.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        kembali.setText("Kembali");

        lblTotal.setText("0");

        txtKembali.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 623, Short.MAX_VALUE)
                        .addComponent(total)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_lakukan_transaksi)
                        .addGap(48, 48, 48)
                        .addComponent(btn_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(bayar)
                                .addGap(18, 18, 18)
                                .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(kembali)
                                .addGap(18, 18, 18)
                                .addComponent(txtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total)
                            .addComponent(lblTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bayar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kembali)
                            .addComponent(txtKembali)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_lakukan_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informasi Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 13))); // NOI18N

        btnBack.setText("Kembali");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Jumlah", "Produk", "Tanggal", "Harga"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblData);

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(jLabel4)
                    .addContainerGap(764, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(560, 560, 560)
                    .addComponent(jLabel4)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
        if(jcmbAnggota.getSelectedItem().equals("No Pelanggan") || txt_jumlah_pemesanan.getText().equals("") 
                || txt_jumlah_pemesanan.getText().equals("") || txtKet.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Form tidak boleh Kosong");
        } else {
            modelKeranjang = new ModelKeranjang(String.valueOf(jcmbAnggota.getSelectedItem()), Integer.parseInt(txt_jumlah_pemesanan.getText()),
                    txtKet.getText(), jcmbPoduk.getSelectedIndex(), jcmbAnggota.getSelectedIndex(), Integer.parseInt(totals));
            
            int jumPes = Integer.valueOf(txt_jumlah_pemesanan.getText());
            jumTot = Integer.valueOf(totals) * jumPes;
            
            lblTotal.setText(String.valueOf(jumTot));
            if (modelKeranjang.insertKeranjang()) {
                detailPesanan();
            }
        }
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
//       int index = tblData.getSelectedRow();
//       String id = tblData.getValueAt(index, 0).toString();
        modelKeranjang = new ModelKeranjang();
        if (modelKeranjang.deleteKeranjang(ID)) {
            infoData();
            detailPesanan();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBayarActionPerformed

    private void btn_lakukan_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lakukan_transaksiActionPerformed

        if (txtBayar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bayar Kosong");
        } else {
            int bayar = Integer.parseInt(txtBayar.getText());
            System.out.println("Tot:" + jumTot);
            if (lblTotal.getText().equals("0")) {
                JOptionPane.showMessageDialog(this, "Bayar Kosong");
            } else {
                if (bayar < jumTot) {
                JOptionPane.showMessageDialog(this, "Kurang bayar");
                } else {
                    int jum = jumTot - bayar;
                    txtKembali.setText(String.valueOf(jum));
                    infoData();
                    JOptionPane.showMessageDialog(this, "Transaksi Berhasil");
                }
            }
        }
    }//GEN-LAST:event_btn_lakukan_transaksiActionPerformed

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        int row = tblData.getSelectedRow();
        ID = Integer.parseInt(tblData.getModel().getValueAt(row, 0).toString());
    }//GEN-LAST:event_tblDataMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Keranjang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Keranjang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bayar;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btn_hitung;
    private javax.swing.JButton btn_lakukan_transaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcmbAnggota;
    private javax.swing.JComboBox<String> jcmbPoduk;
    private javax.swing.JLabel jumlah_pemesanan;
    private javax.swing.JLabel jumlah_pemesanan1;
    private javax.swing.JLabel kembali;
    private javax.swing.JLabel lblKet;
    private javax.swing.JLabel lblTGL;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblData;
    private javax.swing.JTable tblPemesan;
    private javax.swing.JLabel total;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JLabel txtKembali;
    private javax.swing.JTextField txtKet;
    private javax.swing.JTextField txt_jumlah_pemesanan;
    // End of variables declaration//GEN-END:variables
}
