package no.hvl.dat100.jplab11.oppgave7;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;
import no.hvl.dat100.jplab11.oppgave6.HtmlBlogg;

public class BloggApp {

	public static String toHTML() {

		Tekst innlegg1 = new Tekst(1, "Sven-Olai", "23-10",
				"Lars, hva er status for den siste obligatoriske innleveringen?\n"
				+ "Ny setning\n"
				+ "Ny setning");
		Bilde innlegg2 = new Bilde(2, "Lars", "24-10",
				"Ser bra ut! - har lagt ved output-eksempel fra enhetstester\nNy setning\nNy setning",
				"https://home.hvl.no/ansatte/lmkr/dat100/junitscreenshot.png");

		Tekst innlegg3 = new Tekst(3, "Sven-Olai", "23-10",
				"Lars, hva er status for den siste obligatoriske innleveringen?\nNy setning\nNy setning");
		Bilde innlegg4 = new Bilde(4, "Lars", "24-10",
				"Ser bra ut! - har lagt ved output-eksempel fra enhetstester\n"
				+ "Ny setning\n"
				+ "Ny setning",
				"https://media-cldnry.s-nbcnews.com/image/upload/t_fit-560w,f_auto,q_auto:best/streams/2013/June/130617/6C7911377-tdy-130617-leo-toasts-1.jpg");
		
		innlegg1.doLike();
		innlegg1.doLike();
		innlegg2.doLike();

		HtmlBlogg samling = new HtmlBlogg();

		samling.leggTil(innlegg1);
		samling.leggTil(innlegg2);
		samling.leggTil(innlegg3);
		samling.leggTil(innlegg4);

		
		return samling.toString();
	}

	private ServerSocket welcomeSocket;

	public BloggApp(ServerSocket welcomeSocket) {
		this.welcomeSocket = welcomeSocket;
	}

	public void process() {

		try {

			System.out.println("SERVER ACCEPTING");

			Socket connectionSocket = welcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			String text = inFromClient.readLine();

			System.out.println("SERVER RECEIVED: " + text);

			String htmlbody = toHTML();

			String header = "HTTP/1.1 200 OK\n" + "Server: DAT100 HTTP Server : 1.0\n" + "Date: " + (new Date()) + "\n"
					+ "Content-type: " + "text/html" + "\n" + "Content-length: " + htmlbody.length() + "\n" + "\n";

			String outtext = header + htmlbody;

			System.out.println("SERVER SENDING: " + outtext);

			outToClient.write(outtext.getBytes());
			outToClient.flush();

			outToClient.close();
			inFromClient.close();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
			}
			connectionSocket.close();

		} catch (IOException ex) {

			System.out.println("TCPServer: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);

		}
	}
}
