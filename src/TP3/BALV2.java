package TP3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public  class BALV2 {

    // plus prosaïquement, une boulangerie est une file d'attente de 20 cases
    private BlockingQueue<Lettre> queue =  new ArrayBlockingQueue<Lettre>(20) ;

    // on peut y déposer du pain, mais le boulanger n'est pas patient
    // si le panier de vente est plein, il s'en va
    public  boolean depose(Lettre lettre)  throws InterruptedException {
        return queue.offer(lettre,  200, TimeUnit.MILLISECONDS) ;
    }

    // on peut en acheter, et le client n'est pas plus patient
    // que le boulanger
    public Lettre lire ()  throws InterruptedException {
        return queue.poll(200, TimeUnit.MILLISECONDS) ;
    }

    // on peut interroger le stock
    public  int getStock() {
        return queue.size() ;
    }
    public  void deposeLettreQ() {
        queue.add(Lettre.LETTRE_Q) ;
    }
}