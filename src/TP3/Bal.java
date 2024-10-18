package TP3;

public class BAL {
    String Boite;
    boolean Avalaible;

    public BAL() {
        Boite = "";
        Avalaible = true;
    }

    public synchronized boolean write(String Lettre)  {
        if (Avalaible) {
            Boite = Lettre;
            Avalaible = false;
            return true;
        }
        return false;
    }

    public synchronized String read()  {
        if (!Avalaible){
            Avalaible = true;
            return Boite;
        }
        return "";
    }
}
