package fr.utbm.dvdstore.core.repository;

import fr.utbm.dvdstore.core.entity.Location;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcLocationDao {

    public void save(Location l) {
        //Si Satement
//        saveStatement(l);

        //Si PreparedStatement
        savePrepareStatement(l);
    }

    public void saveStatement(Location l) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO ECOLE.LOCATION(CITY) VALUES('"
                    + l.getId() + l.getCity()  + "')");
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

    public void savePrepareStatement(Location l) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            PreparedStatement ps = con.prepareStatement("INSERT INTO ECOLE.LOCATION(CITY) VALUES(?)");
            ps.setString(1, l.getCity());
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

    public ArrayList<Location> listFilm() {
        Connection con = null;
        ArrayList<Location> location = new ArrayList<Location>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            String query="SELECT * FROM Location";
            Statement statement=con.createStatement();
            ResultSet resultset= statement.executeQuery(query);
            while(resultset.next()){
                Location l = new Location();
                l.setCity(resultset.getString("CITY"));
                location.add(l);
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
        return location;
    }
}
