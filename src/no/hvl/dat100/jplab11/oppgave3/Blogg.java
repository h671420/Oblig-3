package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig=0;
		//throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig=0;
		//throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public int getAntall() {
		return nesteledig;
		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
		//throw new UnsupportedOperationException(TODO.method());

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i=0;i<nesteledig;i++)
			if (innlegg.erLik(innleggtabell[i]))
				return i;
		return -1;
		//throw new UnsupportedOperationException(TODO.method());
	}

	public boolean finnes(Innlegg innlegg) {
		for (int i=0;i<nesteledig;i++)
			if (innlegg.erLik(innleggtabell[i]))
				return true;
		return false;
		//throw new UnsupportedOperationException(TODO.method());
	}

	public boolean ledigPlass() {
		if (innleggtabell.length==nesteledig)
			return false;
		return true;
		//throw new UnsupportedOperationException(TODO.method());

	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg))
			return false;
		innleggtabell[nesteledig]=innlegg;
		nesteledig++;
		return true;	
		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public String toString() {
		String ret =nesteledig+"\n";
		for (int i=0;i<nesteledig;i++)
			ret=ret+innleggtabell[i].toString();
		return ret;
		//throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}