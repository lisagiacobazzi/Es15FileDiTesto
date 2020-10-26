package Es15FileDiTesto;

import java.util.Scanner;
import java.io.*;

public class MainClass{
	public static void main(String[] args) 
		throws IOException {
		
		//INIZIO LETTURA DA CONSOLE
		Scanner tastiera = new Scanner (System.in); 	//Invece di Scanner avrei potuto usare BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in)); tastiera.readLine();
		String[] riga = new String[100];
		int i=0;
		
		System.out.println("Cosa vuoi scrivere?");
		while (i<3) {									//Dovrei far leggere fino a riga vuota, ma tastiera.hasNextLine() non da mai false(?)
			riga[i] = tastiera.nextLine();
			i++;
		}
		//FINE LETTURA DA CONSOLE
		
		//INIZIO SCRITTURA SU FILE
		String nomeFile;
		System.out.println("Come si chiama il file?");
		nomeFile = tastiera.next();
		FileWriter fw = new FileWriter (nomeFile);
		PrintWriter outFile = new PrintWriter(fw);
		
		for(int j=0;j<i;j++) {
			outFile.println(riga[j]);
		}
		
		outFile.close();
		//FINE SCRITTURA SU FILE
		
		//LETTURA DA FILE
		FileReader reader = new FileReader(nomeFile);
		Scanner in = new Scanner(reader);
		
		while(in.hasNextLine()) {
			String rigaLetta = in.nextLine();
			System.out.println(rigaLetta);
		}
		
		tastiera.close();
		reader.close();
		in.close();
	}
}
