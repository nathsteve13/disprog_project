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
public class Reservasi_parking extends MyModel {
    private int reservasi_id;
    private Timestamp tanggal_parkir;
    private int slot_reservasi;
    private String status_reservasi;
    private Parking parking_parking_id;
    private User user_user_id;
    
    public Reservasi_parking(){
        this.reservasi_id=0;
        this.tanggal_parkir=new java.sql.Timestamp(System.currentTimeMillis());
        this.slot_reservasi=0;
        this.status_reservasi="";
        this.parking_parking_id=new Parking();
        this.parking_parking_id.setParking_id(0);
        this.user_user_id=new User();
        this.user_user_id.setUser_id(0);
    }
    public Reservasi_parking(int reservasi_id){
        this.reservasi_id = reservasi_id;
    }
    public Reservasi_parking(int parking_parking_id, int user_user_id) {
        this.parking_parking_id=new Parking();
        this.parking_parking_id.setParking_id(parking_parking_id);
        this.user_user_id = new User();
        this.user_user_id.setUser_id(user_user_id);
    }
    
    public Reservasi_parking(int reservasi_id, Timestamp tanggal_parkir, int slot_reservasi, String status_reservasi, int parking_parking_id, int user_user_id) {
        this.reservasi_id = reservasi_id;
        this.tanggal_parkir = tanggal_parkir;
        this.slot_reservasi = slot_reservasi;
        this.status_reservasi = status_reservasi;
        this.parking_parking_id=new Parking();
        this.parking_parking_id.setParking_id(parking_parking_id);
        this.user_user_id = new User();
        this.user_user_id.setUser_id(user_user_id);
    }

    

    public int getReservasi_id() {
        return reservasi_id;
    }

    public void setReservasi_id(int reservasi_id) {
        this.reservasi_id = reservasi_id;
    }

    public Timestamp getTanggal_parkir() {
        return tanggal_parkir;
    }

    public void setTanggal_parkir(Timestamp tanggal_parkir) {
        this.tanggal_parkir = tanggal_parkir;
    }

    public int getSlot_reservasi() {
        return slot_reservasi;
    }

    public void setSlot_reservasi(int slot_reservasi) {
        this.slot_reservasi = slot_reservasi;
    }

    public String getStatus_reservasi() {
        return status_reservasi;
    }

    public void setStatus_reservasi(String status_reservasi) {
        this.status_reservasi = status_reservasi;
    }

    public int getParking_parking_id() {
        return parking_parking_id.getParking_id();
    }

    public void setParking_parking_id(int parking_parking_id) {
        this.parking_parking_id.setParking_id(parking_parking_id);
    }

    public int getUser_user_id() {
        return user_user_id.getUser_id();
    }

    public void setUser_user_id(int user_user_id) {
        this.user_user_id.setUser_id(user_user_id);
    }

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = MyModel.conn.prepareStatement(
                        "INSERT INTO reservasi_parking (tanggal_parkir, slot_reservasi, status_reservasi, parking_parking_id, user_user_id) VALUES (?, ?, ?, ?, ?)");
                sql.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
                sql.setInt(2, 1);
                sql.setString(3, "Not Claimed");
                sql.setInt(4, this.parking_parking_id.getParking_id());
                sql.setInt(5, this.user_user_id.getUser_id());
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
                        "UPDATE reservasi_parking SET status_reservasi = ? WHERE reservasi_id = ?");
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
                    "SELECT * FROM reservasi_parking WHERE user_user_id = ?");
            sql.setInt(1, this.user_user_id.getUser_id());
            ResultSet result = sql.executeQuery();

            while (result.next()) {
                Reservasi_parking r = new Reservasi_parking(
                        result.getInt("reservasi_id"),
                        result.getTimestamp("tanggal_parkir"),
                        result.getInt("slot_reservasi"),
                        result.getString("status_reservasi"),
                        result.getInt("parking_parking_id"),
                        result.getInt("user_user_id")
                );

                data.add(r.getReservasi_id() + "%" +
                        r.getTanggal_parkir() + "%" +
                        r.getSlot_reservasi() + "%" +
                        r.getStatus_reservasi() + "%" +
                        r.getParking_parking_id()+ "%" +
                        r.getUser_user_id());
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
