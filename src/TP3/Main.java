package TP3;

public class Main {
    public static void main(String[] telsArgs) throws InterruptedException {
        BAL bal = new BAL();
        Consomateur con = new Consomateur(bal);
        Producteur Pro = new Producteur(bal);

        con.start();
        Pro.start();

    }
}

