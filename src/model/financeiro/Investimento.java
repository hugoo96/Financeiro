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
	public void efetuarTransacao(double valor, String setor, String descricao) {
		setValorTransacao(valor);	
		setSetorBeneficiado(setor);
		setDescricaoTransacao(descricao);
	}

	@Override
	public String toString() {

		String dados = "";
		dados += "\nSetor Beneficiado: " + this.setorBeneficiado;
		
		return dados + super.toString();
	}
	
	
}
