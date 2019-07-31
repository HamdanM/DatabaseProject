
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/root")
public class root extends HttpServlet {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connect = null;
	  private static PreparedStatement preparedStatement = null;
	  private static Statement statement = null;
	  
	  private int count =0;
	  
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
	  


	  
	  public List<User> displaynum2(String cat1, String cat2) throws SQLException {
	        List<User> usersList = new ArrayList<User>();
	  
		        connect_func();
			    	
			    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
			    
			    String sql = "select * from User where Username in (select refUser from Items where posterid='"+cat1+"' union select refUser from Items where posterid ='"+cat2+"' and postTime > '2015-02-22 01:02:32') ";
			         				         
				preparedStatement = (PreparedStatement) connect.prepareStatement(sql);


		        ResultSet resultSet = preparedStatement.executeQuery();
				       	
			    	  while (resultSet.next()) {
			    		  int userid1 = resultSet.getInt("UserID");
			              String Username = resultSet.getString("Username");
			              String Firstname = resultSet.getString("Firstname");
			              String Lastname = resultSet.getString("Lastname");
			              String Email= resultSet.getString("Email");
			              String Gender =resultSet.getString("Gender");
			              int Age =resultSet.getInt("Age");
			              int level = resultSet.getInt("Level");
			             User user = new User(userid1, Username, Firstname, Lastname, Email, Gender,Age,level);
			             usersList.add(user);
			    	  }

				    	System.out.println(usersList);

			  
				return usersList;
			  }
	  
	  
	  
	  public List<Item> displaynum3(int User) throws SQLException {
	      //User user = null;  
		  List<Item> itemsList = new ArrayList<Item>();
		    	
	        
		    	   String sql = "select * from Items where itemid in (select Item_ItemID from Reviews where User_UserID="+User+" and (Score='Excellent' or Score='Good') )";
					  connect_func();

			     
			        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			        //preparedStatement.setInt(1, User );
		    	
		    	ResultSet resultSet = preparedStatement.executeQuery();
		    	
		    	
		    	  while (resultSet.next()) {
		    		  int itemid1 = resultSet.getInt("itemid"); 
		              String Title = resultSet.getString("title");
		              String Description = resultSet.getString("description");
		              String tags = resultSet.getString("posterid");
		              String date= resultSet.getString("postTime");
		              int price =resultSet.getInt("price");
		              String user = resultSet.getString("refUser");
		              Item item =  new Item(itemid1, Title, Description, date, tags,price,user);

		              itemsList.add(item);  
		    	  }

		    System.out.println(itemsList);
		    ///////////////////////////////////////////////////////////////////////////////////////////////////
			return itemsList;
		  }

	  
	  public List<User> displaynum4() throws SQLException {
	        List<User> usersList = new ArrayList<User>();
	  
		        connect_func();
			    	
			    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
			    
			    String sql = "select * from User where Username in (select refUser from Items where postTime > '2012/01/25 12:59:11')";
			         				         
				preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			         
		        ResultSet resultSet = preparedStatement.executeQuery();
				       	
			    	  while (resultSet.next()) {
			    		  int userid1 = resultSet.getInt("UserID");
			              String Username = resultSet.getString("Username");
			              String Firstname = resultSet.getString("Firstname");
			              String Lastname = resultSet.getString("Lastname");
			              String Email= resultSet.getString("Email");
			              String Gender =resultSet.getString("Gender");
			              int Age =resultSet.getInt("Age");
			              int level = resultSet.getInt("Level");
			             User user = new User(userid1, Username, Firstname, Lastname, Email, Gender,Age,level);
			             usersList.add(user);

			    	  }

				    	System.out.println(usersList);

			  
				return usersList;
			  }
	  
	  
	  public List<User> displaynum5(String user1, String user2) throws SQLException {
	        List<User> usersList = new ArrayList<User>();
	  
		        connect_func();
			    	
			    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
			    
			    String sql = "SELECT * FROM User WHERE Username IN (SELECT friendUserID FROM FavUsers WHERE userid='"+user1+"' UNION SELECT friendUserID from FavUsers WHERE userid='"+user2+"' ) ";
			         				         
				preparedStatement = (PreparedStatement) connect.prepareStatement(sql);

		        ResultSet resultSet = preparedStatement.executeQuery();
				       	
			    	  while (resultSet.next()) {
			    		  int userid1 = resultSet.getInt("UserID");
			              String Username = resultSet.getString("Username");
			              String Firstname = resultSet.getString("Firstname");
			              String Lastname = resultSet.getString("Lastname");
			              String Email= resultSet.getString("Email");
			              String Gender =resultSet.getString("Gender");
			              int Age =resultSet.getInt("Age");
			              int level = resultSet.getInt("Level");
			             User user = new User(userid1, Username, Firstname, Lastname, Email, Gender,Age,level);
			             usersList.add(user);
			    	  }

				    	System.out.println(usersList);

			  
				return usersList;
			  }
	  
	  public List<User> displaynum6(String User) throws SQLException {
		  List<User> usersList = new ArrayList<User>();
		    	
	        
		    	   String sql = "SELECT * FROM User WHERE UserID IN (SELECT User_UserID FROM Reviews WHERE User_UserID=? and (Score = 'Excellent' OR Score = 'Good')) ";
					  connect_func();

			     
			        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			        preparedStatement.setString(1, User );
		    	
		    	ResultSet resultSet = preparedStatement.executeQuery();
		    	
		    	
		    	  while (resultSet.next()) {
		    		  int userid1 = resultSet.getInt("UserID");
		              String Username = resultSet.getString("Username");
		              String Firstname = resultSet.getString("Firstname");
		              String Lastname = resultSet.getString("Lastname");
		              String Email= resultSet.getString("Email");
		              String Gender =resultSet.getString("Gender");
		              int Age =resultSet.getInt("Age");
		              int level = resultSet.getInt("Level");
		             User user = new User(userid1, Username, Firstname, Lastname, Email, Gender,Age,level);
		             usersList.add(user);
		    	  }

		    System.out.println(usersList);
		    ///////////////////////////////////////////////////////////////////////////////////////////////////
			return usersList;
		  }
	  
	  public List<User> displaynum7() throws SQLException {
		  List<User> usersList = new ArrayList<User>();
		    	
	        
		    	   String sql = "SELECT * FROM User WHERE UserID IN (SELECT User_UserID FROM Reviews WHERE Score != 'poor') ";
					  connect_func();

			     
			        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			       
		    	
		    	ResultSet resultSet = preparedStatement.executeQuery();
		    	
		    	
		    	  while (resultSet.next()) {
		    		  int userid1 = resultSet.getInt("UserID");
		              String Username = resultSet.getString("Username");
		              String Firstname = resultSet.getString("Firstname");
		              String Lastname = resultSet.getString("Lastname");
		              String Email= resultSet.getString("Email");
		              String Gender =resultSet.getString("Gender");
		              int Age =resultSet.getInt("Age");
		              int level = resultSet.getInt("Level");
		             User user = new User(userid1, Username, Firstname, Lastname, Email, Gender,Age,level);
		             usersList.add(user);
		    	  }

		    System.out.println(usersList);
		    ///////////////////////////////////////////////////////////////////////////////////////////////////
			return usersList;
		  }
	  
	  
	  public List<User> displaynum8() throws SQLException {
		  List<User> usersList = new ArrayList<User>();
		    	
	        
		    	   String sql = "SELECT * FROM User WHERE UserID IN (SELECT User_UserID FROM Reviews WHERE Score = 'Poor') ";
					  connect_func();

			     
			        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			       
		    	
		    	ResultSet resultSet = preparedStatement.executeQuery();
		    	
		    	
		    	  while (resultSet.next()) {
		    		  int userid1 = resultSet.getInt("UserID");
		              String Username = resultSet.getString("Username");
		              String Firstname = resultSet.getString("Firstname");
		              String Lastname = resultSet.getString("Lastname");
		              String Email= resultSet.getString("Email");
		              String Gender =resultSet.getString("Gender");
		              int Age =resultSet.getInt("Age");
		              int level = resultSet.getInt("Level");
		             User user = new User(userid1, Username, Firstname, Lastname, Email, Gender,Age,level);
		             usersList.add(user);
		    	  }

		    System.out.println(usersList);
		    ///////////////////////////////////////////////////////////////////////////////////////////////////
			return usersList;
		  }
	  
	  
	  public List<User> displaynum9() throws SQLException {
		  List<User> usersList = new ArrayList<User>();
		    	
	        
		    	   String sql = "SELECT * FROM User WHERE UserID IN (SELECT User_UserID FROM Reviews WHERE Score != 'poor')";
					  connect_func();

			     
			        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			       
		    	
		    	ResultSet resultSet = preparedStatement.executeQuery();
		    	
		    	
		    	  while (resultSet.next()) {
		    		  int userid1 = resultSet.getInt("UserID");
		              String Username = resultSet.getString("Username");
		              String Firstname = resultSet.getString("Firstname");
		              String Lastname = resultSet.getString("Lastname");
		              String Email= resultSet.getString("Email");
		              String Gender =resultSet.getString("Gender");
		              int Age =resultSet.getInt("Age");
		              int level = resultSet.getInt("Level");
		             User user = new User(userid1, Username, Firstname, Lastname, Email, Gender,Age,level);
		             usersList.add(user);
		    	  }

		    System.out.println(usersList);
		    ///////////////////////////////////////////////////////////////////////////////////////////////////
			return usersList;
		  }
	  
	  
	  
	  public List<User> displaynum10() throws SQLException {
	        List<User> userList = new ArrayList<User>();
	  
		        connect_func();
			    	
			    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
			    
			    String sql = "select refUser from Items where postTime > '2012/01/25 12:59:11' ";
			         				         
				preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			         
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
			              userList.add(user); 
			    	  }

				    	System.out.println(userList);

			  
				return userList;
			  }
	  
	 
	
	  
}

