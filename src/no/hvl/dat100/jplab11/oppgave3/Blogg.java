package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++)
			if (innlegg.erLik(innleggtabell[i]))
				return i;
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++)
			if (innlegg.erLik(innleggtabell[i]))
				return true;
		return false;
	}

	public boolean ledigPlass() {
		if (innleggtabell.length == nesteledig)
			return false;
		return true;
	}

	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg) || !ledigPlass())
			return false;
		innleggtabell[nesteledig] = innlegg;
		nesteledig++;
		return true;
	}

	public String toString() {
		String ret = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++)
			ret = ret + innleggtabell[i].toString();
		return ret;
	}

	public void utvid() {
		Innlegg[] newtab = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < innleggtabell.length; i++)
			newtab[i] = innleggtabell[i];
		innleggtabell = newtab;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (finnes(innlegg))
			return false;
		else if (!ledigPlass())
			utvid();
		leggTil(innlegg);
		return true;
	}

	public boolean slett(Innlegg innlegg) {
		int id = finnInnlegg(innlegg);
		if (id == -1)
			return false;
		innleggtabell[id] = innleggtabell[nesteledig - 1];
		nesteledig--;
		return true;
	}

	public int[] search(String keyword) {
		
		int antallTreff = 0;
		for (Innlegg i : innleggtabell) {
			if (i instanceof Tekst)
				if (((Tekst) i).getTekst().indexOf(keyword) != -1)
					antallTreff++;
		}
		int[] ret = new int[antallTreff];
		
		antallTreff=0;
		for (int i =0;antallTreff<ret.length&&i<innleggtabell.length;i++)
			if (((Tekst)innleggtabell[i]).getTekst().indexOf(keyword) != -1) {
				ret[antallTreff]=innleggtabell[i].getId();
				antallTreff++;
			}
		return ret;
	}
}