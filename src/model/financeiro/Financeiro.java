package model.financeiro;

public abstract class Financeiro {
	
	private long id;
	private String descricaoTransacao;
	protected double valorTransacao;
	
	public long getID() {
		return id;
	}
	
	public void setID(long id) {
		this.id = id;
	}
	
	public String getDescricaoTransacao() {
		return descricaoTransacao;
	}
	
	public void setDescricaoTransacao(String descricaoTransacao) {
		this.descricaoTransacao = descricaoTransacao;
	}
	
	public double getValorTransacao() {
		return valorTransacao;
	}
	
	public void setValorTransacao(double valorTransacao) {
		this.valorTransacao = valorTransacao;
	}
	
	//identificacao - sacado, cedente ou investimento, atributos especificos das classes filhas
	public abstract void efetuarTransacao(double valor, String identificacao, String descricao);

	@Override
	public String toString() {
		
		String dados = "";
		dados += "\nID: "+ this.id;
		dados += "\nDescrição: "+ this.descricaoTransacao;
		dados += "\nValor: "+ this.valorTransacao;
		dados += "\n=========================";
		
		return dados;
	}

	

}	