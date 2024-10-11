package TP3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bal bal = new Bal("",true);
        Producteur prod = new Producteur("12345",bal);
        Consommateur cons = new Consommateur("",bal);
        prod.start();
        cons.start();
        cons.retirerLettre();
        prod.deposerLettre();
    }
}
