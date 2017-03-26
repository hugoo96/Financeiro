package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionFactory;
import model.financeiro.Saida;

public class SaidaDao {
	
private Connection connection;
	
	public SaidaDao() throws SQLException{
		// TODO Auto-generated constructor stub
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiconarSaida(Saida saida) {
		String sql = "insert into financeiro" +
					"(descricaoTransacao,valor,cedente)" +
					"values (?,?,?)";
		
		try {
			//prepara para insercao
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, saida.getDescricaoTransacao());
			stmt.setDouble(2, saida.getValorTransacao());
			stmt.setString(3, saida.getCedente());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void AlterarSaida(Saida saida) {
		String sql = "update financeiro set descricaoTransacao=?, "
				+ "valor=?, cedente=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, saida.getDescricaoTransacao());
			stmt.setDouble(2, saida.getValorTransacao());
			stmt.setString(3, saida.getCedente());
			stmt.setLong(4, saida.getID());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void removerSaida(Saida saida) {
		try {
			PreparedStatement stmt = connection.
					prepareStatement("delete from financeiro where cedente != \"null\" and id=?");
			
			stmt.setLong(1, saida.getID());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public Saida buscarSaidaPorID(long id) {
		Saida saida = new Saida();
		
		try {
			PreparedStatement stmt = connection.
					prepareStatement("select * from financeiro where id = " + id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				saida.setID(rs.getLong("id"));
				saida.setCedente(rs.getString("cedente"));
				saida.setDescricaoTransacao("descricaoTransacao");
				saida.setValorTransacao(rs.getDouble("valor"));
			}
			
			rs.close();
			stmt.close();
			
			if (saida.getCedente() == null) {
				return null;
			}
			
			return saida;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}

	}
	
	public List<Saida> listarSaidas() {
		try {
			List<Saida> saidas = new ArrayList<Saida>();
			PreparedStatement stmt = connection.prepareStatement(
					"select * from financeiro where cedente != \"null\"");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Saida saida = new Saida();
				
				saida.setID(rs.getLong("id"));
				saida.setCedente(rs.getString("cedente"));
				saida.setDescricaoTransacao(rs.getString("descricaoTransacao"));
				saida.setValorTransacao(rs.getDouble("valor"));
				
				saidas.add(saida);
			}
			
			rs.close();
			stmt.close();
			
			if(saidas.isEmpty()) {
				return null;
			}
			
			return saidas;
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
