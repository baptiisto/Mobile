package TP3;

public class Main {
    public static void main(String[] telsArgs) throws InterruptedException {
        BAL bal = new BAL();
        Producteur Pro = new Producteur("Salut",bal);
        Consomateur con = new Consomateur(bal);

        Pro.start();
        con.start();


    }
}

