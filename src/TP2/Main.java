package TP2;

import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CemaphoreBinaire cb = new CemaphoreBinaire(1);
		Affichage TA = new Affichage("AAA",cb);
		Affichage TB = new Affichage("BB",cb);
		Affichage TC = new Affichage("CCCCCCCCCCCCC",cb);
		Affichage TD = new Affichage("DDDDD",cb);
		TB.start();

		TA.start();
		TC.start();
		TD.start();

	}

}
