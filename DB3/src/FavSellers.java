
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

@WebServlet("/FavSellers")

public class FavSellers extends HttpServlet {
		
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connect = null;
	  private static PreparedStatement preparedStatement = null;
	  private static Statement statement = null;

	  protected void connect_func() throws SQLException {
	        if (connect == null || connect.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	            // This will load the MySQL driver, each DB has its own driver
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
	   public List<FavList> listFavs() throws SQLException {
	        List<FavList> favsList = new ArrayList<FavList>();
	  
		        connect_func();
			    	
			    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
			    
			    String sql = "SELECT * FROM FavSellers ";
			         				         
				preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			         
		        ResultSet resultSet = preparedStatement.executeQuery();
				       	
			    	  while (resultSet.next()) {
			              String userid =resultSet.getString("userid");
			              String sellerid = resultSet.getString("sellerid");
			             
			               
			             FavList fav = new FavList(sellerid,userid);
			             favsList.add(fav); 

			    	  }

				    	System.out.println(favsList);

			  
				return favsList;
			  }
	  public void addFav(int itemID, String user) throws SQLException {
	    
	    	System.out.println("Select a table and then print out its content.");
	      
	    	connect_func();
	    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
	    	preparedStatement = connect
	    			.prepareStatement("insert into  FavSellers(userid, sellerid) values (?, ?)");
	    	preparedStatement.setString(1, user);
	    	preparedStatement.setInt(2, itemID);
	    	//preparedStatement.setString(2, userid);
	    	preparedStatement.executeUpdate();

	      
	  
	    ///////////////////////////////////////////////////////////////////////////////////////////////////
	  }
	  
	  public boolean deleteFav(String userid) throws SQLException {
		  String sql = "DELETE FROM FavSellers WHERE userid = ?";        

	    
	        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        preparedStatement.setString(1, userid);
	         
	        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
	        preparedStatement.close();
//	        disconnect();
	        return rowDeleted;  
	  }

	   public List<FavList> listFavsUsers() throws SQLException {
	        List<FavList> favsListUsers = new ArrayList<FavList>();
	  
		        connect_func();
			    	
			    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
			    
			    String sql = "SELECT * FROM FavUsers";
			         				         
				preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
			         
		        ResultSet resultSet = preparedStatement.executeQuery();
				       	
			    	  while (resultSet.next()) {
			    		  String userid = resultSet.getString("userid");
			              String friend =resultSet.getString("friendUserID");
			             
			               
			             FavList fav = new FavList(userid, friend, "list");
			             favsListUsers.add(fav); 

			    	  }

				    	System.out.println(favsListUsers);

			  
				return favsListUsers;
			  }
	  public void addFavUsers( String user, String friend) throws SQLException {
	    if(user != ""  & friend != "") {
	    	System.out.println("Select a table and then print out its content.");
	      
	    	connect_func();
	    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
	    	preparedStatement = connect
	    			.prepareStatement("insert into  FavUsers(userid, friendUserID) values (?, ?)");
	    	preparedStatement.setString(1, user);
	    	preparedStatement.setString(2, friend);
	    	preparedStatement.executeUpdate();

	      
	  
	    ///////////////////////////////////////////////////////////////////////////////////////////////////
	  }
	}
	  
	  public boolean deleteFavUsers(String friend) throws SQLException {
		
		  String sql = "DELETE FROM FavUsers WHERE friendUserID = ?";        

	    
	        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        preparedStatement.setString(1, friend);
	        preparedStatement.executeUpdate();
	        preparedStatement.close();
//	        disconnect();
	  
	        return true;  
		
			  
		  
	  }
	  
}

