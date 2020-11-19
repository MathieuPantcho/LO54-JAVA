package fr.utbm.ecole.core.repository;

import fr.utbm.ecole.core.entity.CourseSession;
import fr.utbm.ecole.core.entity.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class JdbcCourseSessionDao {

    public void save(CourseSession cs) {
        savePrepareStatement(cs);
    }

    public void saveStatement(CourseSession cs) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            Statement s = con.createStatement();
            s.executeUpdate("INSERT INTO ECOLE.COURSE_SESSION(ID, START_DATE, END_DATE, MAXIMUM, COURSE_CODE, LOCATION_ID) VALUES('"
                    + cs.getId() + "', "
                    + cs.getStartDate().toString() + "', "
                    + cs.getEndDate().toString() + "', "
                    + cs.getCourse().getCode() + "', "
                    + cs.getLocation().getId() + "', "
                    + cs.getMaximum() + "')");
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

    public void savePrepareStatement(CourseSession cs) {
        Connection con = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            PreparedStatement ps = con.prepareStatement("INSERT INTO ECOLE.COURSE_SESSION(ID, START_DATE, END_DATE, MAXIMUM, COURSE_CODE, LOCATION_ID) VALUES(?,?)");
            ps.setLong(1, cs.getId());
            ps.setDate(2, cs.getStartDate());
            ps.setDate(3, cs.getEndDate());
            ps.setString(4, cs.getCourse().getCode());
            ps.setLong(4, cs.getLocation().getId());
            ps.setLong(4, cs.getMaximum());
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

    public ArrayList<CourseSession> listCourseSession() {
        Connection con = null;
        ArrayList<CourseSession> courseSession = new ArrayList<CourseSession>();

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ECOLE", "ecole", "ecole");
            String query="SELECT * FROM COURSE_SESSION";
            Statement statement=con.createStatement();
            ResultSet resultset= statement.executeQuery(query);
            while(resultset.next()){
                CourseSession cs = new CourseSession();
                cs.setId(resultset.getLong("ID"));
                cs.setStartDate(resultset.getDate("START_DATE"));
                cs.setEndDate(resultset.getDate("END_DATE"));
                cs.setMaximum(resultset.getInt("MAXIMUM"));
                cs.setCourse(new Course(resultset.getString("COURSE_CODE")));
                courseSession.add(cs);
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
        return courseSession;
    }
}
