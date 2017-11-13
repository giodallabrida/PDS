package PDS.Persistencia;

import PDS.Modelo.ServicoDTO;
import PDS.Util.Mensagens;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoDAO {

    public boolean cadastraServicoBD(String desSer, String infEx) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into servico (DES_SERVICO, INF_EXTRAS_S, SITUACAO) values"
                    + " (?, ?, 'A')";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, desSer);
            p.setString(2, infEx);
            p.execute();
            aux = true;
        } catch (SQLException e) {
            Mensagens.msgErro("Ocorreu um erro ao cadastrar um \n serviço no banco de dados.");
        }
        return aux;
    }

    public boolean alteraServicoBD(String desSer, String infEx, int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update servico set DES_SERVICO = ?, INF_EXTRAS_S = ?"
                    + "where COD_SERVICO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, desSer);
            p.setString(2, infEx);
            p.setInt(3, codigo);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados \n ao alterar os dados do serviço.");
        }
        return aux;
    }

    public boolean inativaServicoBD(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update servico set SITUACAO = 'I' where COD_SERVICO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao inativar \n um serviço do banco de dados.");
        }
        return aux;
    }
    
     public ArrayList<ServicoDTO> carregaServicosBD() {
        ArrayList<ServicoDTO> listaServicos = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_SERVICO, DES_SERVICO, INF_EXTRAS_S from SERVICO where SITUACAO = 'A' "
                    + "ORDER BY DES_SERVICO";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ServicoDTO ss = new ServicoDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
                listaServicos.add(ss);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os \n serviços do banco de dados.");
        }
        return listaServicos;
    }
     
     public ArrayList<ServicoDTO> carregaServicosEspecificosBD(int codigo) {
        ArrayList<ServicoDTO> listaServicos = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_SERVICO from COMISSAO where SITUACAO = 'A' AND COD_FUNC = ? "
                    + "ORDER BY DES_SERVICO";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ServicoDTO ss = new ServicoDTO(rs.getInt(1));
                listaServicos.add(ss);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os \n serviços do banco de dados.");
        }
        return listaServicos;
    }
     
     public ArrayList pesquisaServicosBD(String nome) {
        ArrayList<ServicoDTO> listaServicos = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_SERVICO, DES_SERVICO, INF_EXTRAS_S from SERVICO where DES_SERVICO LIKE ? "
                    + "AND SITUACAO = 'A' ORDER BY DES_SERVICO";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nome);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ServicoDTO ss = new ServicoDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
                listaServicos.add(ss);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os serviços \n pesquisados do banco de dados.");
        }
        return listaServicos;
    }
     
     public ServicoDTO carregaServico(int codServico) {
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        ServicoDTO aux = null;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_SERVICO, DES_SERVICO from SERVICO where COD_SERVICO = ? AND SITUACAO = 'A' "
                    + "ORDER BY DES_SERVICO";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codServico);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                aux = new ServicoDTO();
                aux.setCodServico(rs.getInt(1));
                aux.setNomServico(rs.getString(2));
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar o nome \n do serviço do banco de dados.");
        }
        return aux;
    }
     
}
