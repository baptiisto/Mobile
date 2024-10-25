package TP3;

public  class ProducteurV2  implements Runnable {

    public BALV2 bal;
    public ProducteurV2(BALV2 bal){
        this.bal = bal;
    }
    public  void run() {

        try {
            while (true) {

                // toutes les secondes un boulanger produit un pain
                Thread.sleep(1000) ;
                boolean added = bal.depose(new Lettre()) ;

                if (added) {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" +
                            "[" + bal.getStock() +  "] je dépose.") ;
                }  else {
                    System.out.println("[" + Thread.currentThread().getName() +  "]" +
                            "[" + bal.getStock() +  "] la boite est pleine.") ;
                }
            }

        }  catch (InterruptedException e) {
            System.out.println("[" + Thread.currentThread().getName() +  "] je m'arrête") ;
        }
    }
}