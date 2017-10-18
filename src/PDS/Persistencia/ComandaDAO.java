package PDS.Persistencia;

import PDS.Util.Mensagens;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
