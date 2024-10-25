package TP3;

import java.util.Random;
public class MAINBALV2 {
    public static void main(String[] args) {

        // on initialise une boulangerie, et une variable aléatoire pour nos client
        final BALV2 bal = new BALV2();
        final Random rand = new Random();

        // notre boulanger est un runnable
        ProducteurV2 prod = new ProducteurV2(bal);

        // notre mangeur est aussi un runnable
        ConsommateurV2 con = new ConsommateurV2(rand,bal);

        Thread[] prods = new Thread[5];
        Thread[] cons = new Thread[2];

        // préparation des boulangers
        for (int i = 0; i < prods.length; i++) {
            prods[i] = new Thread(prod);
        }

        // préparation des mangeurs
        for (int i = 0; i < cons.length; i++) {
            cons[i] = new Thread(con);
        }

        // lancement des boulangers
        for (int i = 0; i < prods.length; i++) {
            prods[i].start();
        }

        // lancement des mangeurs
        for (int i = 0; i < cons.length; i++) {
            cons[i].start();
        }
        try {
            Thread.sleep(20000) ;
        }  catch (InterruptedException e) {
        }

        // arrêt de notre système
        for (int i =  0 ; i < prods.length ; i++) {
            // interruption des producteurs
            prods[i].interrupt() ;
        }

        // dépôt des pilules empoisonnées
        for (int i =  0 ; i < cons.length ; i++) {
            bal.deposeLettreQ(); ;
        }
    }
}
