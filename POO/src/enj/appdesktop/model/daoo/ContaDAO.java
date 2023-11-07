package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import enj.appdesktop.model.vo.ContaVO;

/**
 * @author prfel
 * @see Classe de conexao para a tabela usuario 
 */
public class ContaDAO {
	 Connection conexao = null;
	 PreparedStatement PSTM;
	
	 public void cadastrar(ContaVO user) {
			String SQL = "INSERT INTO CONTA (nome_perfil, senha, foto) VALUES (?,?,?);";
			conexao = new ConexaoDAO().conexaoBD();
			try {
				PSTM = conexao.prepareStatement(SQL);
				PSTM.setString(1, user.getNome_perfil());
				PSTM.setString(2, user.getSenha());
				PSTM.setString(3, user.getFoto());
				PSTM.execute();
				PSTM.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	 ContaVO conta;
	 public void BuscarContaPeloID(int id) {
		 String SQL = "SELECT * FROM CONTA WHERE id_conta = ?";
	        conexao = new ConexaoDAO().conexaoBD();
	        
	        ResultSet RS = null;
	        try {
	            PSTM = conexao.prepareStatement(SQL);
	            PSTM.setInt(1, id);
	            RS = PSTM.executeQuery();

	            while (RS.next()) {
	            	int id_conta = RS.getInt("id_conta");
	            	String nome_perfil = RS.getString("nome_perfil");
	            	String senha = RS.getString("senha");
	            	String foto = RS.getString("foto");
	                conta = new ContaVO();
	                conta.setId_conta(id_conta);
	                conta.setNome_perfil(nome_perfil);
	                conta.setSenha(senha);
	                conta.setFoto(foto);
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	 }
	 public ContaVO MinhaConta() {
	        return conta;
	    }
	
}
