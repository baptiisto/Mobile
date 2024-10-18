package TP3;

public class Producteur extends Thread {
    BAL bal;
    String Lettre;

    public Producteur(String lettre,BAL bal) throws InterruptedException {
        this.bal = bal;
        Lettre = lettre;
    }

    public void run(){
        while (!bal.write(Lettre)){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        bal.write(Lettre);
    }
}
