package Threads;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import model.Grafo;

public class FileManangerThread implements Runnable {

	private File file;
	private Grafo grafo;

	public FileManangerThread(File file, Grafo grafo) {
		this.file = file;
		this.grafo = grafo;
	}

	public void run() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			int contRepetidos = 0;
			int contNegativos = 0;
			int contLinhaErros = 0;

			try (OutputStream os = new FileOutputStream("c:\\a\\saida.txt");
					BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os))) {

				while ((line = bufferedReader.readLine()) != null) {
					contLinhaErros++;

					if (Integer.parseInt(line) < 0) {
						contNegativos++;
						br.write("Valor negativo na linha: " + contLinhaErros + "\n");
						continue;
					}

					if ((grafo.addVertice(Integer.parseInt(line)) == false)) {
						contRepetidos++;
						br.write("Valor duplicado na linha: " + contLinhaErros + "\n");
						continue;
					}
				}

				br.write("Valores repetidos: " + contRepetidos);
				br.newLine();
				br.write("Valores negativos: " + contNegativos);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
