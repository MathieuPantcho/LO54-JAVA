package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcCourseDao {

    public void save(Course l) {
        //Si Satement
//        saveStatement(l);

        //Si PreparedStatement
        savePrepareStatement(l);
    }

    public void saveStatement(Course l) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO ECOLE.COURSE(CITY) VALUES('"
                    + l.getCode() + "', "
                    + l.getTitle() + "')");
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

    public void savePrepareStatement(Course l) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            PreparedStatement ps = con.prepareStatement("INSERT INTO ECOLE.COURSE(CODE,TITLE) VALUES(?,?)");
            ps.setString(1, l.getCode());
            ps.setString(2, l.getTitle());
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

    public ArrayList<Course> listFilm() {
        Connection con = null;
        ArrayList<Course> location = new ArrayList<Course>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            String query="SELECT * FROM Course";
            Statement statement=con.createStatement();
            ResultSet resultset= statement.executeQuery(query);
            while(resultset.next()){
                Course l = new Course();
                l.setCode(resultset.getString("CODE"));
                l.setTitle(resultset.getString("TITLE"));
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
