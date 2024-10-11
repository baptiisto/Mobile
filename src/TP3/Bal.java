package TP3;

public class Bal {
    String Boite;
    Boolean avaible;

    public Bal(String Boite, Boolean paravaible) {
        this.Boite = Boite;
        avaible = paravaible;
    }
    public synchronized Boolean write(String Lettre) throws InterruptedException {
        if(!avaible) {
            return avaible;
        }
        Boite = Lettre;
        avaible = false;
    }
    public synchronized String read() throws InterruptedException {
        if(avaible){
            return null;
        }
        avaible = true;
        return Boite;
    }
}
