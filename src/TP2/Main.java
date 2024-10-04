package TP2;

import java.io.*;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.lang.String;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Affichage TA = new Affichage("AAA");
		Affichage TB = new Affichage("BB");
		Affichage TC = new Affichage("CCCCCCCCCCCCC");
		Affichage TD = new Affichage("DDDDD");
		TB.start();

		TA.start();
		TC.start();
		TD.start();
	}

}
