package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionFactory;
import model.financeiro.Entrada;

public class EntradaDao {
	
	private Connection connection;
	
	public EntradaDao() throws SQLException{
		// TODO Auto-generated constructor stub
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiconarEntrada(Entrada entrada) {
		String sql = "insert into financeiro" +
					"(descricaoTransacao,valor,sacado)" +
					"values (?,?,?)";
		
		try {
			//prepara para insercao
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, entrada.getDescricaoTransacao());
			stmt.setDouble(2, entrada.getValorTransacao());
			stmt.setString(3, entrada.getSacado());
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void AlterarEntradas(Entrada entrada) {
		String sql = "update financeiro set descricaoTransacao=?, "
				+ "valor=?, sacado=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, entrada.getDescricaoTransacao());
			stmt.setDouble(2, entrada.getValorTransacao());
			stmt.setString(3, entrada.getSacado());
			stmt.setLong(4, entrada.getID());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public void removerEntrada(Entrada entrada) {
		try {
			PreparedStatement stmt = connection.
					prepareStatement("delete from financeiro where "
							+ "sacado != \"null\" and id=?");
			
			stmt.setLong(1, entrada.getID());
			
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public Entrada buscarEntradaPorID(long id) {
		Entrada entrada = new Entrada();
		
		try {
			PreparedStatement stmt = connection.
					prepareStatement("select * from financeiro where sacado != \"null\" and id = " + id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				entrada.setID(rs.getLong("id"));
				entrada.setSacado(rs.getString("sacado"));
				entrada.setDescricaoTransacao("descricaoTransacao");
				entrada.setValorTransacao(rs.getDouble("valor"));
			}
			
			rs.close();
			stmt.close();
			
			if (entrada.getSacado() == null) {
				return null;
			}
			
			return entrada;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}

	}
	
	public List<Entrada> listarEntradas() {
		try {
			List<Entrada> entradas = new ArrayList<Entrada>();
			PreparedStatement stmt = connection.prepareStatement(
					"select * from financeiro where sacado != \"null\"");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Entrada entrada = new Entrada();
				
				entrada.setID(rs.getLong("id"));
				entrada.setSacado(rs.getString("sacado"));
				entrada.setDescricaoTransacao(rs.getString("descricaoTransacao"));
				entrada.setValorTransacao(rs.getDouble("valor"));
				
				entradas.add(entrada);
			}
			
			rs.close();
			stmt.close();
			
			if (entradas.isEmpty()) {
				return null;
			}
			
			return entradas;
			
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

}
