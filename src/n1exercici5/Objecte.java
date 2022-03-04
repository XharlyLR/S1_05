package n1exercici5;

import java.io.Serializable;

public class Objecte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int v1 = 0;
	private String v2;
	
	public Objecte (int v1, String v2) {
		this.v1 = v1;
		this.v2 = v2;
	}
	
	
	public String toString() {
		
		return "Variable 1: " + v1 + ", variable 2: " + v2;
	}

}
