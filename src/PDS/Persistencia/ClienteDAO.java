package PDS.Persistencia;

import PDS.Util.Mensagens;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public boolean cadastraClienteBD(String nomeCli, String telCli, String datNasc, String endCli, String datAte, String infEx) throws SQLException, FileNotFoundException {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into cliente (NOME_CLIENTE, TEL_CLIENTE, DAT_NASCIMENTO, END_CLIENTE, DAT_ATENDIMENTO, INF_EXTRAS_C) values"
                    + " (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nomeCli);
            p.setString(2, telCli);
            p.setString(3, datNasc);
            p.setString(4, endCli);
            p.setString(5, datAte);
            p.setString(6, infEx);
            p.execute();
            aux = true;
        } catch (SQLException e) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao inserir o cliente.");
        }
        return aux;
    }

    public boolean alteraClienteBD(String nomeCli, String telCli, String datNasc, String endCli, String datAte, String infEx, int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            // estabelecer a conexão...mysql-connector-java-5.1.42-bin.jar
            Connection conn = DriverManager.getConnection(str);
            String sql = "update cliente set NOME_CLIENTE = ?, TEL_CLIENTE = ?, DAT_NASCIMENTO_C = ?, END_CLIENTE = ?, DAT_NASCIMENTO = ?, INF_EXTRAS_C = ?"
                    + "where COD_CLIENTE = ?";
            // enviar o select para ser analisado pelo banco
            // de dados...
            PreparedStatement p = conn.prepareStatement(sql);
            // definir o valor de cada um dos parâmetros...
            p.setString(1, nomeCli);
            p.setString(2, telCli);
            p.setString(3, datNasc);
            p.setString(4, endCli);
            p.setString(5, datAte);
            p.setString(6, infEx);
            p.setInt(7, codigo);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao alterar os dados do cliente.");
        }
        return aux;
    }

    public boolean removeClienteBD(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "delete from cliente where COD_CLIENTE = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao remover um cliente do banco de dados.");
        }
        return aux;
    }
}
