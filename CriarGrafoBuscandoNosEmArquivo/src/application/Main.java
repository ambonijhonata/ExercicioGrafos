package application;

import java.io.File;

import model.Grafo;

public class Main {

	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir") + "\\configs.txt");
		Grafo grafo = new Grafo(file);				
		
		System.out.println(grafo);					
	}

}
