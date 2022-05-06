package ModuleStudents;
import Helpers.DBUtils;

import java.sql.*;
import static Helpers.DBUtils.getDbConnection;

public class Student_BIBM_lv4{

    private Connection con;

    public Student_BIBM_lv4() {
        try {
            con = DBUtils.getDbConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void enroll(String firstName, String secondName, String phoneNumber, String address) {

        try {
            String enroll = "INSERT INTO bibm_lv4(first_name,second_name,phone_number,address)" + "VALUES(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(enroll);
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setString(3, phoneNumber);
            statement.setString(4, address);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet get() {

        try {
            String select = "SELECT * FROM bibm_lv4";
            PreparedStatement statement = con.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

