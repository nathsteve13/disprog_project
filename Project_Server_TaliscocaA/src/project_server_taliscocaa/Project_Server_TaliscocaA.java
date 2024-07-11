/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_server_taliscocaa;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason Nathaniel
 */
public class Project_Server_TaliscocaA implements Runnable {

    ArrayList<HandleSocket> clients = new ArrayList<HandleSocket>();
    Thread t;
    Socket incoming;
    ServerSocket s = new ServerSocket(6000);
    
    public Project_Server_TaliscocaA() throws IOException, Exception {
        if (t == null) {
            t = new Thread(this, "Server");
            t.start();
        }
    }
    
    public void broadCast(String tmp) {
        for (HandleSocket client : clients) {
            client.sendChat(tmp);
        }
    }

    public void showChat(String tmp) {
        broadCast(tmp);
    }
    
    public static void main(String[] args) {
        try {
            Socket incoming;
            String message;
            ServerSocket s = new ServerSocket(3500);
            while (true) {
                incoming = s.accept();
                BufferedReader msgFromClient = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                message = msgFromClient.readLine();
                System.out.println(message);
                String[] words = message.split("%");
                DataOutputStream msgToClient = new DataOutputStream(incoming.getOutputStream());

                if (words[0].equals("LOGIN")) {
                    String result = checkLogin(words[1], words[2]);
                    System.out.println(result);
                    
                    String[] results = result.split("%");
                    
                    if (results[0].equals("TRUE")) {
                        msgToClient.writeBytes("TRUE%"+results[1]+"\n");
                    } else if (results[0].equals("FALSE")){      
                        msgToClient.writeBytes("FALSE\n");
                    }
                    
                } else if (words[0].equals("REGISTER")) {
                    boolean isAvailable = checkEmail(words[1]);
                    if (isAvailable) {
                        insertDataUser(words[2], words[4], words[3], words[1]);
                        msgToClient.writeBytes("TRUE\n");
                    } else {
                        msgToClient.writeBytes("FALSE\n");
                    }
                } 
            }
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                incoming = s.accept();
                HandleSocket hs = new HandleSocket(this, incoming);
                hs.start();
                clients.add(hs);
            } catch (IOException ex) {
                Logger.getLogger(Project_Server_TaliscocaA.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static boolean checkEmail(java.lang.String email) {
        project_server_taliscocaa.ProjectWebservice_Service service = new project_server_taliscocaa.ProjectWebservice_Service();
        project_server_taliscocaa.ProjectWebservice port = service.getProjectWebservicePort();
        return port.checkEmail(email);
    }

    private static String checkLogin(java.lang.String username, java.lang.String password) {
        project_server_taliscocaa.ProjectWebservice_Service service = new project_server_taliscocaa.ProjectWebservice_Service();
        project_server_taliscocaa.ProjectWebservice port = service.getProjectWebservicePort();
        return port.checkLogin(username, password);
    }

    private static void insertDataUser(java.lang.String username, java.lang.String password, java.lang.String nama, java.lang.String email) {
        project_server_taliscocaa.ProjectWebservice_Service service = new project_server_taliscocaa.ProjectWebservice_Service();
        project_server_taliscocaa.ProjectWebservice port = service.getProjectWebservicePort();
        port.insertDataUser(username, password, nama, email);
    }
    
}
