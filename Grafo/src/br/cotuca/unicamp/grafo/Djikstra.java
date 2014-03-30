package br.cotuca.unicamp.grafo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;


public class Djikstra {
	 
	  /**
	   * Calcula a menor rota entre a origem e o destino.
	   * 
	   * @param caminhoPercorrido
	   *            O caminho percorrido at� aqui
	   * @return O custo total do caminho percorrido.
	   */
	  public static Double calcularMenorCaminho(Cidade origem, Cidade destino, List<Cidade> caminhoPercorrido) 
	  {
		  Double menor = Double.POSITIVE_INFINITY;
		  Double custo = 0.0;
		  
		  // Adiciona a origem ao caminho percorrido
		  caminhoPercorrido.add(origem);
	 
		  // Se a origem for igual ao destino, encerra a busca
		  if (origem.equals(destino)) 
		  {
			  return custo;
		  }
	 
		  // Armazena o caminho percorrido at� aqui
		  List<Cidade> caminhoAnterior = new ArrayList<Cidade>(caminhoPercorrido);
		  List<Cidade> caminho = null;
		  // Verifica cada caminho poss�vel
		  for (Entry<Cidade, Double> proximoCidade : origem.getProximosCidade().entrySet()) 
		  {
			  // Inicia o novo caminho
			  caminho = new ArrayList<Cidade>(caminhoAnterior);
	 
			  // Define o custo do caminho como infinito, pois ainda
			  // n�o se sabe se ele leva ao destino desejado
			  custo = Double.POSITIVE_INFINITY;
	 
			  // Percorre o caminho a partir do pr�ximo nodo, desde 
			  // que este n�o tenha sido percorrido
			  if (!caminho.contains(proximoCidade.getKey())) 
			  {
				  custo = proximoCidade.getValue() + calcularMenorCaminho(proximoCidade.getKey(), destino, caminho);
			  }
	 
			  // Verifica se o caminho percorrido � melhor 
			  // que o anterior
			  if (custo < menor) 
			  {
	       
				  menor = custo;
				  
				  // Atualiza o melhor caminho
				  caminhoPercorrido.clear();
				  caminhoPercorrido.addAll(caminho);
			  }
		  }
	 
		  return menor;
	  }
}