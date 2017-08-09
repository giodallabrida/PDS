package PDS.Persistencia;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioDAO {
        public void cadastraFuncionarioBD(int codFunc, String nomeFunc, String cpfFunc, String rgFunc, String datNasc, String telFunc, String endFunc, String senhaFunc) throws SQLException, FileNotFoundException {

        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn = DriverManager.getConnection(str);
        String sql = "insert into funcionario (COD_FUNCIONARIO, NOM_FUNCIONARIO, CPF_FUNCIONARIO, RG_FUNCIONARIO, DAT_NASCIMENTO_F, TEL_FUNCIONARIO, END_FUNCIONARIO, SENHA_ADM) values"
                + " (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setInt(1, codFunc);
        p.setString(2, nomeFunc);
        p.setString(3, cpfFunc);
        p.setString(4, rgFunc);
        p.setString(5, datNasc);
        p.setString(6, telFunc);
        p.setString(7, endFunc);
        p.setString(8, senhaFunc);
        p.execute();
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
}
