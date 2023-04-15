package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertice {
	private int valor;
	List<Aresta> adj;

	public Vertice(int valor) {
		this.valor = valor;
		this.adj = new ArrayList<Aresta>();
	}

	public void addAjd(Aresta aresta) {
		adj.add(aresta);
	}

	public Integer getValor() {
		return valor;
	}	
	
	public List<Aresta> retornaListaAjascencia(){
		return adj;
	}
	
	@Override
	public String toString() {
		return String.valueOf(valor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		return valor == other.valor;
	}

}
