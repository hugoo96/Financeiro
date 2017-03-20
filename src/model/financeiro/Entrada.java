package model.financeiro;

public class Entrada extends Financeiro{
	
	private String sacado;

	public String getSacado() {
		return sacado;
	}

	public void setSacado(String sacado) {
		this.sacado = sacado;
	}
	
	@Override
	public void efetuarTransacao(double valor, String sacado) {
		this.valorTransacao = valor;
		this.sacado = sacado;
		
	}

	@Override
	public String toString() {
		
		String dados = "";
		dados += "Entrada";
		dados += "\nSacado: " + this.sacado;
		
		return dados + super.toString();
	}

	

}
