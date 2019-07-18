
///////////////////////////////////////////
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;




////////////////////////////////////
@WebServlet("/Login")

public class Login extends HttpServlet { 
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
  
  public boolean login(String username, String password)throws ServletException, IOException, SQLException  {

	  boolean found = false;
connect_func();
	  
      String query1 = "select Username from User where Username = '"+ username + "' AND Password = '"+ password + "'";
      
      preparedStatement = connect
              .prepareStatement(query1);


      ResultSet result = preparedStatement.executeQuery(query1);
      int count = 0;
      while(result.next()) {
    	  System.out.println(result.getString("Username"));
    	  count++;
      }
      if(count == 1) {
    	  System.out.println("Login successful"); 
    	  found = true;
      }
      else{
    	  System.out.println("Wrong input");
    	  found = false;   	  
      }
      System.out.println(count);
      
  
  
	return found;
  }
}
  



