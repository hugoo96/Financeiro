package model.financeiro;

public abstract class Financeiro {
	
	private int codigoTransacao;
	private String descricaoTransacao;
	protected double valorTransacao;
	
	public int getCodigoTransacao() {
		return codigoTransacao;
	}
	
	public void setCodigoTransacao(int codigoTransacao) {
		this.codigoTransacao = codigoTransacao;
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

	
	public abstract void efetuarTransacao(double valor, String identificacao);

	@Override
	public String toString() {
		
		String dados = "";
		dados += "\nCódigo: "+ this.codigoTransacao;
		dados += "\nDescrição: "+ this.descricaoTransacao;
		dados += "\nValor: "+ this.valorTransacao;
		dados += "\n=========================";
		
		return dados;
	}

	

}	