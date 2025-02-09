
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Register")

public class Register extends HttpServlet {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connect = null;
	  private static PreparedStatement preparedStatement = null;
	  
	  protected void connect_func() throws SQLException {
	        if (connect == null || connect.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	       
		     // Setup the connection with the DB
		    	 connect = (Connection) DriverManager
	    			      .getConnection("jdbc:mysql://localhost:3306/projectdb?useSSL=FALSE&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "john","pass1234");
	  System.out.println(connect);
		    	
	        }
	    }
	   protected void disconnect() throws SQLException {
	        if (connect != null && !connect.isClosed()) {
	        	connect.close();
	        }
	    }
	  
	  public void register(String username, String password, String firstname, String lastname, String email, String gender, String age) throws SQLException, ClassNotFoundException {
	  
	    connect_func();
	    	
	    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
	    	preparedStatement = connect
	    			.prepareStatement("insert into  User(Username, Password, FirstName, LastName, Email, Gender, Age, Level) values (?, ?, ?, ?, ?, ?, ?, ?)");
	    	preparedStatement.setString(1, username);
	    	preparedStatement.setString(2, password);
	    	preparedStatement.setString(3, firstname);
	    	preparedStatement.setString(4, lastname);
	    	preparedStatement.setString(5, email);
	    	preparedStatement.setString(6, gender);
	    	preparedStatement.setString(7, age);
	    	preparedStatement.setString(8, "0");
	    	preparedStatement.executeUpdate();

	      
	  
	    ///////////////////////////////////////////////////////////////////////////////////////////////////
	  }
}

