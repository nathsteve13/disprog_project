/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_webservice.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Reservasi_acara extends MyModel {

    private int reservasi_id;
    private Timestamp tanggal_reservasi;
    private int jumlah_tiket;
    private String status_reservasi;
    private User user_id;
    private Acara acara_id;
    
    public Reservasi_acara(int reservasi_id, Timestamp tanggal_reservasi, int jumlah_tiket, String status_reservasi, int user_id, int acara_id) {
        this.reservasi_id = reservasi_id;
        this.tanggal_reservasi = tanggal_reservasi;
        this.jumlah_tiket = jumlah_tiket;
        this.status_reservasi = status_reservasi;
        this.acara_id = new Acara();
        this.acara_id.setAcara_id(acara_id);
        this.user_id = new User();
        this.user_id.setUser_id(user_id);
    }
    public Reservasi_acara(int reservasi_id) {
        this.reservasi_id = reservasi_id;
    }
    
    public Reservasi_acara(int jumlah_tiket, int user_id, int acara_id) {
        this.jumlah_tiket = jumlah_tiket;
        this.acara_id = new Acara();
        this.acara_id.setAcara_id(acara_id);
        this.user_id = new User();
        this.user_id.setUser_id(user_id);
    }
    
    public Reservasi_acara() {
        this.reservasi_id = 0;
        this.tanggal_reservasi = new java.sql.Timestamp(System.currentTimeMillis());
        this.jumlah_tiket = 0;
        this.status_reservasi = "";
        this.acara_id = new Acara();
        this.acara_id.setAcara_id(0);
        this.user_id = new User();
        this.user_id.setUser_id(0);
    }
    

    public int getReservasi_id() {
        return reservasi_id;
    }

    public void setReservasi_id(int reservasi_id) {
        this.reservasi_id = reservasi_id;
    }

    public Timestamp getTanggal_reservasi() {
        return tanggal_reservasi;
    }

    public void setTanggal_reservasi(Timestamp tanggal_reservasi) {
        this.tanggal_reservasi = tanggal_reservasi;
    }

    public int getJumlah_tiket() {
        return jumlah_tiket;
    }

    public void setJumlah_tiket(int jumlah_tiket) {
        this.jumlah_tiket = jumlah_tiket;
    }

    public String getStatus_reservasi() {
        return status_reservasi;
    }

    public void setStatus_reservasi(String status_reservasi) {
        this.status_reservasi = status_reservasi;
    }

    public int getUser_id() {
        return user_id.getUser_id();
    }

    public void setUser_id(int user_id) {
        this.user_id.setUser_id(user_id);
    }

    public int getAcara_id() {
        return acara_id.getAcara_id();
    }

    public void setAcara_id(int acara_id) {
        this.acara_id.setAcara_id(acara_id);
    }

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "INSERT INTO reservasi_acara (tanggal_reservasi, jumlah_tiket, status_reservasi, user_user_id, acara_acara_id) VALUES (?, ?, ?, ?, ?)");
                sql.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
                sql.setInt(2, this.jumlah_tiket);
                sql.setString(3, "Not Claimed");
                sql.setInt(4, this.user_id.getUser_id());
                sql.setInt(5, this.acara_id.getAcara_id());
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "UPDATE reservasi_acara SET status_reservasi = ? WHERE reservasi_id = ?");
                sql.setString(1, "Claimed");
                sql.setInt(2, this.reservasi_id);
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
        ArrayList<String> data = new ArrayList<String>();
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "SELECT * FROM reservasi_acara where user_user_id = ?");
                sql.setInt(1, this.user_id.getUser_id());
                ResultSet result = sql.executeQuery();
                
                while (result.next()) {
                    Reservasi_acara r = new Reservasi_acara(
                            result.getInt("reservasi_id"),
                            result.getTimestamp("tanggal_reservasi"),
                            result.getInt("jumlah_tiket"),
                            result.getString("status_reservasi"),
                            result.getInt("user_user_id"),
                            result.getInt("acara_acara_id")
                    );
                    
                    data.add(r.reservasi_id + "%" +
                            r.tanggal_reservasi + "%" +
                            r.jumlah_tiket + "%" +
                            r.status_reservasi + "%" +
                            r.getUser_id() + "%" +
                            r.getAcara_id());
                }
                result.close();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return data;
    }
}
