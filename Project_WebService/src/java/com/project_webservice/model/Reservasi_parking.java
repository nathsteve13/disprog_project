/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_webservice.model;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class Reservasi_parking extends MyModel {
    private int reservasi_id;
    private Timestamp tanggal_reservasi;
    private int jumlah_tiket;
    private String status_reservasi;
    private User user_id;
    private Acara acara_id;
    
    public Reservasi_parking(){
        this.reservasi_id=0;
        this.tanggal_reservasi=new java.sql.Timestamp(System.currentTimeMillis());
        this.jumlah_tiket=0;
        this.status_reservasi="";
        this.user_id =new User();
        this.user_id.setUser_id(0);
        this.acara_id = new Acara();
        this.acara_id.setAcara_id(0);
    }

    public Reservasi_parking(int reservasi_id, Timestamp tanggal_reservasi, int jumlah_tiket, String status_reservasi, User user_id, Acara acara_id) {
        this.reservasi_id = reservasi_id;
        this.tanggal_reservasi = tanggal_reservasi;
        this.jumlah_tiket = jumlah_tiket;
        this.status_reservasi = status_reservasi;
        this.user_id = user_id;
        this.acara_id = acara_id;
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

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Acara getAcara_id() {
        return acara_id;
    }

    public void setAcara_id(Acara acara_id) {
        this.acara_id = acara_id;
    }

    @Override
    public void insertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<String> viewListData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
