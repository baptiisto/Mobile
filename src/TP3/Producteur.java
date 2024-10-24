package TP3;

import java.util.Scanner;

public class Producteur extends Thread {
    private BAL bal;
    private String lettre;

    public Producteur(BAL bal) {
        this.bal = bal;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Entrez une lettre (ou 'Q' pour arrêter): ");
            lettre = scanner.nextLine();
            boolean success = bal.write(lettre);
            if (!success) {
                System.out.println("Boîte aux lettres pleine, attente...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (!lettre.equals("Q"));

        System.out.println("Producteur arrêté.");
    }
}