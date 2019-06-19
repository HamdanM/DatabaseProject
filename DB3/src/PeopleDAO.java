import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.Date;
//import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class Connect
 */
@WebServlet("/PeopleDAO")
public class PeopleDAO extends HttpServlet {     
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
//	private ResultSet resultSet = null;
	
	
	public PeopleDAO() {

    }
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    protected void connect_func() throws SQLException {
        if (connect == null || connect.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connect = (Connection) DriverManager
  			      .getConnection("jdbc:mysql://localhost:3306/projectdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "john","pass1234");
            System.out.println(connect);
        }
    }
    
    public List<Item> listAllPeople() throws SQLException {
        List<Item> listPeople = new ArrayList<Item>();        
        String sql = "SELECT * FROM Items";      
        connect_func();      
        statement =  (Statement) connect.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         if(resultSet == null) {
        	 createTables();
         }
		        while (resultSet.next()) {
		            int id = resultSet.getInt("id");
		            String title = resultSet.getString("title");
		            String description = resultSet.getString("description");
		            Date date = resultSet.getDate(4);
		            int price = resultSet.getInt(5);
		            String category = resultSet.getString(6);
		            
		            Item people = new Item(id,title, description, date, price, category);
		            listPeople.add(people);
		        
		        }        
		        resultSet.close();
		        statement.close();         
		        disconnect();        
		      
		    
		return listPeople;
}
    private void createTables() throws SQLException {
		// TODO Auto-generated method stub
    	String sql1 = "DROP TABLE IF EXISTS Items;";
    	String sql24 = "DROP TABLE IF EXISTS Users;";
    	String sql2 = "CREATE TABLE IF NOT EXISTS Users (id INTEGER not NULL AUTO_INCREMENT, UserID VARCHAR(30), Password VARCHAR(20),"
        		+ " FirstName VARCHAR(20), LastName VARCHAR(20), Email VARCHAR(30), Gender INTEGER not NULL, Age INTEGER, PRIMARY KEY (id));";      
        String sql3 = "CREATE TABLE IF NOT EXISTS Items" + 
        		" (id INTEGER not NULL AUTO_INCREMENT," + 
        		" title varchar(30)," + 
        		" description varchar(100)," + 
        		" date DATETIME," + 
        		" price INTEGER," + 
        		" category varchar(100)," + 
        		" PRIMARY KEY (id));";
        String sql4 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"mohammad\", \"hamdan\", \"hello@gmail.com\", 1, 23);";
        String sql5 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"mohammad\", \"hamdan\", \"hello@gmail.com\", 1, 23);";
        String sql6 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"ZAK\", \"hamdan\", \"hello@gmail.com\", 1, 23);";
        String sql7 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"mohammad\", \"hamdan\", \"hello@gmail.com\", 1, 23);";
        String sql8 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"mohammad\", \"hamdan\", \"hello@gmail.com\", 1, 23);";
        String sql9 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"mohammad\", \"hamdan\", \"hello@gmail.com\", 1, 23);";
        String sql10 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"mohammad\", \"hamdan\", \"hello@gmail.com\", 1, 23);";
        String sql11 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"mohammad\", \"hamdan\", \"hello@gmail.com\", 1, 23);";
        String sql12 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"mohammad\", \"hamdan\", \"hello@gmail.com\", 1, 23);";
        String sql13 = "insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values (\"mhamdan\", \"pass1234\", \"mohammad\", \"hamdan\", \"hello@gmail.com\", 1, 23);";

        String sql14 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        String sql15 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        String sql16 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        String sql17 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        String sql18 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        String sql19 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        String sql20 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        String sql21 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        String sql22 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        String sql23 = "insert into items (title, description, date, price, category) values (\"iphone\", \"phone you can use to text and call\", \"2019-01-05\", 1000, \"tech\");";
        
        connect_func();      
        statement =  (Statement) connect.createStatement();
        statement.executeUpdate(sql1);
        statement.executeUpdate(sql24);
        statement.executeUpdate(sql2);
        statement.executeUpdate(sql3);
        statement.executeUpdate(sql3);
        statement.executeUpdate(sql4);
        statement.executeUpdate(sql5);
        statement.executeUpdate(sql6);
        statement.executeUpdate(sql7);
        statement.executeUpdate(sql8);
        statement.executeUpdate(sql9);
        statement.executeUpdate(sql10);
        statement.executeUpdate(sql11);
        statement.executeUpdate(sql12);
        statement.executeUpdate(sql13);
        
        statement.executeUpdate(sql14);
        statement.executeUpdate(sql15);
        statement.executeUpdate(sql16);
        statement.executeUpdate(sql17);
        statement.executeUpdate(sql18);
        statement.executeUpdate(sql19);
        statement.executeUpdate(sql20);
        statement.executeUpdate(sql21);
        statement.executeUpdate(sql22);
        statement.executeUpdate(sql23);
  
	}

	protected void disconnect() throws SQLException {
        if (connect != null && !connect.isClosed()) {
        	connect.close();
        }
    }
         
    public boolean insert(User newPeople) throws SQLException {
    	connect_func();         
		String sql = "insert into  Users (id,UserID, Password, FirstName, LastName, Email, Gender, Age) values (?,?,?,?,?,?,?,?)";
		preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
		preparedStatement.setInt(1, newPeople.id);		
		preparedStatement.setString(2, newPeople.userid);
		preparedStatement.setString(3, newPeople.password);
		preparedStatement.setString(4, newPeople.firstname);
		preparedStatement.setString(5, newPeople.lastname);
		preparedStatement.setString(6, newPeople.email);
		preparedStatement.setInt(7, newPeople.gender);
		preparedStatement.setInt(8, newPeople.age);
		
		preparedStatement.executeUpdate(sql);
		
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();
        disconnect();
        return rowInserted;
    }     
//     
//    public boolean delete(int peopleid) throws SQLException {
//        String sql = "DELETE FROM student WHERE id = ?";        
//        connect_func();
//         
//        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
//        preparedStatement.setInt(1, peopleid);
//         
//        boolean rowDeleted = preparedStatement.executeUpdate() > 0;
//        preparedStatement.close();
////        disconnect();
//        return rowDeleted;     
//    }
//     
//    public boolean update(People people) throws SQLException {
//        String sql = "update student set Name=?, Address =?,Status = ? where id = ?";
//        connect_func();
//        
//        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
//        preparedStatement.setString(1, people.name);
//        preparedStatement.setString(2, people.address);
//        preparedStatement.setString(3, people.status);
//        preparedStatement.setInt(4, people.id);
//         
//        boolean rowUpdated = preparedStatement.executeUpdate() > 0;
//        preparedStatement.close();
////        disconnect();
//        return rowUpdated;     
//    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
//	public boolean getUser(String Username, String Password) throws SQLException {
//		boolean foundUser = false;
//		
//		User user = null;
//		
//		String sql = "SELECT * FROM Users WHERE userid = ? and password = ?";
//		
//		  preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
//	        //preparedStatement.setInt(1, id);
//	         
//	        ResultSet resultSet = preparedStatement.executeQuery();
//	        if(resultSet != null) {
//	        	foundUser = true;
//	        	return foundUser;
//	        }
//		
//		return foundUser;
//	}
	
    public Item getPeople(int id) throws SQLException {
    	Item people = null;
        String sql = "SELECT * FROM Items WHERE id = ?";
         
        connect_func();
         
        preparedStatement = (PreparedStatement) connect.prepareStatement(sql);
        preparedStatement.setInt(1, id);
         
        ResultSet resultSet = preparedStatement.executeQuery();
         
        if (resultSet.next()) {
        	 int id1 = resultSet.getInt("id");
             String title = resultSet.getString("title");
             String description = resultSet.getString("description");
             Date date = resultSet.getDate(4);
             int price = resultSet.getInt(5);
             String category = resultSet.getString(6);
             
            people = new Item(id1,title, description, date, price, category);
            }
         
        resultSet.close();
        statement.close();
         
        return people;
    }
}
