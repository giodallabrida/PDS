package PDS.Persistencia;

import PDS.Modelo.ClienteDTO;
import PDS.Util.Mensagens;
import PDS.telas.relatorioAniversariantes;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClienteDAO {

    public boolean cadastraClienteBD(String nomeCli, String telCli, String datNasc, String endCli, String datAte, String infEx) throws SQLException, FileNotFoundException {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into cliente (NOM_CLIENTE, TEL_CLIENTE, DAT_NASCIMENTO_C, END_CLIENTE, DAT_ATENDIMENTO, INF_EXTRAS_C, SITUACAO) values"
                    + " (?, ?, ?, ?, ?, ?, 'A')";
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
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao inserir o cliente." + e.getMessage());
        }
        return aux;
    }

    public boolean alteraClienteBD(String nomeCli, String telCli, String datNasc, String endCli, String datAte, String infEx, int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update cliente set NOM_CLIENTE = ?, TEL_CLIENTE = ?, "
                    + "DAT_NASCIMENTO_C = ?, END_CLIENTE = ?,  DAT_ATENDIMENTO = ?, "
                    + "INF_EXTRAS_C = ? where COD_CLIENTE = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nomeCli);
            p.setString(2, telCli);
            p.setString(3, datNasc);
            p.setString(4, endCli);
            p.setString(5, datAte);
            p.setString(6, infEx);
            p.setInt(7, codigo);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao alterar os dados do cliente.");
        }
        return aux;
    }

    public boolean inativaClienteBD(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update CLIENTE set SITUACAO = 'I' where COD_CLIENTE = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao inativar um serviço do banco de dados.");
        }
        return aux;
    }

    public ArrayList carregaAniversariatesBD(relatorioAniversariantes data) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<ClienteDTO> listaAniversariantes = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select NOM_CLIENTE from Cliente where DAT_NASCIMENTO_C = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, formatarDate.format(date));
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cc = new ClienteDTO(rs.getString(1));
                listaAniversariantes.add(cc);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os produtos do banco de dados.");
        }
        return listaAniversariantes;
    }

    public ArrayList carregaClientesBD() {
        ArrayList<ClienteDTO> listaClientes = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_CLIENTE, NOM_CLIENTE, TEL_CLIENTE, DAT_NASCIMENTO_C, END_CLIENTE, DAT_ATENDIMENTO, INF_EXTRAS_C from Cliente where SITUACAO = 'A'";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cc = new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listaClientes.add(cc);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os clientes do banco de dados.");
        }
        return listaClientes;
    }

    public ArrayList pesquisaClientesBD(String nome) {
        ArrayList<ClienteDTO> listaClientes = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_CLIENTE, NOM_CLIENTE, TEL_CLIENTE, DAT_NASCIMENTO_C, END_CLIENTE, DAT_ATENDIMENTO, INF_EXTRAS_C from CLIENTE where NOM_CLIENTE LIKE ? AND SITUACAO = 'A'";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nome);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cc = new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listaClientes.add(cc);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os clientes pesquisados do banco de dados.");
        }
        return listaClientes;
    }
}