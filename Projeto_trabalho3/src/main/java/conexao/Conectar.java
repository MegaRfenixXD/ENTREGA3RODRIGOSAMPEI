package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

	
	private static String url = "jdbc:postgresql://localhost:5432/Projeto3";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	public Conectar() {
		VaiConectar();
	}
	
	
	static {
		VaiConectar();
	}
	
    private static void VaiConectar() {
    	try {
    		if(connection == null) {
    			Class.forName("org.postgresql.Driver");
    		   connection = DriverManager.getConnection(url, user, password);
    		   connection.setAutoCommit(false);
    		   System.out.println("Conectou com Sucesso");
    		}
    		
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    }
     public static Connection getConnection() {
    	return connection; 
     }
}
