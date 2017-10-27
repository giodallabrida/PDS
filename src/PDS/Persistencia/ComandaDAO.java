package PDS.Persistencia;

import PDS.Modelo.ClienteDTO;
import PDS.Modelo.ComandaDTO;
import PDS.Modelo.ServicoComandaDTO;
import PDS.Util.Mensagens;
import PDS.Util.Validacao;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComandaDAO {
    
    public int cadastraComandaBD(int codigoCliente, Date datPrestacao, float preco, String situacao) throws SQLException, FileNotFoundException {
        int aux = 0;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into COMANDA (COD_CLIENTE, DAT_PRESTACAO, PRECO_COMANDA, PAGO) values"
                    + " (?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            p.setInt(1, codigoCliente);
            p.setDate(2, datPrestacao);
            p.setFloat(3, preco);
            p.setString(4, "'" + situacao + "'");
            p.execute();
            ResultSet rs = p.getGeneratedKeys();
            if (rs.next()) {
                aux = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao inserir a comanda.");
            aux = -1;
        }
        return aux;
    }
    
    public boolean alteraComandaBD(int codigoCliente, Date datPrestacao, float preco) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update COMANDA set COD_CLIENTE = ?, DAT_PRESTACAO = ?,"
                    + "PRECO_COMANDA where COD_COMANDA = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigoCliente);
            p.setDate(2, datPrestacao);
            p.setFloat(3, preco);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao alterar os dados da comanda.");
        }
        return aux;
    }
    
    public ArrayList<ComandaDTO> carregaComandasBD() {
        ArrayList<ComandaDTO> listaComandas = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select CO.*, CL.NOM_CLIENTE from COMANDA CO join CLIENTE CL on (CO.COD_CLIENTE = CL.COD_CLIENTE) "
                    + "where PAGO = 'N'";
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setCodCliente(rs.getInt(2));
                cliente.setNomCliente(rs.getString(5));
                ComandaDTO comanda = new ComandaDTO();
                comanda.setCliente(cliente);
                comanda.setCodComanda(rs.getInt(1));
                comanda.setData(Validacao.getDataJava(rs.getDate(3)));
                comanda.setTotal(rs.getFloat(4));
                listaComandas.add(comanda);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar as comanda do banco de dados.");
        }
        return listaComandas;
    }
    
    public boolean removeServicos(int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "delete from SERVICO_COMANDA where COD_COMANDA = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigo);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao atualizar os serviços da comanda do banco de dados.");
        }
        return aux;
    }
    
    public ArrayList<ServicoComandaDTO> carregaTabelaComandaBD(int codComanda) {
        ArrayList<ServicoComandaDTO> listaComanda = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_COMANDA, COD_FUNCIONARIO, COD_SERVICO, VALOR_PRESTADO, VALOR_COMISSAO from SERVICO_COMANDA where COD_COMANDA = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codComanda);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ServicoComandaDTO sc = new ServicoComandaDTO(rs.getFloat(1));
                listaComanda.add(sc);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar as comissões do banco de dados.");
        }
        return listaComanda;
    }
    
    public int cadastraServicosPrestadosBD(int codigo, ArrayList<ServicoComandaDTO> servicos) throws SQLException, FileNotFoundException {
        int aux = 0;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into SERVICO_COMANDA (COD_COMANDA,COD_FUNCIONARIO, COD_SERVICO,VALOR_PRESTADO, VALOR_COMISSAO) values"
                    + " (?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            for (ServicoComandaDTO servico : servicos) {
                p.setInt(1, codigo);
                p.setInt(2, servico.getFuncionario().getCodFuncionario());
                p.setInt(3, servico.getComissao().getServico().getCodServico());
                p.setFloat(4, servico.getValorServico());
                p.setFloat(5, servico.getValorComissao());
                p.execute();
            }
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao inserir a comanda.");
            aux = -1;
        }
        return aux;
    }
}
