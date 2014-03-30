package br.cotuca.unicamp.grafo;

import java.util.HashMap;
import java.util.Map;

/**
 * Define os atributos de cada ponto no grafo e os possíveis
 * caminhos de saída de cada ponto
 */
class Cidade {
 
  private String nome;
  private int id;
  private int x;
  private int y;
  
private Map<Cidade, Double> proximosVertices = new HashMap<Cidade, Double>();
 
  public Cidade(String nome, int x, int y, int id) {
    super();
    this.id = id;
    this.x = x;
    this.y = y;
    this.nome = nome;
  }
 
  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof Cidade) {
    	Cidade objCidade = (Cidade) obj;
 
      return (this.nome == null && objCidade.nome == null)
            || this.nome.equals(objCidade.nome);
    }
 
    return false;
  }
 
  	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
  
  public String getNome() {
    return nome;
  }
 
  
  public double proximaCidade(Cidade c)
  {
	  double distancia = Math.sqrt( Math.pow( (this.x - c.getX()),2 ) + Math.pow( (this.y - c.getY()),2 ) );
	  this.getProximosCidade().put(c, distancia);
	  return distancia;
  }
  
  public Map<Cidade, Double> getProximosCidade() {
    return proximosVertices;
  }
 
  @Override
  public int hashCode() {
    return nome != null ? nome.hashCode() : 0;
  }
 
  @Override
  public String toString() {
    return nome;
  }

  public int getId() {
	return id;
  }
	  
  
}
