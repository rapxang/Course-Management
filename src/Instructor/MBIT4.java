package Instructor;


        import Helpers.DBUtils;

        import java.sql.*;
        import static Helpers.DBUtils.getDbConnection;

public class MBIT4{

    private Connection con;

    public MBIT4() {
        try {
            con = DBUtils.getDbConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void mark(String StudentID,int m1,int m2,int m3,int m4,int m5,int m6) {

        try {
            String mark = "INSERT INTO mbit4( student_id,4CI018,4CS001,4CS015,4CS016,4CS017,4MM013)" + "VALUES(?,?,?,?,?,?,?)";
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
            String select = "SELECT * FROM mbit4";
            PreparedStatement statement = con.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

