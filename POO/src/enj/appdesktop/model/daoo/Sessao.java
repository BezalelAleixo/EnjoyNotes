package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sessao {

	Connection conexao = null;
	PreparedStatement PSTM = null;
	
	public void manterSessao(int number) {
		conexao = new ConexaoDAO().conexaoBD();
		
		String comando = "UPDATE SESSAO SET numerador = ? WHERE id = 1";
		
		try {
			PSTM = conexao.prepareStatement(comando);
			PSTM.setInt(1, number);
			PSTM.executeUpdate();
			PSTM.close();
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
	public boolean verificarSessao(int bun) {
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT * FROM SESSAO WHERE numerador = ?";
		boolean check = false;

		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setInt(1, bun);
			RS = PSTM.executeQuery();

			if (RS.next()) {
				check = true;
			}
		} catch (SQLException e) {
			java.util.logging.Logger.getLogger(ConsultaDAO.class.getName()).log(java.util.logging.Level.SEVERE, null,
					e);
		}
		return check;
	}
}
