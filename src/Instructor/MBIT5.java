package Instructor;


import Helpers.DBUtils;
import Helpers.Config;

import java.sql.*;
import static Helpers.DBUtils.getDbConnection;

public class MBIT5{

    private Connection con;

    public MBIT5() {
        try {
            con = DBUtils.getDbConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void mark(String StudentID,int m1,int m2,int m3,int m4,int m5,int m6) {

        try {
            String mark = "INSERT INTO mbit5(student_id,5CS037,5CS019,5CS021,5CS022,5CS024,5CS020)" + "VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(mark);
            statement.setString(1, StudentID);
            statement.setInt(2,m1);
            statement.setInt(3,m2);
            statement.setInt(4,m3);
            statement.setInt(5,m4);
            statement.setInt(6,m5);
            statement.setInt(7,m6);



            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ResultSet get() {

        try {
            String select = "SELECT * FROM mbit5";
            PreparedStatement statement = con.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

