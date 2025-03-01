package no.hvl.dat100.jplab11.oppgave6;

import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		String ret = HTMLPREFIX;
		for (int i=0;i<getAntall();i++)
			ret = ret+getSamling()[i].toHTML();
		//System.out.println(getSamling()[i].toHTML());
		ret = ret+HTMLPOSTFIX;
		return ret;
		
	}
}
