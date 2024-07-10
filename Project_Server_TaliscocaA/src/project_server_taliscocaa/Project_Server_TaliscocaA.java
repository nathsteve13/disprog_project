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

/**
 *
 * @author Jason Nathaniel
 */
public class Project_Server_TaliscocaA implements Runnable {

    /**
     * @param args the command line arguments
     */
    static Socket incoming;
    static String message;
    static ServerSocket s;
    Thread t;
    private static ProjectWebservice_Service service;
    private static ProjectWebservice port;
    ArrayList<HandleSocket> client = new ArrayList<HandleSocket>();
    public Project_Server_TaliscocaA(){
        try {
            this.s = new ServerSocket(3500);
            if (t == null) {
                t = new Thread((Runnable) this, "Server");
                t.start();
            }
            // Initialize the web service client
            service = new ProjectWebservice_Service();
            port = service.getProjectWebservicePort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new Project_Server_TaliscocaA();
        try {
            int id_temp=0;
            s = new ServerSocket(3500);
            while (true) {
                incoming = s.accept();
                BufferedReader msgFromClient = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                message = msgFromClient.readLine();
                System.out.println(message);
                String[] words = message.split("~");
                DataOutputStream msgToClient = new DataOutputStream(incoming.getOutputStream());

                if (words[0].equals("LOGIN")) {
                    String result = checkLogin(words[1], words[2]);
                    System.out.println(result);
                    String[] results=result.split("~");
                    id_temp = Integer.parseInt(results[1]);
                    if (result.startsWith("TRUE")) {
                        msgToClient.writeBytes("TRUE~"+id_temp+"\n");
                    } else if (result.startsWith("FALSE")){      
                        msgToClient.writeBytes("FALSE\n");
                    }
                } else if (words[0].equals("REGISTER")) {
                    boolean isAvailable = port.checkEmail(words[1]);
                    if (isAvailable) {
                        msgToClient.writeBytes("TRUE\n");
                    } else {
                        msgToClient.writeBytes("FALSE\n");
                    }
                } 
                // Add additional commands handling as needed
            }
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    
}
