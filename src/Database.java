import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Arrays;

public class Database {
    private String databaseURL;
    private Connection connection;

    Database() throws SQLException {
        databaseURL = "jdbc:ucanaccess://db.mdb";
        connection = DriverManager.getConnection(databaseURL);
    }
    public ResultSet getTable(String tableName) throws java.sql.SQLException{
        String sql  = "SELECT * FROM " + tableName +";";
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }
    public ResultSet getData(String tableName, String condition) throws java.sql.SQLException{
        String sql = "SELECT * FROM " + tableName + " " +  condition;
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }
    
    public int updateUser(String[] values, String condition) {
    	String sql = "UPDATE user SET Username=?, Password=?, Type=? WHERE Username=?";
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, values[0]);
			preparedStatement.setString(2, values[1]);
			preparedStatement.setString(3, values[2]);
			preparedStatement.setString(4, condition);
			if(preparedStatement.executeUpdate() != -1) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return -1;
    }
    
    public int insertUser(String username, String password, String userType) {
    	String sql = "INSERT INTO user VALUES (?, ?, ?);";
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, userType);
			if(preparedStatement.executeUpdate() != -1) {
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return -1;
    }

    public boolean deleteUser(String username) {
    	String sql = "DELETE FROM user WHERE Username=?";
    	try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			if(preparedStatement.executeUpdate() != -1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    }
    
    public Boolean verifyuser(String username, char[] password) throws java.sql.SQLException{
        String sql = "SELECT * FROM user WHERE Username=? AND Password=?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, String.valueOf(password));
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return true;
        }
        return false;
    }
}
