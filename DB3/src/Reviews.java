
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Reviews")

public class Reviews extends HttpServlet {
		
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
	  
	  public void insertReview(String itemID, String userid, String score, String shortremark) throws SQLException, ClassNotFoundException {
	    
	    	System.out.println("Select a table and then print out its content.");
	      
	    	
	    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
	    	preparedStatement = connect
	    			.prepareStatement("insert into  Reviews(Item_ItemID, User_UserID, Score, ShortRemark) values (?, ?, ?, ?)");
	    	preparedStatement.setString(1, itemID);
	    	preparedStatement.setString(2, userid);
	    	preparedStatement.setString(3, score);
	    	preparedStatement.setString(4, shortremark);
	    	preparedStatement.executeUpdate();

	      
	  
	    ///////////////////////////////////////////////////////////////////////////////////////////////////
	  }
	  public Review searchReview(int itemID, int userid, String score, String shortremark) throws SQLException {
	        Review searchresult = null;
  
		  
		    connect_func();
		    	
		    	/////////////////////////////////////////////////////////////////////////Insert tubles to User table
		    	String sql ="select Item_ItemID, User_UserID, Score, ShortRemark from Reviews where Item_ItemID="+itemID+", User_UserID="+userid+"";
		    	 preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		         preparedStatement.setInt(1, itemID);
		         preparedStatement.setInt(2, userid);
		    	
		         
		    	ResultSet resultSet = preparedStatement.executeQuery();
		    
	      
		    	if (resultSet.next()) {
		           int reviewid = resultSet.getInt("ReviewsID");
		    		 int itemid1 = resultSet.getInt("Item_ItemID");
		             int userid1 = resultSet.getInt("User_UserID");
		             String score1 = resultSet.getString("Score");
		             String shortremark1 = resultSet.getString("ShortRemark");
		             String date1 = resultSet.getString("Date");
		        searchresult = new Review(reviewid, itemid1, userid1,  score1, shortremark1,date1);
		    	}
		         

		        resultSet.close();
		        ((Connection) statement).close();
		        
		   
		    ///////////////////////////////////////////////////////////////////////////////////////////////////

		    return searchresult;
		  }

	  public boolean deleteReview(int reviewid) throws ClassNotFoundException, SQLException {
		  String sql = "DELETE FROM Reviews WHERE ReviewsID = ?";        

	    
	        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        preparedStatement.setInt(1, reviewid);
	         
	        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
	        preparedStatement.close();
//	        disconnect();
	        return rowDeleted;  
	  }

	  public boolean updateReview(Review review) throws SQLException, ClassNotFoundException {
	        String sql = "update Reviews set Item_ItemID = ?, User_UserID = ?, Score = ?, ShortRemark = ?, Date = ? where ReviewsID="+review.ReviewID+"";
	        
	     
	        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
	        preparedStatement.setInt(1, review.User_UserID);
	        preparedStatement.setString(2, review.Score);
	        preparedStatement.setString(3, review.ShortRemark);
	        preparedStatement.setString(4, review.Date);
	         
	        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
	        preparedStatement.close();
//	        disconnect();
	        return rowUpdated;     
	    }
	  
}

