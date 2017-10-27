
package PDS.Persistencia;

import PDS.Util.Mensagens;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            Mensagens.msgErro("Ocorreu um erro no banco de dados ao inserir os serviços prestados." + ex.getMessage());
        }
        return aux;
    }
    
    
    
    
}
