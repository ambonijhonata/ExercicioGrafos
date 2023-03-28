package application;

import java.io.File;

import Threads.FileManangerThread;
import Threads.GrafoManangerThread;
import model.Grafo;

public class Main {

	public static void main(String[] args) {
		File file = new File(System.getProperty("user.dir") + "\\configs.txt");
		Grafo grafo = new Grafo();
		
		Thread lerArquivo = new Thread(new FileManangerThread(file, grafo));
		lerArquivo.start();

		try {
			lerArquivo.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		Thread criarListaAdjascencia = new Thread(new GrafoManangerThread(grafo));
		criarListaAdjascencia.start();
	}

}
