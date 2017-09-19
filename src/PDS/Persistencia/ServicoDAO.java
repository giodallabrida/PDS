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
            String sql = "insert into servico (DES_SERVICO, INF_EXTRAS_S) values"
                    + " (?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, desSer);
            p.setString(2, infEx);
            p.execute();
            aux = true;
        } catch (SQLException e) {
            Mensagens.msgErro("Ocorreu um erro ao cadastrar um serviço no banco de dados.");
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
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao alterar os dados do serviço.");
        }
        return aux;
    }

    public boolean removeServicoBD(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "delete from servico where COD_SERVICO = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao remover um serviço do banco de dados.");
        }
        return aux;
    }
    
     public ArrayList carregaServicosBD() {
        ArrayList<ServicoDTO> listaServicos = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select NOM_SERVICO from SERVICO";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ServicoDTO ss = new ServicoDTO(rs.getString(1));
                listaServicos.add(ss);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os clientes do banco de dados.");
        }
        return listaServicos;
    }
}
