package TP2;

public abstract class Cemaphore {

    protected int valeur=0;

    protected Cemaphore(int valeurInitiale){
	valeur = valeurInitiale>0 ? valeurInitiale:0;
    }

    public synchronized void syncWait(){
	try {
	    while(valeur<=0){ // si la valeur est inférieure ou égale à zéro , on fait wait
		wait();
        }
	    valeur--;
	} catch(InterruptedException e){}
    }

    public synchronized void syncSignal(){
	if(++valeur > 0) notifyAll();
    }
}
