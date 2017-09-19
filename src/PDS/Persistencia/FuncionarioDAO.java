package PDS.Persistencia;

import PDS.Modelo.ClienteDTO;
import PDS.Modelo.FuncionarioDTO;
import PDS.Util.Mensagens;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {

    public boolean cadastraFuncionarioBD(String nomeFunc, String cpfFunc, String rgFunc, String datNasc, String telFunc, String endFunc) throws SQLException, FileNotFoundException {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into funcionario (COD_FUNCIONARIO, NOM_FUNCIONARIO, CPF_FUNCIONARIO, RG_FUNCIONARIO, DAT_NASCIMENTO_F, TEL_FUNCIONARIO, END_FUNCIONARIO) values"
                    + " (?, ?, ?, ?, ?, ?)";
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
        try {
            Connection conexao = DriverManager.getConnection(aux);
            String sql = "select user_adm, senha_adm from admin"
                    + " where user_adm = ? "
                    + " and senha_adm = ? ";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, cpf);
            p.setString(2, senha);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                verifica = true;
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao validar o login.");
        }
        return verifica;
    }
    
    public boolean alteraLogin(
            String user,
            String senha) {
        boolean verifica = false;
        String aux = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(aux);
            String sql = "update admin set user_adm = ?, senha_adm = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, user);
            p.setString(2, senha);
            p.execute();
            p.close();
            conexao.close();
            verifica = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar o login.");
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

    public boolean removeFuncionarioBD(int codFunc) {
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
    
    public void verificaExecucao() {
        String aux = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(aux);
            String sql = "select primeira_ex from admin where primeira_ex = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setInt(1, 0);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                Mensagens.msgInfo("O usuário padrão é 'admin' e a senha padrão é 'admin'.");
                alteraInt();
            }
            rs.close();
            p.close();
            conexao.close();
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao verificar se é a primeira execução do programa.");
        }
    }

    public void alteraInt() {
        String aux = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conexao;
        try {
            conexao = DriverManager.getConnection(aux);
            String sql = "update admin set primeira_ex = 1";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.execute();
            p.close();
            conexao.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro em uma alteração do banco de dados.");
        }
    }
    
    public ArrayList carregaFuncionariosBD() {
        ArrayList<FuncionarioDTO> listaFuncionario = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select NOME_FUNCIONARIO from FUNCIONARIO";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                FuncionarioDTO ff = new FuncionarioDTO(rs.getString(1));
                listaFuncionario.add(ff);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os funcionários do banco de dados.");
        }
        return listaFuncionario;
    }
}
