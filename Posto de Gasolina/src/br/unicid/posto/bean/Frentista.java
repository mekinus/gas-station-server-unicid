package br.unicid.posto.bean;

public class Frentista {
	
	
	private String nomeFrentista;
	private float salarioFrentista;
	
	public Frentista(String nomeFrentista, float salarioFrentista) {
		super();
		this.nomeFrentista = nomeFrentista;
		this.salarioFrentista = salarioFrentista;
	
	}
	
	public Frentista() {
		super();
	}
	
	public String getNomeFrentista() 
	{
		return nomeFrentista;
	}
	
	public void setNomeFrentista(String nomeFrentista) 
	{
		this.nomeFrentista = nomeFrentista;
	}

	public float getSalarioFrentista() {
		return salarioFrentista;
	}
	
	public void setSalarioFrentista(int salarioFrentista) {
		this.salarioFrentista = salarioFrentista;
	}


}
