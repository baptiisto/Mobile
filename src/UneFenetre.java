import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class UneFenetre extends JFrame 
{
    UnMobile tache;
    private final int LARG=900, HAUT=900;
    private  boolean stop = false;
    
    public UneFenetre()
    {

	// ajouter sonMobile a la fenetre
	// creer une thread laThread avec sonMobile
        tache = new UnMobile(LARG, HAUT);
        Thread supportDeTache = new Thread(tache);
	// afficher la fenetre
        this.setVisible(true);
        Container conteneur = getContentPane();
        conteneur.setLayout(new BorderLayout());
        conteneur.add(tache);
        this.setSize(LARG, HAUT);
	// lancer laThread #
        supportDeTache.start();
    }
}

