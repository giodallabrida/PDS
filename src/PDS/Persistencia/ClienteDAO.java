package PDS.Persistencia;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void cadastraClienteBD(int codCli, String nomeCli, String telCli, String datNasc, String endCli, String datAte, String infEx) throws SQLException, FileNotFoundException {

        String str = "jdbc:mysql://localhost:3307/pds?"
                + "user=root&password=root";
        Connection conn = DriverManager.getConnection(str);
        String sql = "insert into cliente (COD_CLIENTE, NOME_CLIENTE, TEL_CLIENTE, DAT_NASCIMENTO, END_CLIENTE, DAT_ATENDIMENTO, INF_EXTRAS_C) values"
                + " (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setInt(1, codCli);
        p.setString(2, nomeCli);
        p.setString(3, telCli);
        p.setString(4, datNasc);
        p.setString(5, endCli);
        p.setString(6, datAte);
        p.setString(7, infEx);
        p.execute();
    }
}
