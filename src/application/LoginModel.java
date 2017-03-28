package application;

import java.sql.*;

public class LoginModel {
	Connection connection;
	
	public LoginModel () {
		 connection = SqliteConnection.Connector();
		 if (connection == null){
			 System.exit(1);
		 }
		 
		 }
	public boolean isDbConnected(){
		 try {
			return !connection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean isLogin (String user, String pass) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		String query = "select * from Login where username = ? and password = ?";
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			
			resultset = preparedStatement.executeQuery();
			if (resultset.next()){
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		} finally {
			preparedStatement.close();
			resultset.close();
		}
	}
	
}
