package PDS.Persistencia;

import PDS.Modelo.ClienteDTO;
import PDS.Util.Mensagens;
import PDS.Util.Validacao;
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
import java.util.Calendar;

public class ClienteDAO {

    public boolean cadastraClienteBD(String nomeCli, String telCli, Date datNasc, String endCli, String infEx) throws SQLException, FileNotFoundException {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into cliente (NOM_CLIENTE, TEL_CLIENTE, DAT_NASCIMENTO_C, END_CLIENTE, INF_EXTRAS_C, SITUACAO) values"
                    + " (?, ?, ?, ?, ?, 'A')";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nomeCli);
            p.setString(2, telCli);
            p.setDate(3, datNasc);
            p.setString(4, endCli);
            p.setString(5, infEx);
            p.execute();
            aux = true;
        } catch (SQLException e) {
            Mensagens.msgErro("Ocorreu um erro no banco de \n dados ao cadastrar o cliente.");
        }
        return aux;
    }

    public boolean alteraClienteBD(String nomeCli, String telCli, Date datNasc, String endCli, String infEx, int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update cliente set NOM_CLIENTE = ?, TEL_CLIENTE = ?, "
                    + "DAT_NASCIMENTO_C = ?, END_CLIENTE = ?, "
                    + "INF_EXTRAS_C = ? where COD_CLIENTE = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nomeCli);
            p.setString(2, telCli);
            p.setDate(3, datNasc);
            p.setString(4, endCli);
            p.setString(5, infEx);
            p.setInt(6, codigo);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados \n ao alterar os dados do cliente.");
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
            Mensagens.msgErro("Ocorreu um erro ao inativar \n um cliente do banco de dados.");
        }
        return aux;
    }

    public ArrayList<ClienteDTO> carregaAniversariatesBD(relatorioAniversariantes data) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        System.out.println();
        ArrayList<ClienteDTO> listaAniversariantes = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select NOM_CLIENTE, tel_cliente from Cliente "
                    + "where extract(month from dat_nascimento_c) = ? and extract(day from dat_nascimento_c) = ?;";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, c.get(Calendar.MONTH)+1);
            p.setInt(2, c.get(Calendar.DAY_OF_MONTH));
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cc = new ClienteDTO(rs.getString(1), rs.getString(2));
                listaAniversariantes.add(cc);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os \n aniversariantes do banco de dados.");
        }
        return listaAniversariantes;
    }

    

    public ArrayList<ClienteDTO> carregaClientesBD() {
        ArrayList<ClienteDTO> listaClientes = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_CLIENTE, NOM_CLIENTE, TEL_CLIENTE, DAT_NASCIMENTO_C, END_CLIENTE, INF_EXTRAS_C from Cliente where SITUACAO = 'A'";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cc = new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), Validacao.getDataJava(rs.getDate(4)), rs.getString(5), rs.getString(6));
                listaClientes.add(cc);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os \n clientes do banco de dados.");
        }
        return listaClientes;
    }

    public ArrayList<ClienteDTO> pesquisaClientesBD(String nome) {
        ArrayList<ClienteDTO> listaClientes = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_CLIENTE, NOM_CLIENTE, TEL_CLIENTE, DAT_NASCIMENTO_C, END_CLIENTE, INF_EXTRAS_C from CLIENTE where NOM_CLIENTE LIKE ? AND SITUACAO = 'A'";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nome);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cc = new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), Validacao.getDataJava(rs.getDate(4)), rs.getString(5), rs.getString(6));
                listaClientes.add(cc);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os clientes \n pesquisados do banco de dados.");
        }
        return listaClientes;
    }
}