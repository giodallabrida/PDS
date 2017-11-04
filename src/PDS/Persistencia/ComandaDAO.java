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

    public int cadastraComandaBD(int codigoCliente, Date datPrestacao, float preco) throws SQLException, FileNotFoundException {
        int aux = 0;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into COMANDA (COD_CLIENTE, DAT_PRESTACAO, PRECO_COMANDA, PAGO) values"
                    + " (?, ?, ?, 'N')";
            PreparedStatement p = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            p.setInt(1, codigoCliente);
            p.setDate(2, datPrestacao);
            p.setFloat(3, preco);
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

    public boolean alteraSituacaoComandaBD(int codComanda) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update COMANDA set PAGO = 'P' where COD_COMANDA = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codComanda);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar os dados da comanda no banco de dados.");
        }
        return aux;
    }

    public boolean alteraFormaPagamentoComandaBD(String tipoPagamento, int codigo) {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "update COMANDA set TIPO_PAG = ? WHERE COD_COMANDA = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, tipoPagamento);
            p.setInt(2, codigo);
            p.execute();
            p.close();
            conn.close();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro ao alterar os dados da comanda no banco de dados.");
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
                cliente.setNomCliente(rs.getString(7));
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

    public ArrayList<ComandaDTO> carregaRelatorioComandasBD(Date dataInicio, Date dataTermino) {
        ArrayList<ComandaDTO> listaComandas = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select CO.*, CL.NOM_CLIENTE from COMANDA CO join CLIENTE CL on (CO.COD_CLIENTE = CL.COD_CLIENTE) "
                    + "where PAGO = 'P' AND DAT_PRESTACAO BETWEEN ? AND ? ORDER BY DAT_PRESTACAO";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setDate(1, dataInicio);
            p.setDate(2, dataTermino);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setCodCliente(rs.getInt(2));
                cliente.setNomCliente(rs.getString(7));
                ComandaDTO comanda = new ComandaDTO();
                comanda.setCliente(cliente);
                comanda.setCodComanda(rs.getInt(1));
                comanda.setTotal(rs.getFloat(4));
                comanda.setData(Validacao.getDataJava(rs.getDate(3)));
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
    
    public ArrayList<ComandaDTO> carregaRelatorioComissoesBD(Date dataInicio, Date dataTermino, int codFuncionario) {
        ArrayList<ComandaDTO> listaComissoes = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT CO.*, CL.NOM_CLIENTE FROM COMANDA CO INNER JOIN CLIENTE CL "
                    + "ON (CO.COD_CLIENTE = CL.COD_CLIENTE) INNER JOIN SERVICO_COMANDA S"
                    + "ON (CO.COD_COMANDA = S.COD_COMANDA) WHERE CO.PAGO = 'P' "
                    + "AND (CO.DAT_PRESTACAO BETWEEN '2017/10/27' AND '2017/10/27') AND S.COD_FUNCIONARIO = ?"
                    + "ORDER BY DAT_PRESTACAO, NOM_CLIENTE";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setDate(1, dataInicio);
            p.setDate(2, dataTermino);
            p.setInt(3, codFuncionario);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO();
                cliente.setCodCliente(rs.getInt(2));
                cliente.setNomCliente(rs.getString(7));
                ComandaDTO comanda = new ComandaDTO();
                comanda.setCliente(cliente);
                comanda.setCodComanda(rs.getInt(1));
                comanda.setTotal(rs.getFloat(4));
                comanda.setData(Validacao.getDataJava(rs.getDate(3)));
                listaComissoes.add(comanda);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar as comissões do banco de dados.");
        }
        return listaComissoes;
    }
    
    public float carregaRelatorioCaixaBD(Date dataInicio, Date dataTermino, String pagamento) {
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        Float valor = 0f;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT SUM(PRECO_COMANDA) FROM COMANDA WHERE PAGO = 'P' AND TIPO_PAG = ?";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setDate(1, dataInicio);
            p.setDate(2, dataTermino);
            p.setString(3, pagamento);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
               valor = valor + rs.getFloat(1);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os valores do banco de dados.");
        }
        return valor;
    }
    
    
}
