package br.unicid.posto.bean;

public class Bomba {
    
	private float valor;
	private float quantidadeDeCombustivel;
	private int numero;
	
	
	public Bomba(int numero,float quantidadeDeCombustivel, float valor) {
		
		super();
		this.numero = numero;
		this.quantidadeDeCombustivel = quantidadeDeCombustivel;
		this.valor = valor;
		
	}
	
	public Bomba() {
		super();
	}

	public float getQuantidadeDeCombustivel() {
		return quantidadeDeCombustivel;
	}

	public void setQuantidadeDeCombustivel(float quantidadeDeCombustivel) {
		this.quantidadeDeCombustivel = quantidadeDeCombustivel;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
