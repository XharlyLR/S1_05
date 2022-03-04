package n1exercici4;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
		readText(ruta.getAbsolutePath());
	}
	
	private static void readText(String rutaPath) {
			try {
				FileReader llegeixText = new FileReader(rutaPath);
				
				int r = 0;
				while (r != -1) {
					r = llegeixText.read();
					
					char letra = (char) r;
					
					if(r != -1)
						System.out.print(letra);
				}
				
				llegeixText.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	private static void writeText(String rutaPath) {
		try {
			FileWriter escriuText = new FileWriter(rutaPath);
			Iterator<String> it = contingutStrings.iterator();
			
			while (it.hasNext()) {
				String string = it.next();
				
				for (int i = 0; i < string.length(); i++) {
					escriuText.write(string.charAt(i));
				}
				
				if(it.hasNext())
					escriuText.write("\n");
			}
			
//			for (String string : contingutStrings) {
//				for (int i = 0; i < string.length(); i++) {
//					escriuText.write(string.charAt(i));
//				}
//				
//				if (it.hasNext()) {
//					it.next();
//					escriuText.write("\n");
//				}
//			}
			
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
				}
				
				space++;

				contingutText += "Directori : " + stringFitxer + "	(" + new Date(subDirectori.lastModified()) + ")";
				
				contingutStrings.add(contingutText);
				
				readDirectory(subDirectori.getAbsolutePath());
			}
			else {
				for (int i = 0; i < space; i++) {
					contingutText += "	";
				}
				
				contingutText += "Fitxer : " + stringFitxer + "	(" + new Date(subDirectori.lastModified()) + ")";
				
				contingutStrings.add(contingutText);
			}
		}
		space--;
	}
}
