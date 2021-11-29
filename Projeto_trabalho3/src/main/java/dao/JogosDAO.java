package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Jogos;
import conexao.Conectar;

public class JogosDAO {

	
	 private Connection connection;
	 
	 public JogosDAO() {
		 connection = Conectar.getConnection();
	 }
	 
	 public void salvar(Jogos jogos) {
		try {
			String sql = "insert into jogosjdbc(id,nome,classe,vida,dano) values(?,?,?,?,?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//statement.setLong(1, 1);
			//statement.setString(2,"Rodrigo");
			//statement.setString(3,"Classe");
			//statement.setInt(4,10);
			//statement.setFloat(5,7);
			
			
			statement.setLong(1, jogos.getId());
			statement.setString(2, jogos.getNome());
			statement.setString(3,jogos.getClasse());
			statement.setInt(4,jogos.getVida());
			statement.setFloat(5,jogos.getDano());
			
			statement.execute();
			connection.commit();
		}catch (Exception e) {
			try {
				connection.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			e.printStackTrace();
		}
		
	 }
		public List<Jogos> listar() throws Exception{
			List<Jogos> list = new ArrayList<Jogos>();
			String sql = "select * from jogosjdbc";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				Jogos jogos = new Jogos();
				jogos.setId(resultado.getLong("id"));
				jogos.setNome(resultado.getString("nome"));
				jogos.setClasse(resultado.getString("classe"));
				
				list.add(jogos);
			}
			return list;
			
	}
		
		public Jogos buscar(Long id)throws Exception {
			Jogos jogos = new Jogos();
			
			String sql = "select * from jogosjdbc where id ="+ id;
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultado = statement.executeQuery();
			
			while (resultado.next()) {
				jogos.setId(resultado.getLong("id"));
				jogos.setNome(resultado.getString("nome"));
				jogos.setClasse(resultado.getString("Classe"));
				jogos.setVida(resultado.getInt("Vida"));
				jogos.setDano(resultado.getInt("Dano"));
			}
			return jogos;
			
		}
		
		public void atualizar(Jogos jogos) {
       try {
    	   String sql = "update jogosjdbc set home = ? where id =" + jogos.getId();
    	   PreparedStatement statement = connection.prepareStatement(sql);
    	   statement.setString(1, jogos.getNome());
    	   statement.execute();
    	   connection.commit();
    	   
;       }catch (SQLException e) {
	try {
		connection.rollback();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	
}
		}
		public void deletar(Long id) {
			try {
				String sql = "delete from jogosjdbc where id ="+id;
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.execute();
				connection.commit();
			}catch (Exception e) {
		try {
			connection.rollback();
			
		}catch (SQLException e1) {
			e.printStackTrace();
		}
	 }
		}
}
	 

