package Administrator;

import Helpers.DBUtils;

import java.sql.*;

public class UserRegistration {
    private Connection con;

    public UserRegistration() {
        try {
            con = DBUtils.getDbConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    void addValues(String firstName, String secondName, String course, String status) {

        try {
            String add= "INSERT INTO users(module_id,module_name,course,level) VALUES(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(add);
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setString(3, course);
            statement.setString(4, status);

            statement.executeUpdate();
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    ResultSet get() {
        String select = "SELECT * FROM users";
        try {
            PreparedStatement statement = con.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    void update(int id, String firstName, String secondName, String phoneNumber, String status) {
        try {
            String update = "UPDATE users SET module_id=?,module_name=?,course=?,level=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(update);
            statement.setString(1, firstName);
            statement.setString(2, secondName);
            statement.setString(3, phoneNumber);
            statement.setString(4, status);
            statement.setInt(5, id);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void remove(int id) {
        String remove = "DELETE FROM users WHERE id=?";
        try {
            PreparedStatement statement = con.prepareStatement(remove);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


