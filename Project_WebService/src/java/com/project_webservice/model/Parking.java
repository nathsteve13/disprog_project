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
 * @author natha
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
            // Check if parking slot is already Not Available
            PreparedStatement checkStatus = MyModel.conn.prepareStatement(
                "SELECT total_slotparkir, status_parking FROM parking WHERE id = ?"
            );  
            checkStatus.setInt(1, this.parking_id);
            this.result = checkStatus.executeQuery();

            if (this.result.next()) {
                String currentStatus = this.result.getString("status_parking");
                int currentTotalSlot = this.result.getInt("total_slotparkir");

                if ("Not Available".equals(currentStatus)) {
                    System.out.println("Parking slot is already Not Available and cannot be claimed.");
                    currentTotalSlot = 0;
                    return;
                }

                if (currentTotalSlot <= 0) {
                    System.out.println("Parking slot is fully occupied and cannot be claimed.");
                    return;
                }

                // Decrease total_slot by 1
                currentTotalSlot--;

                // Change status_parking to Not Available if total_slot reaches 0
                if (currentTotalSlot == 0) {
                    currentStatus = "NOT AVAILABLE";
                }

                // Update total_slot and status_parking
                PreparedStatement updateStatus = MyModel.conn.prepareStatement(
                    "UPDATE parking SET total_slotparkir = ?, status_parking = ? WHERE id = ?"
                );
                updateStatus.setInt(1, currentTotalSlot);
                updateStatus.setString(2, currentStatus);
                updateStatus.setInt(3, this.parking_id);
                updateStatus.executeUpdate();
                updateStatus.close();

                System.out.println("Parking slot with ID " + this.parking_id + " successfully claimed. Total slots decreased by 1.");
            }

            checkStatus.close();
        }
    } catch (Exception e) {
        System.out.println("Error in claimParking: " + e);
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
