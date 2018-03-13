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
import java.io.PrintWriter;
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
        // Socket spéciale serveur ecoute sur 192.168.1.47:4000
        ServerSocket server = new ServerSocket(4000);
        Socket client = null;
 
        // en attente d'une connexion cliente, retourne le handler du canal
        client = server.accept();
        System.out.println("connexion du client");
 
        // préparation de la gestion du flux entrant
        InputStream in = client.getInputStream();
        InputStreamReader reader = new InputStreamReader(in);
        // objet PrintWriter pour plus de convivialité
        PrintWriter out = new PrintWriter(client.getOutputStream());
 
        // message dans le tampon de sortie
        out.print("Bienvenue sur le serveur \n");
        out.print("Entrée un message \n");
        // envoi du message
        out.flush();
       
       
        BufferedReader buffReader = new BufferedReader(reader);
        String ligne = "";
 
// tant que le client ne retourne pas "q" on lit les messages des clients
        while(!(ligne = buffReader.readLine()).contentEquals("q")) {
            out.print("Merci de votre message, continuez ou quittez q \n");
            out.flush();
            System.out.println(ligne);
        }
        // fermeture des canaux
        out.println("Merci de votre visite");
        out.flush();
        buffReader.close();
        reader.close();
        in.close();
        client.close();
        server.close();
       
    }
    
}
