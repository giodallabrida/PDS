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
            String sql = "insert into cliente (NOM_CLIENTE, TEL_CLIENTE, DAT_NASCIMENTO_C, END_CLIENTE, DAT_ATENDIMENTO, INF_EXTRAS_C) values"
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
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao inserir o cliente." + e.getMessage());
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
            String sql = "update cliente set NOM_CLIENTE = ?, TEL_CLIENTE = ?, DAT_NASCIMENTO_C = ?, END_CLIENTE = ?, DAT_NASCIMENTO = ?, INF_EXTRAS_C = ?"
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

    public ArrayList carregaAniversariatesBD(relatorioAniversariantes data) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<ClienteDTO> listaAniversariantes = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select NOM_CLIENTE from Cliente where DAT_NASCIMENTO_C == ?";
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
            String sql = "select NOM_CLIENTE from Cliente";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cc = new ClienteDTO(rs.getString(1));
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
            String sql = "select NOM_CLIENTE from CLIENTE where NOM_CLIENTE == ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nome);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cc = new ClienteDTO(rs.getString(1));
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