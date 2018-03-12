/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beweb.lunel.flux.fichiers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author cedriclavery
 */
public class Exercice1Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        File f = new File("/home/cedriclavery/programmes/FLUX_01/fichiers/exercice1.txt");
        
        FileOutputStream output = new FileOutputStream(f);
        
        String message = "hello world !";
        
        byte[] paquet = new byte[8];
        
        int fin = message.length();
        int index = 0;
        
        while(index < fin){
            for (int i = 0; i < 8; i++){
                if(index<fin){
                    paquet[i] = (byte)message.charAt(index);
                    index++;
                }else{
                    break;
                }
            }
            output.write(paquet);
            
            paquet = new byte[8];
            
        }
        output.close();
    }
    
}
