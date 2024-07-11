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
public class Parking extends MyModel{
    private int parking_id;
    private String slot_tersedia;
    private int total_slotparkir;
    private String status_parkir;
    private Timestamp tanggal_parkir;
    
    public Parking(){
        this.parking_id=0;
        this.slot_tersedia="";
        this.total_slotparkir=0;
        this.status_parkir="";
        this.tanggal_parkir=new java.sql.Timestamp(System.currentTimeMillis());
    }
     
    public Parking(int parking_id, String slot_tersedia, int total_slotparkir, String status_parkir, Timestamp tanggal_parkir) {
        this.parking_id = parking_id;
        this.slot_tersedia = slot_tersedia;
        this.total_slotparkir = total_slotparkir;
        this.status_parkir = status_parkir;
        this.tanggal_parkir = tanggal_parkir;
    }
    public Parking(int parking_id, int total_slotparkir,String status_parking){
        this.parking_id=parking_id;
        this.total_slotparkir=total_slotparkir;
        this.status_parkir=status_parking;
    }

    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    public String getSlot_tersedia() {
        return slot_tersedia;
    }

    public void setSlot_tersedia(String slot_tersedia) {
        this.slot_tersedia = slot_tersedia;
    }

    public int getTotal_slotparkir() {
        return total_slotparkir;
    }

    public void setTotal_slotparkir(int total_slotparkir) {
        this.total_slotparkir = total_slotparkir;
    }

    public String getStatus_parkir() {
        return status_parkir;
    }

    public void setStatus_parkir(String status_parkir) {
        this.status_parkir = status_parkir;
    }

    public Timestamp getTanggal_parkir() {
        return tanggal_parkir;
    }

    public void setTanggal_parkir(Timestamp tanggal_parkir) {
        this.tanggal_parkir = tanggal_parkir;
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
                        "UPDATE parking SET status_parking = ?, total_slotparkir = ? WHERE parking_id = ?");
                sql.setString(1, this.status_parkir);
                sql.setInt(2, this.total_slotparkir);
                sql.setInt(3, this.parking_id);
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
        ArrayList<String> collections = new ArrayList<String>();
        try {
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("SELECT * FROM parking");
            while (this.result.next()) {
                Parking tempv = new Parking();
                tempv.setParking_id(this.result.getInt("parking_id"));
                tempv.setSlot_tersedia(this.result.getString("slot_tersedia"));
                tempv.setTotal_slotparkir(this.result.getInt("total_slotparkir"));
                tempv.setStatus_parkir(this.result.getString("status_parking"));
                tempv.setTanggal_parkir(this.result.getTimestamp("tanggal_parkir"));

                collections.add(tempv.getParking_id()+ "%" + tempv.getSlot_tersedia()+ "%" + tempv.getTotal_slotparkir()+ "%" + tempv.getStatus_parkir()+ "%" + tempv.getTanggal_parkir());
            }
    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
    return collections;
    }
    
    
}
