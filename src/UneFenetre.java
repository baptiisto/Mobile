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
        JButton sonBouton = new JButton("start/stop");
        sonBouton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boutonActivation(supportDeTache);
            }
        });
        conteneur.add(tache);
        this.setSize(LARG, HAUT);
        conteneur.add(sonBouton,BorderLayout.WEST);
	// lancer laThread
        supportDeTache.start();
    }
    private  void boutonActivation(Thread supportDeTache){
        if(!stop){
            supportDeTache.start();
            stop = true;
        }
        else{
            stop = false;
            supportDeTache.resume();
        }
    }
}
