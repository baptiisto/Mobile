import java.awt.*;
import javax.swing.*;

class UneFenetre extends JFrame 
{
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre()
    {
	// TODO 
	// ajouter sonMobile a la fenetre
        sonMobile = new UnMobile(LARG, HAUT);
        this.add(sonMobile);
        this.setSize(LARG, HAUT);
	// creer une thread laThread avec sonMobile
        Thread laTache = new Thread(sonMobile);
	// afficher la fenetre
        this.setVisible(true);
	// lancer laThread
        laTache.start();
    }
}
