package model.financeiro;

public class Saida extends Financeiro{
	
	private String cedente;

	public String getCedente() {
		return cedente;
	}

	public void setCedente(String cedente) {
		this.cedente = cedente;
	}

	@Override
	public void efetuarTransacao(double valor, String cedente) {
		this.valorTransacao = valor;
		this.cedente = cedente;
	}

	@Override
	public String toString() {
		
		String dados = "";
		dados += "Saída";
		dados += "\nCedente: " + this.cedente;
		
		return dados + super.toString();
	}

	

}
