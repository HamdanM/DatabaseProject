
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Users")

public class Users extends HttpServlet{
		
	private static Connection connect = null;
	  private static PreparedStatement preparedStatement = null;
	  private static Statement statement = null;
	  private static final long serialVersionUID = 1L;
		private ResultSet resultSet = null;
		
		
		
		       
	    /**
	     * @throws ClassNotFoundException 
	     * @see HttpServlet#HttpServlet()
	     */
	    protected void connect_func() throws SQLException {
	        if (connect == null || connect.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	           
		     // Setup the connection with the DB
		    	 connect = (Connection) DriverManager
	    			      .getConnection("jdbc:mysql://localhost:3306/projectdb?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "john","pass1234");
	  System.out.println(connect);
		    	
	        }
	    }
	    ///////////////////////////////////////////////////////////////////////////////////////////////////

	  public void insertUser(String username, String title, String description) throws SQLException {
		    connect_func();
		    	
		    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
		    	preparedStatement = connect
		    			.prepareStatement("insert into  Item(User_UserID, Title, Description) values (?, ?, ?)");
		    	preparedStatement.setString(1, username);
		    	preparedStatement.setString(2, title);
		    	preparedStatement.setString(3, description);
		    	preparedStatement.executeUpdate();

		      
		 
		    ///////////////////////////////////////////////////////////////////////////////////////////////////
		  }

		  public User searchUser(String username) throws SQLException, ClassNotFoundException {
			        User user = null;
		  
			
				    connect_func();
				    	
				    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
				    	preparedStatement = connect
				    			.prepareStatement("select UserID, Username, FirstName, Lastname, Email, Gender,Age,Level from User where Username="+username+"");
				    	preparedStatement.setString(1, username);
				     resultSet = preparedStatement.executeQuery();
				    	
				    	  while (resultSet.next()) {
				              int userid1 = resultSet.getInt("UserID");
				              String Username = resultSet.getString("Username");
				              String Firstname = resultSet.getString("Firstname");
				              String Lastname = resultSet.getString("Lastname");
				              String Email= resultSet.getString("Email");
				              String Gender =resultSet.getString("Gender");
				              int Age =resultSet.getInt("Age");
				              int level = resultSet.getInt("Level");
				              user = new User(userid1, Username, Firstname, Lastname, Email, Gender,Age,level);
				          }

				
					return user;
				  }
			    ///////////////////////////////////////////////////////////////////////////////////////////////////

		  public List<User> listUsers() throws SQLException {
		        List<User> usersList = new ArrayList<User>();
	 
			    connect_func();			    	
			    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
			    	preparedStatement = connect
			    			.prepareStatement("select * from User");
			    	ResultSet resultSet = preparedStatement.executeQuery();
			    	
			    	  while (resultSet.next()) {
			    		  int Userid1 = resultSet.getInt("UserID");
			              String Username = resultSet.getString("Username");
			              String Firstname = resultSet.getString("Firstname");
			              String Lastname = resultSet.getString("Lastname");
			              String Email= resultSet.getString("Email");
			              String Gender =resultSet.getString("Gender");
			              int Age =resultSet.getInt("Age");
			              int Level =resultSet.getInt("Level");

			              User user =  new User(Userid1, Username, Firstname, Lastname, Email, Gender,Age,Level);
			              usersList.add(user); 
			          }

			    	  resultSet.close();
			          preparedStatement.close();
			         disconnect();
			    ///////////////////////////////////////////////////////////////////////////////////////////////////
				return usersList;
			  }
		  
		   protected void disconnect() throws SQLException {
		        if (connect != null && !connect.isClosed()) {
		        	connect.close();
		        }
		    }

		  public boolean deleteItem(int userid) throws SQLException {
			  String sql = "DELETE FROM User WHERE UserID = ?";        

			    connect_func();

		    
		        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		        preparedStatement.setInt(1, userid);
		         
		        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
		        preparedStatement.close();
//		        disconnect();
		        return rowDeleted;  
		  }

		  public boolean update(User user) throws SQLException {
		        String sql = "update User set Username = ?, Password = ?, FirstName = ?, LastName = ?, Email = ?, Gender = ?, Age = ?, Level = ? where UserID="+user.userid+"";
			    connect_func();

		     
		        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		        preparedStatement.setInt(1, user.userid);
		        preparedStatement.setString(2, user.Username);
		        preparedStatement.setString(3, user.Password);
		        preparedStatement.setString(4, user.FirstName);
		        preparedStatement.setString(5, user.LastName);
		        preparedStatement.setString(5, user.LastName);
		        preparedStatement.setString(5, user.LastName);
		        preparedStatement.setString(5, user.Email);
		        preparedStatement.setString(5, user.Gender);
		        preparedStatement.setInt(5, user.age);
		        preparedStatement.setInt(5, user.level);


		        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
		        preparedStatement.close();
//		        disconnect();
		        return rowUpdated;     
		    }
		  
}

