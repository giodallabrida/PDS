package PDS.Persistencia;

import PDS.Util.Mensagens;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {

    public boolean cadastraFuncionarioBD(String nomeFunc, String cpfFunc, String rgFunc, String datNasc, String telFunc, String endFunc) throws SQLException, FileNotFoundException {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into funcionario (COD_FUNCIONARIO, NOM_FUNCIONARIO, CPF_FUNCIONARIO, RG_FUNCIONARIO, DAT_NASCIMENTO_F, TEL_FUNCIONARIO, END_FUNCIONARIO, SENHA_ADM) values"
                    + " (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nomeFunc);
            p.setString(2, cpfFunc);
            p.setString(3, rgFunc);
            p.setString(4, datNasc);
            p.setString(5, telFunc);
            p.setString(6, endFunc);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao alterar os dados do cliente.");
        }
        return aux;
    }

    public boolean validaAdmin(String cpf, String senha) throws SQLException {
        boolean verifica = false;
        String aux = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conexao = DriverManager.getConnection(aux);
        String sql = "select CPF_FUNCIONARIO, SENHA_ADM from funcionario"
                + " where CPF_ADM = ? "
                + " and SENHA_ADM = ? ";
        PreparedStatement p = conexao.prepareStatement(sql);
        p.setString(1, cpf);
        p.setString(2, senha);
        ResultSet rs = p.executeQuery();
        if (rs.next()) {
            verifica = true;
        }
        return verifica;
    }

    public boolean alteraFuncionarioBD(String nomeFunc, String cpfFunc, String rgFunc, String datNascimento, String telFunc, String endFunc, int codFunc) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update funcionario set NOM_FUNCIONARIO = ?, CPF_FUNCIONARIO = ?, RG_FUNCIONARIO = ?, DAT_NASCIMENTO_C = ?, TEL_FUNCIONARIO = ?, END_FUNCIONARIO = ? "
                    + "where COD_FUNCIONARIO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nomeFunc);
            p.setString(3, cpfFunc);
            p.setString(4, rgFunc);
            p.setString(5, datNascimento);
            p.setString(6, telFunc);
            p.setString(7, endFunc);
            p.setInt(8, codFunc);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao alterar os dados do cliente.");
        }
        return aux;
    }

    public boolean removeClienteBD(int codFunc) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "delete from FUNCIONARIO where COD_FUNCIONARIO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codFunc);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao remover um cliente do banco de dados.");
        }
        return aux;
    }
}
