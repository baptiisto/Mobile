package TP3;

public class Consommateur extends Thread  {
    String lettre;
    Bal chbal;

    public Consommateur(String parlettre, Bal parbal) {
        lettre = parlettre;
        this.chbal = parbal;
    }
    public void retirerLettre() throws InterruptedException {
        lettre = chbal.read();
        while(lettre == null){
            Thread.sleep(100);
            lettre = chbal.read();
        }
        System.out.println(lettre);
    }
}
