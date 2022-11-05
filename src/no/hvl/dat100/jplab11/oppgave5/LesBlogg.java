package no.hvl.dat100.jplab11.oppgave5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class LesBlogg {
	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Blogg blogg = null;
		String klasse;
		int id;
		String bruker;
		String dato;
		int likes;
		String tekst="";
		String url;
		String temp;
		
//		scanner.nextint funket ikke - den etterlot seg newlines som forkludret innlesing av andre linjer
//		Jeg endte opp med masse looper og sånn, fordi jeg ville at metoden skulle kunne håndtere blogginnlegg
//		med 'tekst' variabel over 1 linje.
		
		try {
			Scanner leser = new Scanner(new FileReader(mappe + "\\" + filnavn));
			int antall = Integer.parseInt(leser.nextLine());
			blogg = new Blogg(antall);
			klasse = leser.nextLine();
			for (int i = 0; i < antall; i++) {
				if (klasse.equals(TEKST)) {
					temp="";
					tekst="";
					id = Integer.parseInt(leser.nextLine());
					bruker = leser.nextLine();
					dato = leser.nextLine();
					likes = Integer.parseInt(leser.nextLine());
					while (leser.hasNext()&&!temp.equals(TEKST)&&!temp.equals(BILDE)) {
						tekst=tekst+temp;
						temp=leser.nextLine();
						if (!temp.equals(TEKST)&&!temp.equals(BILDE))
							temp=temp+"\n";
						if (temp.equals(BILDE)||temp.equals(TEKST))
							klasse=temp;
					}	
					tekst=tekst.substring(0, tekst.length()-1); 
					blogg.leggTilUtvid(new Tekst(id, bruker, dato, likes, tekst));
				} else if (klasse.equals(BILDE)) {
					temp="";
					tekst="";
					id = Integer.parseInt(leser.nextLine());
					bruker = leser.nextLine();
					dato = leser.nextLine();
					likes = Integer.parseInt(leser.nextLine());
					while (leser.hasNext()&&!temp.equals(TEKST)&&!temp.equals(BILDE)) {
						tekst=tekst+temp;
						temp=leser.nextLine();	
						if (temp.length()>=4&&temp.substring(0, 4).equals("http"))
							break;
						if (!temp.equals(TEKST)&&!temp.equals(BILDE))
							temp=temp+"\n";
					}
					tekst=tekst.substring(0, tekst.length()-1);
					url = temp;
					if (leser.hasNext())
					klasse=leser.nextLine();
					blogg.leggTilUtvid(new Bilde(id, bruker, dato, likes, tekst, url));
				}
			}
			leser.close();
		} catch (FileNotFoundException e) {
			System.out.println("Vi fant ingen fil " + filnavn);
			e.printStackTrace();
		}
		return blogg;
	}	
}