package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcClientDao {

    public void save(Client c) {
  
        savePrepareStatement(c);
    }

    public void saveStatement(Client c) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO ECOLE.COURSE(LASTNAME,FIRSTNAME,ADDRESS,PHONE,EMAIL) VALUES('"
                    + c.getLastname() + "', "
                    + c.getFirstname() + "', "
                    + c.getAddress() + "', "
                    + c.getPhone() + "', "
                    + c.getCourseSession().getId()+ "')");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

    public void savePrepareStatement(Client c) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            PreparedStatement ps = con.prepareStatement("INSERT INTO ECOLE.COURSE(LASTNAME,FIRSTNAME,ADDRESS,PHONE,EMAIL) VALUES(?,?,?,?,?,?)");
            ps.setString(1, c.getLastname());
            ps.setString(2, c.getFirstname());
            ps.setString(3, c.getAddress());
            ps.setString(4, c.getPhone());
            ps.setLong(5, c.getCourseSession().getId());
          
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Client> listClient() {
        Connection con = null;
        ArrayList<Client> client = new ArrayList<Client>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            String query="SELECT * FROM Client";
            Statement statement=con.createStatement();
            ResultSet resultset= statement.executeQuery(query);
            while(resultset.next()){
                Client c = new Client();
                c.setId(resultset.getLong("ID"));
                c.setFirstname(resultset.getString("FIRSTNAME"));
                c.setLastname(resultset.getString("LASTNAME"));
                c.setAddress(resultset.getString("ADDRESS"));
                c.setPhone(resultset.getString("PHONE"));
                c.setEmail(resultset.getString("TITLE"));
                client.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return client;
    }
}
