package TP3;

public class Consomateur extends Thread {
    private BAL bal;

    public Consomateur(BAL bal) {
        this.bal = bal;
    }

    @Override
    public void run() {
        String lettre;
        while (true) {
            lettre = bal.read();
            if (!lettre.equals("")) {
                System.out.println("Consommateur a retiré la lettre: " + lettre);
                if (lettre.equals("Q")) {
                    System.out.println("Consommateur en a marre du Q");
                    break;
                }
            } else {
                System.out.println("Boîte aux lettres vide, attente...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
