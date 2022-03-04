package n1exercici5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {

		Objecte miObjecte = new Objecte(10, "Hola");
		
		System.out.println(miObjecte.toString());
		
		try {
			ObjectOutputStream serialitzaObj = new ObjectOutputStream(new FileOutputStream("objecte.ser"));
			
			serialitzaObj.writeObject(miObjecte);
			
			serialitzaObj.close();
			
			ObjectInputStream deserialitzaObj = new ObjectInputStream(new FileInputStream("objecte.ser"));
			
			Objecte miObjecteRecuperat = (Objecte) deserialitzaObj.readObject();
			
			deserialitzaObj.close();
			
			System.out.println(miObjecteRecuperat.toString());
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
