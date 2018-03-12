/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beweb.lunel.flux.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author cedriclavery
 */
public class Exercice1Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4000);
        
        Socket client = null;
        
        client = server.accept();
        
        System.out.println("connexion du client");
        
        InputStream in = client.getInputStream();
        
        InputStreamReader reader = new InputStreamReader(in);
        
        BufferedReader buffReader = new BufferedReader(reader);
        
        String ligne = "";
        
        while(!(ligne = buffReader.readLine()).contentEquals("q")) {
            System.out.println(ligne);
        }
        buffReader.close();
        reader.close();
        in.close();
        client.close();
        server.close();
    }
    
}
