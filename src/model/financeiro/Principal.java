package model.financeiro;

import java.sql.SQLException;
import dao.EntradaDao;
import dao.InvestimentoDao;
import dao.SaidaDao;

public class Principal {
	
	public static void main(String[] args) throws SQLException {
		
		Investimento investimento = new Investimento();
		Saida saida = new Saida();
		
		
		
		investimento.setID(5);
		
		EntradaDao dao = new EntradaDao();
		SaidaDao dao3 = new SaidaDao();
		InvestimentoDao dao2 = new InvestimentoDao();
		
	
		System.out.println(dao3.listarSaidas());
		

	}

}
