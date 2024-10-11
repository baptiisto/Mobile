import java.awt.*;
import javax.swing.*;

class UnMobile extends JPanel implements Runnable
{
    int saLargeur, saHauteur, sonDebDessin,sonTemps;
    final int sonPas = 10, sonCote=40;
	CemaphoreGeneral cg;
    UnMobile(int telleLargeur, int telleHauteur,CemaphoreGeneral parcg)
    {
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;
	cg = parcg;
	sonTemps = (int) (Math.random() * ( 100 - 50 ));
	setSize(telleLargeur, telleHauteur);
    }
	//
    public void run()
    {
	for (sonDebDessin=0; sonDebDessin *3 < saLargeur - sonPas; sonDebDessin+= sonPas)
	    {
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		    {telleExcp.printStackTrace();}
	    }
		cg.syncWait();
		for (sonDebDessin=saLargeur/3; (3*sonDebDessin/2) < saLargeur - sonPas; sonDebDessin+= sonPas)
		{
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			{telleExcp.printStackTrace();}
		}
		cg.syncSignal();
		for (sonDebDessin=2*saLargeur/3; sonDebDessin < saLargeur - sonPas; sonDebDessin+= sonPas)
		{
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			{telleExcp.printStackTrace();}
		}
	for(sonDebDessin=saLargeur;sonDebDessin> (saLargeur/3)*2;sonDebDessin-=sonPas ){
		repaint();
		try{Thread.sleep(sonTemps);}
		catch (InterruptedException telleExcp)
		{telleExcp.printStackTrace();}
		}
		cg.syncWait();
		for(sonDebDessin=(saLargeur/3)*2;sonDebDessin> saLargeur/3;sonDebDessin-=sonPas ){
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			{telleExcp.printStackTrace();}
		}
		cg.syncSignal();
		for(sonDebDessin=saLargeur/3;sonDebDessin> sonPas;sonDebDessin-=sonPas ){
			repaint();
			try{Thread.sleep(sonTemps);}
			catch (InterruptedException telleExcp)
			{telleExcp.printStackTrace();}
		}
	}


    public void paintComponent(Graphics telCG)
    {
	super.paintComponent(telCG);
	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}