import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PeopleDAO peopleDAO;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
 
    public void init() {
        peopleDAO = new PeopleDAO(); 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
        String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	System.out.println(username);
    	System.out.println(password);
    	 try {
             Class.forName("com.mysql.jdbc.Driver");
             connect = (Connection) DriverManager
     			      .getConnection("jdbc:mysql://localhost:3306/projectdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "john","pass1234");
               System.out.println(connect);
               
               Statement start = connect.createStatement(); 
               ResultSet rs = start.executeQuery("SELECT userid,password FROM Users WHERE userid = '"+username+"' and password = '"+password+"'");
               
               if(rs.next()) {
            	   HttpSession session = request.getSession();
            	   session.setAttribute("name", username);
            	   //response.sendRedirect("PeopleList.jsp");
            	   listPeople(request, response); 
            	      
            	   
            	   
               }else {
            	   System.out.println("wrong username or password");
       			
               }
                
                 
         } catch (ClassNotFoundException e) {
             e.printStackTrace(); 
         } catch (SQLException e) {
        	 e.printStackTrace();
         }
         
      
    	

        
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
    
			

   }
		
    
    private void listPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Item> listItems = peopleDAO.listAllPeople();
        request.setAttribute("listItems", listItems);       
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleList.jsp");       
        dispatcher.forward(request, response);
    }
 
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Item existingItem = peopleDAO.getPeople(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleForm.jsp");
        request.setAttribute("item", existingItem);
        dispatcher.forward(request, response);
 
    }
// 
    private void insertPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String firstname = request.getParameter("firstname");
    	String lastname = request.getParameter("lastname");
    	String email = request.getParameter("email");
    	int gender = Integer.parseInt(request.getParameter("gender"));
    	int age = Integer.parseInt(request.getParameter("age"));
    
//        User newPeople = new User( userid,  password,  firstname,  lastname,email, gender,  age);
//        peopleDAO.insert(newPeople);
//        response.sendRedirect("list");
      	 try {
             Class.forName("com.mysql.jdbc.Driver");
             connect = (Connection) DriverManager
     			      .getConnection("jdbc:mysql://localhost:3306/projectdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "john","pass1234");
               System.out.println(connect);
               
               Statement start = connect.createStatement();
               int rs = start.executeUpdate("insert into Users(UserID, Password, FirstName, LastName, Email, Gender, Age) values "
               		+ "( '"+username+"',  '"+password+"',  '"+firstname+"',  '"+lastname+"',  '"+email+"',  '"+gender+"','"+age+"');");
               
               if(rs != 0) {
            	   HttpSession session = request.getSession();
            	   session.setAttribute("name", username);
            	   //response.sendRedirect("PeopleList.jsp");
            	   //listPeople(request, response); 
            	   RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
       	           dispatcher.forward(request, response);
            	   
               }else {
            	   System.out.println("wrong username or password");
       			RequestDispatcher dispatcher = request.getRequestDispatcher("Register.jsp");
    	        dispatcher.forward(request, response);
               }
                
                 
         } catch (ClassNotFoundException e) {
             e.printStackTrace(); 
         } catch (SQLException e) {
        	 e.printStackTrace();
         }
         
		
	
    }
// 
//    private void updatePeople(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        
//        System.out.println(id);
//        String name = request.getParameter("name");
//        String address = request.getParameter("address");
//        String status = request.getParameter("status");
//        
//        System.out.println(name);
//        
//        People people = new People(id,name, address, status);
//        peopleDAO.update(people);
//        response.sendRedirect("list");
//    }
 
//    private void deletePeople(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        //People people = new People(id);
//        peopleDAO.delete(id);
//        response.sendRedirect("list"); 
//    }

}