package no.hvl.dat100.jplab11.oppgave2;

public class Bilde extends Tekst {

	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id,bruker,dato,tekst);
		this.url=url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id,bruker,dato,likes,tekst);
		this.url=url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url=url;
	}

	@Override
	public String toString() {
		return "BILDE"+super.toString().substring(5)+url+"\n";
	}

	public String toHTML() {
		String ret = super.toHTML().substring(0,super.toHTML().length()-8);
		ret += "\n\t\t<iframe src=\""+url+"\" height=600 width=800></iframe><hr>\n";
		
		return ret;		
	}
}
