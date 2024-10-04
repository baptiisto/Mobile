package TP2;

public final class CemaphoreBinaire extends Cemaphore {
public CemaphoreBinaire(int valeurInitiale){
	// SemaphoreBinaire est une classe concréte. Constructeur possédant une valeur initalie
	super((valeurInitiale != 0) ? 1:0);  // Ca équivaut un if else
	//System.out.print(valeurInitiale);
}
public final synchronized void syncSignal(){
	super.syncSignal();
	//System.out.print(valeur);
	if (valeur>1) valeur = 1;
}
}

