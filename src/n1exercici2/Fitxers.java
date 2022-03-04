package n1exercici2;

import java.io.File;
import java.util.Date;

public class Fitxers {
	
	static int space = 0;
	
	public static void main(String[] args) {
		readDirectory("Fitxers");
	}
	
	public static void readDirectory(String path) {
		File directori = new File(path);
		
		for (String stringFitxer : directori.list()) {
			File subDirectori = new File(directori.getAbsolutePath(), stringFitxer);
			
			if (subDirectori.isDirectory()) {
				for (int i = 0; i < space; i++) {
					System.out.print("	");
				}
				space++;
				System.out.println("Directori : " + stringFitxer + "	(" + new Date(subDirectori.lastModified()) + ")");
				readDirectory(subDirectori.getAbsolutePath());
			}
			else {
				for (int i = 0; i < space; i++) {
					System.out.print("	");
				}
				System.out.println("Fitxer : " + stringFitxer + "	(" + new Date(subDirectori.lastModified()) + ")");
			}
		}
		space--;
	}
}
