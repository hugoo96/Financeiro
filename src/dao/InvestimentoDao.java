package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionFactory;
import model.financeiro.Investimento;

public class InvestimentoDao {
	
private Connection connection;
	
	public InvestimentoDao() throws SQLException{
		// TODO Auto-generated constructor stub
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiconarInvestimento(Investimento investimento) {
		String sql = "insert into financeiro" +
					"(descricaoTransacao,valor,setorBeneficiado)" +
					"values (?,?,?)";
		
		try {
			//prepara para insercao
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, investimento.getDescricaoTransacao());
			stmt.setDouble(2, investimento.getValorTransacao());
			stmt.setString(3, investimento.getSetorBeneficiado());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void AlterarInvestimentos(Investimento investimento) {
		String sql = "update financeiro set descricaoTransacao=?, "
				+ "valor=?, setorBeneficiado=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, investimento.getDescricaoTransacao());
			stmt.setDouble(2, investimento.getValorTransacao());
			stmt.setString(3, investimento.getSetorBeneficiado());
			stmt.setLong(4, investimento.getID());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void removerInvestimento(Investimento investimento) {
		try {
			PreparedStatement stmt = connection.
					prepareStatement("delete from financeiro where "
							+ "setorBeneficiado != \"null\" and id=?");
			
			stmt.setLong(1, investimento.getID());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public Investimento buscarInvestimentoPorID(long id) {
		Investimento investimento = new Investimento();
		
		try {
			PreparedStatement stmt = connection.
					prepareStatement("select * from financeiro where "
							+ "setorBeneficiado != \"null\" and id = " + id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				investimento.setID(rs.getLong("id"));
				investimento.setSetorBeneficiado(rs.getString("setorBeneficiado"));
				investimento.setDescricaoTransacao("descricaoTransacao");
				investimento.setValorTransacao(rs.getDouble("valor"));
			}
			
			rs.close();
			stmt.close();
			
			if(investimento.getID() == 0) {
				return null;
			}
			
			return investimento;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}

	}
	
	public List<Investimento> listarInvestimentos() {
		try {
			List<Investimento> investimentos = new ArrayList<Investimento>();
			PreparedStatement stmt = connection.prepareStatement(
					"select * from financeiro where setorBeneficiado != \"null\"");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Investimento investimento = new Investimento();
				
				investimento.setID(rs.getLong("id"));
				investimento.setSetorBeneficiado(rs.getString("setorBeneficiado"));
				investimento.setDescricaoTransacao(rs.getString("descricaoTransacao"));
				investimento.setValorTransacao(rs.getDouble("valor"));
				
				investimentos.add(investimento);
			}
			
			rs.close();
			stmt.close();
			
			if(investimentos.isEmpty()) {
				return null;
			}
			
			return investimentos;
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}


}
