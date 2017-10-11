package PDS.Persistencia;

import PDS.Modelo.ComissaoDTO;
import PDS.Modelo.FuncionarioDTO;
import PDS.Util.Mensagens;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class FuncionarioDAO {

    public int cadastraFuncionarioBD(String nomeFunc, String cpfFunc, String rgFunc, String datNasc, String telFunc, String endFunc) throws SQLException, FileNotFoundException {
        int aux = 0;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into FUNCIONARIO (NOM_FUNCIONARIO, CPF_FUNCIONARIO, RG_FUNCIONARIO, DAT_NASCIMENTO_F, TEL_FUNCIONARIO, END_FUNCIONARIO, SITUACAO) values"
                    + " (?, ?, ?, ?, ?, ?, 'A')";
            PreparedStatement p = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            p.setString(1, nomeFunc);
            p.setString(2, cpfFunc);
            p.setString(3, rgFunc);
            p.setString(4, datNasc);
            p.setString(5, telFunc);
            p.setString(6, endFunc);
            p.execute();
            ResultSet rs = p.getGeneratedKeys();
            if (rs.next()) {
                aux = rs.getInt(0);
            }
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao inserir o funcionário." + ex.getMessage());
            aux = -1;
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
            String sql = "update funcionario set NOM_FUNCIONARIO = ?, "
                    + "CPF_FUNCIONARIO = ?, RG_FUNCIONARIO = ?, DAT_NASCIMENTO_F = ?, "
                    + "TEL_FUNCIONARIO = ?, END_FUNCIONARIO = ? "
                    + "where COD_FUNCIONARIO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nomeFunc);
            p.setString(2, cpfFunc);
            p.setString(3, rgFunc);
            p.setString(4, datNascimento);
            p.setString(5, telFunc);
            p.setString(6, endFunc);
            p.setInt(7, codFunc);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao alterar os dados do cliente.");
        }
        return aux;
    }

    public boolean inativaFuncionarioBD(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update funcionario set SITUACAO = 'I' where COD_FUNCIONARIO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao inativar um funcionário do banco de dados.");
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

    public ArrayList<FuncionarioDTO> carregaFuncionariosBD() {
        ArrayList<FuncionarioDTO> listaFuncionario = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_FUNCIONARIO, NOM_FUNCIONARIO, CPF_FUNCIONARIO, RG_FUNCIONARIO, DAT_NASCIMENTO_F, TEL_FUNCIONARIO, END_FUNCIONARIO from FUNCIONARIO where SITUACAO = 'A'";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                FuncionarioDTO ff = new FuncionarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
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

    public ArrayList<FuncionarioDTO> pesquisaFuncionariosBD(String nome) {
        ArrayList<FuncionarioDTO> listaFuncionarios = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_FUNCIONARIO, NOM_FUNCIONARIO, CPF_FUNCIONARIO, RG_FUNCIONARIO, DAT_NASCIMENTO_F, TEL_FUNCIONARIO, END_FUNCIONARIO from FUNCIONARIO where NOM_FUNCIONARIO LIKE ? and SITUACAO = 'A'";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nome);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                FuncionarioDTO ff = new FuncionarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listaFuncionarios.add(ff);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os funcionários pesquisados do banco de dados.");
        }
        return listaFuncionarios;
    }

    public boolean cadastraComissaoBD(int codServico, JTextField porcServico, JTextField codFunc) throws SQLException, FileNotFoundException {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into COMISSAO (COMISSAO, COD_FUNC, COD_SERVICO, SITUACAO) values"
                    + " (?, ?, ?,'A')";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setFloat(1, Float.valueOf(porcServico.getText()));
            p.setInt(2, Integer.valueOf(codFunc.getText()));
            p.setInt(3, codServico);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao inserir a comissão." + ex.getMessage());
        }
        return aux;
    }

    public boolean alteraComissaoBD(JComboBox nomServico, JTextField porcServico, int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update COMISSAO set COMISSAO = ? "
                    + "WHERE COD_SERVICO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setFloat(1, Float.valueOf(String.valueOf(porcServico)));
            p.setInt(2, codigo);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao alterar os dados de comissao.");
        }
        return aux;
    }

    public boolean inativaComissaoBD(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update COMISSAO set SITUACAO = 'I' where COD_SERVICO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao inativar uma comissão do banco de dados.");
        }
        return aux;
    }

    ServicoDAO servicoDAO = new ServicoDAO();

    public ArrayList<ComissaoDTO> carregaComissoesBD(JTextField codFunc) {
        ArrayList<ComissaoDTO> listaComissao = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COMISSAO, COD_SERVICO from COMISSAO where SITUACAO = 'A' AND COD_FUNC = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, Integer.valueOf(codFunc.getText()));
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ComissaoDTO cc = new ComissaoDTO(rs.getFloat(1), servicoDAO.carregaNomeServico(rs.getInt(2)));
                listaComissao.add(cc);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar as comissões do banco de dados.");
        }
        return listaComissao;
    }
}
