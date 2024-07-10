/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project_webservice.model;

import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class User extends MyModel{

    private int user_id;
    private String username;
    private String password;
    private String nama;
    private String email;
    
    public User() {
        this.user_id = 0;
        this.username = "";
        this.password = "";
        this.nama = "";
        this.email = "";
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public User(String email) {
        this.email = email;
    }
    
    public User(int user_id, String username, String password, String nama, String email) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.email = email;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String checkLogin() {
        String user = "";
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "SELECT * FROM user WHERE username = ? and password = ?"
                );
                sql.setString(1, this.username);
                sql.setString(2, this.password);
                
                if (this.result.next()) {
                    this.setUser_id(this.result.getInt("id"));
                    this.setUsername(this.result.getString("username"));
                    this.setPassword(this.result.getString("password"));
                    this.setNama(this.result.getString("nama"));
                    this.setEmail(this.result.getString("email"));
                    sql.close();
                    user = "TRUE%" + user_id + "\n";
                }
                else {
                    user = "FALSE%\n";
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
    
    public boolean checkEmail() {
        boolean check = true;
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "SELECT * FROM user WHERE email = ?" 
                );
                sql.setString(1, this.email);
                this.result = sql.executeQuery();
                if (this.result.next()) {
                    sql.close();
                    check = false;
                }
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return check;
    }
    
    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "insert into user (username, password, nama) values (?,?,?)");
                sql.setString(1, this.username);
                sql.setString(2, this.password);
                sql.setString(3, this.nama);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
