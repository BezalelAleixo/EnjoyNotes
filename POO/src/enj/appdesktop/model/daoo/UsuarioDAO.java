package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import enj.appdesktop.model.vo.ContaVO;
import enj.appdesktop.model.vo.UsuarioVO;

public class UsuarioDAO {
    Connection conexao = null;
    PreparedStatement PSTM;
    ContaVO conta;

    public void cadastrar(UsuarioVO user) {
        String SQL = "INSERT INTO USUARIO (nome_pessoal, sexo, data_nasc, id_conta_CE) VALUES (?,?,?,?)";
        conexao = new ConexaoDAO().conexaoBD();
        try {
            PSTM = conexao.prepareStatement(SQL);
            PSTM.setString(1, user.getNome());
            PSTM.setString(2, user.getSexo());
            PSTM.setString(3, user.getDatanasc());
            PSTM.setInt(4, user.getId());
            PSTM.execute();
            PSTM.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void buscarId_conta(String nome_perfil) {
        String SQL = "SELECT id_conta FROM CONTA WHERE nome_perfil = ?";
        conexao = new ConexaoDAO().conexaoBD();
        ResultSet RS = null;
        try {
            PSTM = conexao.prepareStatement(SQL);
            PSTM.setString(1, nome_perfil);
            RS = PSTM.executeQuery();

            while (RS.next()) {
                int id = RS.getInt("id_conta");
                conta = new ContaVO();
                conta.setId_conta(id);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int getId_conta() {
        int id = conta.getId_conta();
        return id;
    }
    
    UsuarioVO usuario;
    public void buscarDadosUsuario(int id_conta_CE) {
        String SQL = "SELECT * FROM USUARIO WHERE id_conta_CE = ?";
        conexao = new ConexaoDAO().conexaoBD();
        ResultSet RS = null;
        try {
            PSTM = conexao.prepareStatement(SQL);
            PSTM.setInt(1, id_conta_CE);
            RS = PSTM.executeQuery();

            while (RS.next()) {
                int id = RS.getInt("id_usuario");
                String nome = RS.getString("nome_pessoal");
                String sexo = RS.getString("sexo");
                String data_nasc = RS.getString("data_nasc");
                int id_conta = RS.getInt("id_conta_CE");
                usuario = new UsuarioVO();
                usuario.setId_usuario(id);
                usuario.setNome(nome);
                usuario.setSexo(sexo);
                usuario.setDatanasc(data_nasc);
                usuario.setId(id_conta);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public UsuarioVO MeuUsuario() {
        return usuario;
    }
}
