package no.hvl.dat100.jplab11.oppgave2;

import java.util.Scanner;

import no.hvl.dat100.jplab11.oppgave1.Innlegg;

public class Tekst extends Innlegg {

	private String tekst; 
	
	public Tekst () {
		
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		super(id, bruker, dato,0);
		this.tekst=tekst;
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id,bruker,dato,likes);
		this.tekst=tekst;
	}
	
	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst=tekst;
	}

	@Override
	public String toString() {
		return "TEKST\n"+super.toString()+tekst+"\n";
	}
	
	// Jeg så for meg at et innlegg kan ha flere linjer med 'tekst'
	public String toHTML() {
		String ret=super.toHTML();
		Scanner linjeparser = new Scanner(tekst);
		while (linjeparser.hasNext()) {
			ret += "\t\t<p>"+linjeparser.nextLine()+"</p>\n";
		}
		linjeparser.close();
		ret=ret+"\t\t<hr>\n";
		return ret;		
	}
}
