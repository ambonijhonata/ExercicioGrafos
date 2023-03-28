package model;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
	List<Vertice> vertices;
	List<Aresta> arestas;

	public Grafo() {
		vertices = new ArrayList<Vertice>();
		arestas = new ArrayList<Aresta>();
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
			}

		}

		return representacao.toString();
	}
}
