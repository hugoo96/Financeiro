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
	public void efetuarTransacao(double valor, String cedente, String descricao) {
		setValorTransacao(valor);
		setCedente(cedente);
		setDescricaoTransacao(descricao);
	}

	@Override
	public String toString() {
		
		String dados = "";
		dados += "Saída";
		dados += "\nCedente: " + this.cedente;
		
		return dados + super.toString();
	}

	

}
