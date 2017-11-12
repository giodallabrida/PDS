
package PDS.Persistencia;

import PDS.Util.Mensagens;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicoComandaDAO {
    
    public boolean cadastraServicoComandaBD(int codComanda, int codFunc, int codServico, float valorPrestado, float valorComissao) throws SQLException, FileNotFoundException {
        boolean aux = false;
        try {
            String str = "jdbc:mysql://localhost:3307/pds?"
                    + "user=root&password=root";
            Connection conn = DriverManager.getConnection(str);
            String sql = "insert into SERVICO_COMANDA (COD_COMANDA, COD_FUNCIONARIO, COD_SERVICO, VALOR_PRESTADO, VALOR_COMISSAO) values"
                    + " (?, ?, ?, ?, ?)";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, codComanda);
            p.setInt(2, codFunc);
            p.setInt(3, codServico);
            p.setFloat(4, valorPrestado);
            p.setFloat(5, valorComissao);
            p.execute();
            aux = true;
        } catch (SQLException ex) {
            Mensagens.msgErro("Ocorreu um erro no banco de dados \n ao cadastrar os serviços prestados.");
        }
        return aux;
    }
    
    public float carregaSalariosFuncionariosBD(Date dataInicio, Date dataTermino) {
        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn;
        Float valor = 0f;
        try {
            conn = DriverManager.getConnection(str);
            String sql = "SELECT SUM(S.VALOR_COMISSAO) FROM SERVICO_COMANDA S INNER JOIN COMANDA C "
                    + "ON C.COD_COMANDA = S.COD_COMANDA WHERE C.DAT_PRESTACAO BETWEEN ? AND ? AND C.PAGO = 'P'";
            PreparedStatement p = conn.prepareStatement(sql);
            p.setDate(1, dataInicio);
            p.setDate(2, dataTermino);
            ResultSet rs = p.executeQuery();
            while (rs.next()) {
                valor = valor + rs.getFloat(1);
            }
            rs.close();
            p.close();
            conn.close();
        } catch (Exception ex) {
            Mensagens.msgErro("Ocorreu um erro ao carregar os \n valores do banco de dados.");
        }
        return valor;
    }
     
    
    
}
