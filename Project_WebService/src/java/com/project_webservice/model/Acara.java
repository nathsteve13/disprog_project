/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_webservice.model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Jason Nathaniel
 */
public class Acara extends MyModel{
    private int acara_id;
    private String nama_acara;
    private String deskripsi;
    private Timestamp tanggal_acara;
    private String lokasi_acara;
    private int kapasitas;
    private int harga_tiket;
    private String status_acara;
    
    public Acara(int acara_id, String nama_acara, String deskripsi, Timestamp tanggal_acara, String lokasi_acara, int kapasitas, int harga_tiket, String status_acara) {
        this.acara_id = acara_id;
        this.nama_acara = nama_acara;
        this.deskripsi = deskripsi;
        this.tanggal_acara = tanggal_acara;
        this.lokasi_acara = lokasi_acara;
        this.kapasitas = kapasitas;
        this.harga_tiket = harga_tiket;
        this.status_acara = status_acara;
    }
    
    public Acara() {
        this.acara_id = 0;
        this.nama_acara = "";
        this.deskripsi = "";
        this.tanggal_acara = new java.sql.Timestamp(System.currentTimeMillis());
        this.lokasi_acara = "";
        this.kapasitas = 0;
        this.harga_tiket = 0;
        this.status_acara = "";
    }
    
    public Acara(String status_acara, int kapasitas, int acara_id) {
        this.acara_id = acara_id;
        this.status_acara = status_acara;
        this.kapasitas = kapasitas;
    }
    public int getAcara_id() {
        return acara_id;
    }

    public void setAcara_id(int acara_id) {
        this.acara_id = acara_id;
    }

    public String getNama_acara() {
        return nama_acara;
    }

    public void setNama_acara(String nama_acara) {
        this.nama_acara = nama_acara;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Timestamp getTanggal_acara() {
        return tanggal_acara;
    }

    public void setTanggal_acara(Timestamp tanggal_acara) {
        this.tanggal_acara = tanggal_acara;
    }

    public String getLokasi_acara() {
        return lokasi_acara;
    }

    public void setLokasi_acara(String lokasi_acara) {
        this.lokasi_acara = lokasi_acara;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public int getHarga_tiket() {
        return harga_tiket;
    }

    public void setHarga_tiket(int harga_tiket) {
        this.harga_tiket = harga_tiket;
    }

    public String getStatus_acara() {
        return status_acara;
    }

    public void setStatus_acara(String status_acara) {
        this.status_acara = status_acara;
    }

    @Override
    public void insertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "UPDATE acara SET status_acara = ?, kapasitas = ? WHERE acara_id = ?");
                sql.setString(1, this.status_acara);
                sql.setInt(2, this.kapasitas);
                sql.setInt(3, this.acara_id);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<String> viewListData() {
        ArrayList<String> hasil = new ArrayList<String>();
        try {
            this.statement = (Statement)MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("SELECT * FROM acara");
            
            while (this.result.next()) {
                Acara a = new Acara(result.getInt("acara_id"), 
                        result.getString("nama_acara"), 
                        result.getString("deskripsi"),
                        result.getTimestamp("tanggal_acara"),
                        result.getString("lokasi_acara"),
                        result.getInt("kapasitas"),
                        result.getInt("harga_tiket"),
                        result.getString("status_acara"));
                hasil.add(a.acara_id + "%" + 
                        a.nama_acara + "%" + 
                        a.deskripsi + "%" + 
                        a.tanggal_acara + "%" + 
                        a.lokasi_acara + "%" + 
                        a.kapasitas + "%" +
                        a.harga_tiket + "%" +
                        a.status_acara);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return hasil;
    }
}
