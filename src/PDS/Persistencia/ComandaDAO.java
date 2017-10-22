package PDS.Persistencia;

import PDS.Modelo.ComandaDTO;
import PDS.Modelo.ComissaoDTO;
import PDS.Modelo.ServicoComandaDTO;
import PDS.Util.Mensagens;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ComandaDAO {

    public int cadastraComandaBD(int codigoCliente, int codigoFunc, int codigoServico, Date datPrestacao, float preco) throws SQLException, FileNotFoundException {
        int aux = 0;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into COMANDA (COD_CLIENTE, COD_FUNCIONARIO, COD_SERVICO, DAT_PRESTACAO, PRECO_COMANDA) values"
                    + " (?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codigoCliente);
            p.setInt(2, codigoFunc);
            p.setInt(3, codigoServico);
            p.setDate(4, datPrestacao);
            p.setFloat(5, preco);
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
    
       public ArrayList<ServicoComandaDTO> carregaTabelaComandaBD(int codComanda) {
        ArrayList<ServicoComandaDTO> listaComanda = new ArrayList();
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "select COD_COMANDA, COD_FUNCIONARIO, COD_SERVICO, VALOR_PRESTADO, VALOR_COMISSAO from SERVICO_COMANDA COD_COMANDA = ?";
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
}
