package TP3;

import java.util.Random;

public  class Mangeur  implements Runnable {
    Random rand = new Random();
    Boulangerie boulangerie;
    public Mangeur(Random rand, Boulangerie boulangerie) {
        this.rand = rand;
        this.boulangerie = boulangerie;
    }
    public  void run() {

        try {

            while (true) {
                // nos mangeurs mangent de façon aléatoire...
                Thread.sleep(rand.nextInt(1000)) ;
                Pain pain = boulangerie.achete() ;
                if (pain != null) {

                    if (pain == Pain.PAIN_EMPOISONNE) {
                        System.out.println("Je meurs !") ;
                        Thread.currentThread().interrupt() ;
                    }  else {
                        System.out.println("[" + Thread.currentThread().getName() +  "]" +
                                "[" + boulangerie.getStock() +  "] miam miam") ;
                    }

                }  else {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" +
                            "[" + boulangerie.getStock() +  "] j'ai faim") ;
                }
            }

        }  catch (InterruptedException e) {
        }
    }
}