package PDS.Persistencia;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicoDAO {
        public void cadastraServicoBD(int codSer, String desSer, String infEx) throws SQLException, FileNotFoundException {

        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn = DriverManager.getConnection(str);
        String sql = "insert into servico (COD_SERVICO, DES_SERVICO, INF_EXTRAS_S) values"
                + " (?, ?, ?)";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setInt(1, codSer);
        p.setString(2, desSer);
        p.setString(3, infEx);
        p.execute();
    }
}
