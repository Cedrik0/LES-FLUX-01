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
        //Socket spéciale serveur ecoute sur 127.0.0.1:4000
        ServerSocket server = new ServerSocket(4000);
        
        Socket client = null;
        //En attente d'une connexion cliente, retourne le handler du canal
        client = server.accept();
        
        System.out.println("connexion du client");
        //Prépare la gestion du flux entrant
        InputStream in = client.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader buffReader = new BufferedReader(reader);
        String ligne = "";
        //Tant que le client ne retourne pas "q" on lit les messages des clients
        while(!(ligne = buffReader.readLine()).contentEquals("q")) {
            System.out.println(ligne);
        }
        //Ferme les canaux
        buffReader.close();
        reader.close();
        in.close();
        client.close();
        server.close();
    }
    
}
