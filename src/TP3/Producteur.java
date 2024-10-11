package TP3;

public class Producteur extends Thread {
    String lettre;
    Bal chbal;

    public Producteur(String parlettre, Bal parbal) {
        lettre = parlettre;
        chbal = parbal;
    }

    public void deposerLettre() throws InterruptedException {
        while(chbal.write(lettre)== false){
            Thread.sleep(100);
        }
        chbal.write(lettre);
    }

}
