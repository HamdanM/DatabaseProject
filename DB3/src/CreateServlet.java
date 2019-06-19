

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PeopleDAO peopleDAO;
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String firstname = request.getParameter("firstname");
    	String lastname = request.getParameter("lastname");
    	String email = request.getParameter("email");
    	int gender = Integer.parseInt(request.getParameter("gender"));
    	int age = Integer.parseInt(request.getParameter("age"));
    	
    	System.out.println(username); 
    	System.out.println(password);
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

}
