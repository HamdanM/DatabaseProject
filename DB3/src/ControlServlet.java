import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;

import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Connection connect = null;
	  private static PreparedStatement preparedStatement = null;
	
	private Users user;
    private Reviews review;
    private Items item;
    private InitializeDatabase initDB;
	private Register register;
	private FavSellers favs;
	HttpSession session;
	private User users;
	private root root;
    /**
     * @see HttpServlet#HttpServlet()
     */
   
   public void init() {
	   user = new Users();
	   item = new Items();
	   initDB = new InitializeDatabase();
	   register = new Register();
	   review = new Reviews();
	   favs = new FavSellers();
	   users = new User();
	   root = new root();

   }
   
   protected void connect_func() throws SQLException, ClassNotFoundException {
       if (connect == null || connect.isClosed()) {
           try {
               Class.forName("com.mysql.jdbc.Driver");
           } catch (ClassNotFoundException e) {
               throw new SQLException(e);
           }
           // This will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.jdbc.Driver");
	        // Setup the connection with the DB
	     // Setup the connection with the DB
	    	 connect = (Connection) DriverManager
   			      .getConnection("jdbc:mysql://localhost:3306/projectdb?useSSL=FALSE&allowPublicKeyRetrieval=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "john","pass1234");
 System.out.println(connect);
	    	
       }
   }
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 System.err.close();
	        System.setErr(System.out);
		String action = request.getServletPath();
		System.out.println(action);
		String name = request.getParameter("username");
		System.out.println(name);
		System.out.println("we are linked");
		try {
			switch (action) {
			case "/build":
				System.out.println("we are inside build");
				buildDatabase(request, response);
				break;
			case "/login":
				System.out.println("we are inside login");
				loginUser(request, response);
				break;
			case "/register":
				System.out.println("we are inside register");
				registerUser(request, response);
				break;
			case "/search":
				System.out.println("we are inside search ");
				searchItem(request, response);
				break;
			case "/insertItem":
				System.out.println("we are inside insertItem");
				insertItem(request, response);
				break;
			case "/insertreview":
				System.out.println("we are inside insertReview");
				insertReview(request, response);
				break;
			case "/sellers":
				System.out.println("we are inside sellers");
				sellers(request, response);
				break;
			case "/list":
				System.out.println("we are inside list");
				listItems(request, response);
				break;
			case "/addReview":
				System.out.println("we are inside addReview");
                showEditForm(request, response);
			case "/favlist":
				System.out.println("we are inside favlist");
				favList(request,response);
			case "/addFav":
				System.out.println("we are inside addFav");
				addFav(request,response);
			case "/deleteFav":
				System.out.println("we are inside addFav");
				deleteFav(request,response);
			case "/favUsersList":
				System.out.println("we are inside favUsersList");
				favUsersList(request,response);
			case "/addFavUser":
				System.out.println("we are inside addFavUser");
				addFavUser(request,response);
				
			case "/deleteFavUser":
				System.out.println("we are inside deleteFavUser");
				deleteFavUser(request,response);
				
			case "/userProfile":
				System.out.println("we are inside userProfile");
				userProfile(request,response);
				
			case "/problemtwo":
				System.out.println("we are inside 2");
				problemtwo(request,response);
				
			case "/problemthree":
				System.out.println("we are inside 3");
				problemthree(request,response);
				
			case "/problemfour":
				System.out.println("we are inside 4");
				problemfour(request,response);
				
			case "/problemfive":
				System.out.println("we are inside 5");
				problemfive(request,response);
				
			case "/problemsix":
				System.out.println("we are inside 6");
				problemsix(request,response);
				
			case "/problemseven":
				System.out.println("we are inside 7");
				problemseven(request,response);
				
			case "/problemeight":
				System.out.println("we are inside 8");
				problemeight(request,response);
			case "/problemnine":
				System.out.println("we are inside 9");
				problemnine(request,response);
			case "/problemten":
				System.out.println("we are inside 10");
				problemten(request,response);
			default:
				System.out.println("Error 404");
				break;
			}
		}
		catch (SQLException ex) { 
			throw new ServletException(ex);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	private void problemten(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void problemnine(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		List<User> itemsList=root.displaynum9();
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Displaynum9.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void problemeight(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		List<User> itemsList=root.displaynum8();
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Displaynum8.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void problemseven(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> itemsList=root.displaynum7();
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Displaynum7.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void problemsix(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = request.getParameter("userid");

		List<User> itemsList=root.displaynum6(userid);
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Displaynum6.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	private void problemfive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub

		String user1 = request.getParameter("user1");
		String user2 = request.getParameter("user2");

		List<User> itemsList=root.displaynum5(user1, user2);
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Displaynum5.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	private void problemfour(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		List<User> itemsList=root.displaynum4();
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Displaynum4.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void problemthree(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int userid = Integer.parseInt(request.getParameter("userid"));

		List<Item> itemsList=root.displaynum3(userid);
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Displaynum3.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	private void problemtwo(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cat1 = request.getParameter("cat1");
		String cat2 = request.getParameter("cat2");

		List<User> itemsList=root.displaynum2(cat1, cat2);
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Displaynum2.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	private void userProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		
		String User = request.getParameter("id");
		System.out.println(User);
		List<Item> itemsList=item.listItembyUser(User);
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("userprofile.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	private void deleteFavUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		 String friend = request.getParameter("id");
		
		 System.out.println(friend);
		
		 favs.deleteFavUsers(friend);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("favUsersList");
	        dispatcher.forward(request, response);
	}

	private void addFavUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
	
		String friend = request.getParameter("id");
		 String userid = users.getUsername();
		 System.out.println(friend);
		
		 favs.addFavUsers(friend,userid);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("favUsersList");
	        dispatcher.forward(request, response);
	}

	private void favUsersList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
				List<FavList> favsList = favs.listFavsUsers();
			    request.setAttribute("favsList", favsList);       
				RequestDispatcher dispatcher = request.getRequestDispatcher("favUser.jsp");
				dispatcher.forward(request, response);
				// TODO Auto-generated method stub
				response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void deleteFav(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		 String userid = request.getParameter("id");
		 System.out.println(userid);
		
		 favs.deleteFav(userid);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("favlist");
	        dispatcher.forward(request, response);
	}

	private void addFav(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		 int itemid = Integer.parseInt(request.getParameter("id"));
		 String userid = request.getParameter("user");
		 System.out.println(itemid);
		
		 favs.addFav(itemid,userid);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("favlist");
	        dispatcher.forward(request, response);
	}

	private void favList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		request.getSession();
		
		// TODO Auto-generated method stub
		List<FavList> favsList = favs.listFavs();
	    request.setAttribute("favsList", favsList);       
		RequestDispatcher dispatcher = request.getRequestDispatcher("favList.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("we are inside addReview");

		 int id = Integer.parseInt(request.getParameter("id"));
		 System.out.println(id);
	        Item existingItem = item.getItem(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("addReview.jsp");
	        request.setAttribute("item", existingItem);
	        dispatcher.forward(request, response);
	}

	protected void buildDatabase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		initDB.build();
		
		System.out.println("We are linked");
		RequestDispatcher dispatcher = request.getRequestDispatcher("initializeDatabase.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());		
	}
	
	protected void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		boolean found = false;
		Login login = new Login();
		System.out.println("We are linked");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		found = login.login(username, password);
		System.out.println(found);
		//response.sendRedirect("login.jsp");
		
		if(found) {
			//sellers(request, response);
				users.setUsername(username);
				
			   session=request.getSession();  
			   System.out.println(session);
 		       session.setAttribute("username",username); 
 		    if(username == "root") {
 		    	RequestDispatcher dispatcher = request.getRequestDispatcher("root.jsp");
 	 			dispatcher.forward(request, response);
			
 		    }else{
 		    	listItems(request,response);
 		    }
		}else if(!found) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
 			dispatcher.forward(request, response);
		}
			
//		request.setAttribute("found", found);
//
//		RequestDispatcher dispatcher = request.getRequestDispatcher("itemList.jsp");
//		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());		
	}

	protected void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		System.out.println("We are linked");
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String firstname = request.getParameter("FirstName");
		String lastname = request.getParameter("LastName");
		String email = request.getParameter("Email");
		String gender = request.getParameter("Gender");
		String age = request.getParameter("Age");
		register.register(username, password, firstname, lastname, email, gender, age);
		request.setAttribute("register", register);
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());		
	}
	
	
	protected void searchItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		String category = request.getParameter("Category");
		List<Item> itemsList=item.searchItem(category);
		request.setAttribute("itemsList", itemsList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	protected void insertItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		System.out.println("We are linked in insertItem");
		
		//int username = request.getParameter("title");
		String username = users.getUsername();
		System.out.println(username);
		String title = request.getParameter("Title");
		String description = request.getParameter("Description");
		String tags = request.getParameter("posterid");
		int price = Integer.parseInt(request.getParameter("price"));	
		

		item.insertItem( username, title, description,tags,price);

		listItems(request,response);
		//request.setAttribute("register", register);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("seller.jsp");
//		dispatcher.forward(request, response);
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());	
		
		
	}
	
protected void insertReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
	String itemID = request.getParameter("Itemid");
	//String title = request.getParameter("Title");
	String score = request.getParameter("Score");
	String shortremark = request.getParameter("ShortRemark");

	review.insertReview(itemID, score, shortremark);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("list");
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}
protected void sellers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
	List<User> usersList = user.listUsers();
    request.setAttribute("usersList", usersList);       
	RequestDispatcher dispatcher = request.getRequestDispatcher("seller.jsp");
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
	
}
protected void listItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
	
	
	List<Item> itemsList=item.listItem();
	request.setAttribute("itemsList", itemsList);
	RequestDispatcher dispatcher = request.getRequestDispatcher("itemList.jsp");
	dispatcher.forward(request, response);
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());
}

protected boolean islogginin() {
	return false;
	
	
}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//InitializeDatabase build = new InitializeDatabase();
	
	}

}