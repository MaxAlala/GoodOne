package starter;

import java.sql.*;

public class DateBaseRequest {
    public  boolean isThere(String mail, String password) {
        String sqlQuery = "SELECT * from Employee";
// Open autocloseable Connection, Statement and get the result set
        try (Connection conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/Lesson21");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery);) {
// Process each column in the result set and print the data
            while (rs.next()) {
                int empNo = rs.getInt("EMPNO");
                String eName = rs.getString("ENAME");
                String job = rs.getString("JOB_TITLE");
                System.out.println("" + empNo + ", " + eName + ", " + job);
                if(mail.equals(eName)&& password.equals(job))
                    return true;
            }
        } catch (SQLException se) {
            System.out.println("SQLError: " + se.getMessage()
                    + " code: " + se.getErrorCode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}

