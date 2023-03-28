package Threads;

import model.Grafo;

public class GrafoManangerThread implements Runnable {
	
	private Grafo grafo;
	
	public GrafoManangerThread(Grafo grafo) {
		this.grafo = grafo;
	}
	
	@Override
	public void run() {
		grafo.addAresta(grafo.getVertice(101), grafo.getVertice(102));
		grafo.addAresta(grafo.getVertice(102), grafo.getVertice(101));
		grafo.addAresta(grafo.getVertice(102), grafo.getVertice(103));
		grafo.addAresta(grafo.getVertice(102), grafo.getVertice(201));
		grafo.addAresta(grafo.getVertice(102), grafo.getVertice(202));

		grafo.addAresta(grafo.getVertice(103), grafo.getVertice(102));
		grafo.addAresta(grafo.getVertice(103), grafo.getVertice(104));
		grafo.addAresta(grafo.getVertice(103), grafo.getVertice(202));
		grafo.addAresta(grafo.getVertice(103), grafo.getVertice(203));
		grafo.addAresta(grafo.getVertice(103), grafo.getVertice(204));

		grafo.addAresta(grafo.getVertice(104), grafo.getVertice(103));
		grafo.addAresta(grafo.getVertice(104), grafo.getVertice(203));
		grafo.addAresta(grafo.getVertice(104), grafo.getVertice(204));

		grafo.addAresta(grafo.getVertice(201), grafo.getVertice(102));
		grafo.addAresta(grafo.getVertice(201), grafo.getVertice(202));

		grafo.addAresta(grafo.getVertice(202), grafo.getVertice(102));
		grafo.addAresta(grafo.getVertice(202), grafo.getVertice(103));
		grafo.addAresta(grafo.getVertice(202), grafo.getVertice(201));
		grafo.addAresta(grafo.getVertice(202), grafo.getVertice(203));

		grafo.addAresta(grafo.getVertice(203), grafo.getVertice(103));
		grafo.addAresta(grafo.getVertice(203), grafo.getVertice(104));
		grafo.addAresta(grafo.getVertice(203), grafo.getVertice(202));
		grafo.addAresta(grafo.getVertice(203), grafo.getVertice(204));

		grafo.addAresta(grafo.getVertice(204), grafo.getVertice(103));
		grafo.addAresta(grafo.getVertice(204), grafo.getVertice(104));
		grafo.addAresta(grafo.getVertice(204), grafo.getVertice(203));

		System.out.println(grafo);
		
	}

}
