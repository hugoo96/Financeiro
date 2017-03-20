package model.financeiro;

public class Principal {
	
	public static void main(String[] args) {
		
		Financeiro entrada = new Entrada();
		Financeiro saida = new Saida();
		Investimento investimento = new Investimento();
		
		entrada.setCodigoTransacao(1);
		entrada.efetuarTransacao(200, "Hugo Silvestre");
		entrada.setDescricaoTransacao("Midias");
		
		saida.setCodigoTransacao(2);
		saida.efetuarTransacao(600, "Funcionarios");
		saida.setDescricaoTransacao("Salarios");
		
		investimento.setCodigoTransacao(4);
		investimento.efetuarTransacao(4000, "Projetos");
		investimento.setDescricaoTransacao("Novo espaço");
		
		Balanco balanco = new Balanco();
		
		balanco.adicionarTransacao(entrada);
		balanco.adicionarTransacao(saida);
		balanco.adicionarTransacao(investimento);
		
		System.out.println(balanco.buscaTransacaoPorCodigo(5));
		
	}

}
