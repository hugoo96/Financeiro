package model.financeiro;

public class Investimento extends Financeiro{

	private String setorBeneficiado;
	
	
	public String getSetorBeneficiado() {
		return setorBeneficiado;
	}

	public void setSetorBeneficiado(String setorBeneficiado) {
		this.setorBeneficiado = setorBeneficiado;
	}

	@Override
	public void efetuarTransacao(double valor, String setor) {
		this.valorTransacao = valor;
		this.setorBeneficiado = setor;	
	}

	@Override
	public String toString() {

		String dados = "";
		dados += "Investimento";
		dados += "\nSetor Beneficiado: " + this.setorBeneficiado;
		
		return dados + super.toString();
	}
	
	
}
