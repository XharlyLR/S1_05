package n1exercici1;

import java.io.File;
import java.util.Iterator;
import java.util.TreeSet;

public class Fitxers {
	
	public static void main(String[] args) {
		readDirectory();
	}
	
	public static void readDirectory() {
		
		File directori = new File("Fitxers");
		
		TreeSet<String> fitxersNoms = new TreeSet<>();
		
		for (String string : directori.list()) {
			fitxersNoms.add(string);
		}
		
		Iterator<String> it = fitxersNoms.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
