import java.awt.*;
import javax.swing.*;

class UneFenetre extends JFrame 
{
    UnMobile tache;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre()
    {
	// TODO 
	// ajouter sonMobile a la fenetre
        tache = new UnMobile(LARG, HAUT);
        this.add(tache);
        this.setSize(LARG, HAUT);
	// creer une thread laThread avec sonMobile
        Thread supportDeTache = new Thread(tache);
	// afficher la fenetre
        this.setVisible(true);
	// lancer laThread
        supportDeTache.start();
    }
}
