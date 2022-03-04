package n1exercici3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Fitxers {
	
	static int space = 0;
	static ArrayList<String> contingutStrings = new ArrayList<String>();
	
	public static void main(String[] args) {
		File ruta = new File("ExerciciText.txt");
		
		try {
			ruta.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		readDirectory("Fitxers");
		
		writeText(ruta.getAbsolutePath());
	}

	private static void writeText(String rutaPath) {
		try {
			FileWriter escriuText = new FileWriter(rutaPath);
			
			for (String string : contingutStrings) {
				for (int i = 0; i < string.length(); i++) {
					escriuText.write(string.charAt(i));
				}
				escriuText.write("\n");
			}
			
			escriuText.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readDirectory(String path) {
		File directori = new File(path);
		
		for (String stringFitxer : directori.list()) {
			File subDirectori = new File(directori.getAbsolutePath(), stringFitxer);
			
			String contingutText = "";
			
			if (subDirectori.isDirectory()) {
				for (int i = 0; i < space; i++) {
					contingutText += "	";
					System.out.print("	");
				}
				
				space++;

				contingutText += "Directori : " + stringFitxer + "	(" + new Date(subDirectori.lastModified()) + ")";
				System.out.println("Directori : " + stringFitxer + "	(" + new Date(subDirectori.lastModified()) + ")");
				
				contingutStrings.add(contingutText);
				
				readDirectory(subDirectori.getAbsolutePath());
			}
			else {
				for (int i = 0; i < space; i++) {
					contingutText += "	";
					System.out.print("	");
				}
				
				contingutText += "Fitxer : " + stringFitxer + "	(" + new Date(subDirectori.lastModified()) + ")";
				System.out.println("Fitxer : " + stringFitxer + "	(" + new Date(subDirectori.lastModified()) + ")");
				
				contingutStrings.add(contingutText);
			}
		}
		space--;
	}
}
