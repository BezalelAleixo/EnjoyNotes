package enj.appdesktop.model.daoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotaIdDAO {
	Connection conexao = null;
    public int buscarIdPorTitulo(String titulo) {
        
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        int id = -1; // Valor padrão caso o ID não seja encontrado

        try {
            conexao = new ConexaoDAO().conexaoBD();

            // Definir a consulta SQL para buscar o ID com base no título
            String sql = "SELECT id FROM NOTA WHERE titulo = ?";
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, titulo);

            // Executar a consulta
            resultado = stmt.executeQuery();

            // Verificar se o resultado contém um ID
            if (resultado.next()) {
                id = resultado.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar recursos (ResultSet, PreparedStatement e Connection)
            if (resultado != null) {
                try {
                    resultado.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return id;
    }
}
