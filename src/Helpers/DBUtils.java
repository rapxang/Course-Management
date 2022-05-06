
package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;

public class DBUtils {
    public static Connection getDbConnection() throws SQLException {
        //jdbc:mysql://localhost:3306/phonebook
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/coursemanagement?useTimezone=true&serverTimezone=UTC";

            String dbUser = "root";
            String dbPass = "";
            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, dbUser, dbPass);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

