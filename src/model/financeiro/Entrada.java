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
	public void efetuarTransacao(double valor, String sacado, String descricaoTransacao) {
		setValorTransacao(valor);;
		setSacado(sacado);
		setDescricaoTransacao(descricaoTransacao);
	}

	@Override
	public String toString() {
		
		String dados = "";
		dados += "\nSacado: " + this.sacado;
		
		return dados + super.toString();
	}

	

}
