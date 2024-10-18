package TP3;

import java.util.Random;
public class MainBoul {
    public static void main(String[] args) {

        // on initialise une boulangerie, et une variable aléatoire pour nos client
        final Boulangerie boulangerie = new Boulangerie();
        final Random rand = new Random();

        // notre boulanger est un runnable
        Boulanger boulanger = new Boulanger(boulangerie);

        // notre mangeur est aussi un runnable
        Mangeur mangeur = new Mangeur(rand,boulangerie);

        Thread[] boulangers = new Thread[5];
        Thread[] mangeurs = new Thread[2];

        // préparation des boulangers
        for (int i = 0; i < boulangers.length; i++) {
            boulangers[i] = new Thread(boulanger);
        }

        // préparation des mangeurs
        for (int i = 0; i < mangeurs.length; i++) {
            mangeurs[i] = new Thread(mangeur);
        }

        // lancement des boulangers
        for (int i = 0; i < boulangers.length; i++) {
            boulangers[i].start();
        }

        // lancement des mangeurs
        for (int i = 0; i < mangeurs.length; i++) {
            mangeurs[i].start();
        }
        try {
            Thread.sleep(20000) ;
        }  catch (InterruptedException e) {
        }

        // arrêt de notre système
        for (int i =  0 ; i < boulangers.length ; i++) {
            // interruption des producteurs
            boulangers[i].interrupt() ;
        }

        // dépôt des pilules empoisonnées
        for (int i =  0 ; i < mangeurs.length ; i++) {
            boulangerie.deposePainEmpoisonne() ;
        }
    }
}
