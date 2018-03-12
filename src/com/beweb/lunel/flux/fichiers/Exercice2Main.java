/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beweb.lunel.flux.fichiers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author cedriclavery
 */
public class Exercice2Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // recupération d'une reference vers le fichier test.txt
        File f = new File("/home/cedriclavery/programmes/FLUX_01/fichiers/exercice2.txt");
        // création d'un flux sortant du fichier (entrant pour le programme)
        FileInputStream input = new FileInputStream(f);
        // recuperation du flux par paquets de 8 octets
        byte[] paquet = new byte[8];
        // la methode read() retourne le nombre de donnée transmises au tableau
        //« paquet » et -1 quand il n'y a plus de données
        while(input.read(paquet)!= -1){
            //petite boucle pour lire les caractères se trouvant dans le tableau
            for (int i = 0; i < paquet.length; i++) {
                // les données étant au format octet on les caste en caratère
                System.out.print((char)paquet[i]);
            }
            // on vide le tableau
            paquet = new byte[8];
        }
        // fermeture du flux
        input.close();
    }
    
}
