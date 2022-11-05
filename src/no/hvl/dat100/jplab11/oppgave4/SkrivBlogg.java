package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		
		//Her er det noe tull, siden min fil 'blogg' kjører Unix(lf), 
		//mens fil 'bloggkorrekt' kjører Windows (CRLF). 
		//Jeg forsøkte å legge til \r i toString, men da passerte jeg ikke unittestene  pga formatfeil.

		try {
			PrintWriter skriver = new PrintWriter(new FileWriter(mappe+"\\"+filnavn));
			skriver.println(samling.toString());
			skriver.close();
			return true;
		}catch(IOException e) {
			System.out.println("Noe gikk galt med skriving av fil");
			e.printStackTrace();
		};
		return false;
	}
}
