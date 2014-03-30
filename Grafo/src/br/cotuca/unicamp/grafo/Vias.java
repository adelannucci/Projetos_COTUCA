package br.cotuca.unicamp.grafo;

import java.util.ArrayList;
import java.util.List;

public class Vias {
	
	private Cidade cidade1;
	private Cidade cidade2;
	private double distancia;
	private boolean existe;
	private boolean passar;

	public Vias()
	{
		this.setExiste(false);
	}
	
	public Vias(Cidade cidade1, Cidade cidade2) {
		super();
		this.cidade1 = cidade1;
		this.cidade2 = cidade2;
		this.distancia = this.cidade1.proximaCidade(this.cidade2);
		this.setExiste(true);
		this.setPassar(false);
	}
	
	public Vias(Cidade cidade1, Cidade cidade2, boolean passar) {
		super();
		this.cidade1 = cidade1;
		this.cidade2 = cidade2;
		this.distancia = this.cidade1.proximaCidade(this.cidade2);
		this.setExiste(true);
		this.setPassar(passar);
	}
	
	public Cidade getCidade1() {
		return cidade1;
	}
	public void setCidade1(Cidade cidade1) {
		this.cidade1 = cidade1;
	}
	public Cidade getCidade2() {
		return cidade2;
	}
	public void setCidade2(Cidade cidade2) {
		this.cidade2 = cidade2;
	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public double getDistancia() {
		return distancia;
	}

	public boolean isPassar() {
		return passar;
	}

	public void setPassar(boolean passar) {
		this.passar = passar;
	}
	
	
	
	
}
