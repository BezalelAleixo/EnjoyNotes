package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
	 
	public Connection conexaoBD() {	
		Connection conexao = null;
		try {
			String url = "jdbc:mysql://localhost:3306/projeto?user=root&password=root";
			conexao = DriverManager.getConnection(url);
		}catch(SQLException e) {
			System.err.println("conexao sem sucesso"+e);
		}
		return conexao;
	}
	
}
