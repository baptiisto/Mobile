package TP3;

import TP3.BALV2;
import TP3.Lettre;

import java.util.Random;

public  class ConsommateurV2  implements Runnable {
    Random rand = new Random();
    BALV2 bal;
    public ConsommateurV2(Random rand, BALV2 bal) {
        this.rand = rand;
        this.bal = bal;
    }
    public  void run() {

        try {

            while (true) {
                Thread.sleep(rand.nextInt(1000)) ;
                Lettre lettre = bal.lire() ;
                if (lettre != null) {

                    if (lettre == Lettre.LETTRE_Q) {
                        System.out.println("J'aime pas les Q !") ;
                        Thread.currentThread().interrupt() ;
                    }  else {
                        System.out.println("[" + Thread.currentThread().getName() +  "]" +
                                "[" + bal.getStock() +  "] J'ai recu ma lettre ") ;
                    }

                }  else {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" +
                            "[" + bal.getStock() +  "]  J'attends ma lettre ") ;
                }
            }

        }  catch (InterruptedException e) {
        }
    }
}