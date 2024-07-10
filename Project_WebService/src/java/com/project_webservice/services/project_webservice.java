/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.project_webservice.services;

import com.project_webservice.model.User;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

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
    @WebMethod(operationName = "checkLogin")
    public String checkLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        u = new User(username, password);
        return u.checkLogin();
    }
    @WebMethod(operationName = "checkEmail")
    public boolean checkEmail(@WebParam(name = "email") String email) {
        u = new User(email);
        return u.checkEmail();
    }
}
