package TP3;

public class Consomateur extends Thread{
    String Lettre;
    BAL bal;

    public Consomateur(BAL bal) throws InterruptedException {
        Lettre="";
        this.bal = bal;
    }

    public void run() {
        Lettre = bal.read();
        while (Lettre==""){
            System.out.println(Lettre);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Lettre = bal.read();
        }
        System.out.println("Contenue de la Lettre : " + Lettre);
    }
}
