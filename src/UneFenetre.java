import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class UneFenetre extends JFrame 
{
    UnMobile tache;
    private final int LARG=800, HAUT=800;
    public UneFenetre(int nombre)
    {
        this.setVisible(true);
        Container conteneur = getContentPane();
        conteneur.setLayout(new BoxLayout(conteneur,BoxLayout.Y_AXIS));
        this.setSize(LARG, HAUT);
	// ajouter sonMobile a la fenetre
	// creer une thread laThread avec sonMobile
        for(int e = 0;e < nombre;e++){
            tache = new UnMobile(LARG, 10);
            Thread supportDeTache = new Thread(tache);
            conteneur.add(tache);
            supportDeTache.start();

        }

    }
}

