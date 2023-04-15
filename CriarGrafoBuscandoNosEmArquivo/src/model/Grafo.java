package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Grafo {
	List<Vertice> vertices;
	List<Aresta> arestas;
	private List<Integer> valoresDesejados = Arrays.asList(101, 102, 103, 104, 201, 202, 203, 204);
	private List<String> conexoes = Arrays.asList("101 -> [102] -> [/]",
			"102 -> [101] -> [103] -> [201] -> [202] -> [/]", "103 -> [102] -> [104] -> [202] -> [203] -> [204] -> [/]",
			"104 -> [103] -> [203] -> [204] -> [/]", "201 -> [102] -> [202] -> [/]",
			"202 -> [102] -> [103] -> [201] -> [203] -> [/]", "203 -> [103] -> [104] -> [202] -> [204] -> [/]",
			"204 -> [103] -> [104] -> [203] -> [/]");

	public Grafo(File file) {		
		vertices = new ArrayList<Vertice>();
		arestas = new ArrayList<Aresta>();		
		lerArquivo(file);
		criarGrafo();
	}

	public boolean addVertice(final int valor) {
		if (vertices.contains(new Vertice(valor))) {
			return false;
		}
		return vertices.add(new Vertice(valor));
	}

	public Aresta addAresta(final Vertice origem, final Vertice destino) {
		Aresta aresta = new Aresta(origem, destino);
		origem.addAjd(aresta);
		arestas.add(aresta);

		return aresta;
	}

	public Vertice getVertice(int valor) {
		for (Vertice v : vertices) {
			if (v.getValor() == valor) {
				return v;
			}
		}

		return null;
	}

	public void printVertices() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.println(vertices.get(i));
		}
	}

	/*
	 * percorre a lista dos vertices do grafo, se encontrar o vértice na lista de
	 * desejados, remove
	 */
	public void removerVerticesInuteis() {
		Iterator<Vertice> iter = vertices.iterator();
		while (iter.hasNext()) {
			if (!valoresDesejados.contains(iter.next().getValor())) {
				iter.remove();
			}
		}
	}

	public void criarGrafo() {
		removerVerticesInuteis();
		for (int i = 0; i < vertices.size(); i++) {
			String[] tokens = conexoes.get(i).split(" -> ");
			int aux = 1;
			Aresta aresta;
			while (!tokens[aux].equals("[/]")) {
				aresta = new Aresta(vertices.get(i), getVertice(Integer.parseInt(tokens[aux].substring(1, 4))));
				arestas.add(aresta);
				vertices.get(i).addAjd(aresta);
				aux++;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder representacao = new StringBuilder();

		for (int i = 0; i < vertices.size(); i++) {
			ArrayList<Aresta> listaAresta = (ArrayList<Aresta>) vertices.get(i).adj;
			if (!listaAresta.isEmpty()) {
				representacao.append(vertices.get(i).getValor() + " -> ");
				for (Aresta a : listaAresta) {
					representacao.append("[" + a.getDestino() + "]");
					representacao.append(" -> ");
				}
				representacao.append("[/]");
				representacao.append("\n");
				// System.out.println(representacao);
			}

		}

		return representacao.toString();
	}
	
	public void lerArquivo(File file) {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			int contValidos = 0;
			int contRepetidos = 0;
			int contNegativos = 0;
			int contLinha = 0;

			try (OutputStream os = new FileOutputStream("c:\\a\\saida.txt");
					BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os))) {

				line = bufferedReader.readLine();// pula a primeira linha
				while (!(line = bufferedReader.readLine()).equals("Linha35: TRAILER33")) {
					line = line.substring(line.indexOf(":") + 1).trim();
					boolean isVerticeValido = this.addVertice(Integer.parseInt(line));
					contLinha++;

					if (Integer.parseInt(line) < 0) {
						contNegativos++;
						br.write("Valor negativo na linha: " + contLinha + "\n");
						continue;
					}

					if (!isVerticeValido) {
						contRepetidos++;
						br.write("Valor duplicado na linha: " + contLinha + "\n");
						continue;
					}

					contValidos++;
				}

				br.write("Valores repetidos: " + contRepetidos);
				br.newLine();
				br.write("Valores negativos: " + contNegativos);
				br.newLine();
				br.write("Valores validos: " + contValidos);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
