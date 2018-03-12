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
        //On recupére la reference vers le fichier test.txt
        File f = new File("/home/cedriclavery/programmes/FLUX_01/fichiers/exercice1.txt");
        //On crée un flux entrant du fichier (sortant pour le programme)
        FileOutputStream output = new FileOutputStream(f);
        //Message a enregistrer dans le fichier
        String message = "hello world !";
        //Envoie par paquets de 8 octets
        byte[] paquet = new byte[8];
        //Initialisation des variables
        int fin = message.length();
        int index = 0;
        //Tant que la fin du message n'est pas atteinte
        while(index < fin){
            //Insert des caractères dans le tableau
            for (int i = 0; i < 8; i++){
                //La dernière partie ne tombe pas forcément pile a 8 octets
                if(index<fin){
                    paquet[i] = (byte)message.charAt(index);
                    index++;
                }else{
                    break;
                }
            }
            //On envoie chaque paquets dans le fichier
            output.write(paquet);
            //Raz sur le buffer
            paquet = new byte[8];
            
        }
        //Ferme le flux sortant
        output.close();
    }
    
}
