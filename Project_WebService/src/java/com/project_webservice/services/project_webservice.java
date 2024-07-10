/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.project_webservice.services;

import com.project_webservice.model.Parking;
import com.project_webservice.model.Acara;
import com.project_webservice.model.Reservasi_acara;
import com.project_webservice.model.User;
import java.util.ArrayList;
import javax.jws.WebService;    
import javax.jws.WebParam;
    
import javax.jws.WebMethod;

/**
 *
 * @author natha
 */
@WebService(serviceName = "project_webservice")
public class project_webservice {

    /**
     * This is a sample web service operation
     */
    
    User u;
    Acara a;
    Reservasi_acara ar;
    @WebMethod(operationName = "checkLogin")
    public String checkLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        u = new User();
        u.setUsername(username);
        u.setPassword(password);
        return u.checkLogin();
    }
    
    @WebMethod(operationName = "checkEmail")
    public boolean checkEmail(@WebParam(name = "email") String email) {
        u = new User(email);
        return u.checkEmail();
    }
    
    @WebMethod(operationName = "viewListDataParking")
    public ArrayList<String> viewListDataParking(){
        Parking p = new Parking();
        return p.viewListData();
    }
    @WebMethod(operationName = "updateDataParking")
    public void updateDataParking( @WebParam(name = "parking_id") int parking_id ,@WebParam(name = "total_slotparkir") int total_slotparkir, 
            @WebParam(name = "status_parking") String status_parking)
    {
        Parking p = new Parking(parking_id,total_slotparkir,status_parking);           
        p.updateData();
    }
    
    @WebMethod(operationName = "updateDataAcara") 
    public void updateDataAcara(@WebParam(name = "status_acara") String status_acara, 
            @WebParam(name = "kapasitas") int kapasitas, 
            @WebParam(name = "acara_id") int acara_id) {
        a = new Acara(status_acara, kapasitas, acara_id);
        a.updateData();
    }
    
    @WebMethod(operationName = "viewListDataAcara")
    public ArrayList<String> viewListDataAcara() {
        a = new Acara();
        return a.viewListData();
    }
    
    @WebMethod(operationName = "viewListDataReservasiAcara")
    public ArrayList<String> viewListDataReservasiAcara() {
        ar = new Reservasi_acara();
        return ar.viewListData();
    }
    
    @WebMethod(operationName = "updateDataReservasiAcara") 
    public void updateDataReservasiAcara(@WebParam(name = "reservasi_id") int reservasi_id) {
        ar = new Reservasi_acara(reservasi_id);
        ar.updateData();
    }
    
    @WebMethod(operationName = "insertDataReservasiAcara") 
    public void insertDataReservasiAcara(@WebParam(name = "jumlah_tiket") int jumlah_tiket, 
            @WebParam(name = "user_id") int user_id,
            @WebParam(name = "acara_id") int acara_id) {
        ar = new Reservasi_acara(jumlah_tiket, user_id, acara_id);
        ar.insertData();
    }
}
