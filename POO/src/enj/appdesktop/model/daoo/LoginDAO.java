/**
 * 
 */
package enj.appdesktop.model.daoo;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import enj.appdesktop.model.vo.CadastroVO;

/**
 * @author prfel
 * @see Classe para banco de dados da entidade Usuario
 */
public class LoginDAO {
	
	public boolean VerificarLogin(String Usuario, String senha){
		Connection conexao = new ConexaoDAO().conexaoBD();
		PreparedStatement PSTM = null;
		ResultSet RS = null;
		String select = "SELECT * FROM USUARIO WHERE NOMEUSUARIO = ? AND SENHA = ?";
		boolean check = false;
		
		try {
			PSTM = conexao.prepareStatement(select);
			PSTM.setString(1, Usuario);
			PSTM.setString(2, senha);
			RS = PSTM.executeQuery();
			
			if (RS.next()) {
				check = true;
			}
		}catch (SQLException e) {
			java.util.logging.Logger.getLogger(LoginDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
		}
		return check;
	}
	
}
