<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Online Store</title>
</head>
<body>

<a href="root.jsp">root page</a>

<form action="problemtwo" method="post">
        <label>choose Category: <input
                    type="text" name="cat1"
                    size="30" maxlength="70" /><br>
        <label>choose Category: <input
                    type="text" name="cat2"
                    size="30" maxlength="70" />
          <input style="height:30px;width:125px" type="submit" name="submit" value="Submit" />	
                    
            </label></p>
 </form>

  <div >
              <h2>List the users who posted at least two items that are posted on the same day, one has a category of X and another has a category of Y. </h2>
  
        <table border="1" cellpadding="5">
            <tr>
            
                <th>username</th>
         
            
          
            </tr>
            <c:forEach var="us" items="${itemsList}">
                <tr>
		          
                    <td><c:out value="${us.getUsername()}" /></td>
                   
                  
                                         
                </tr>
            </c:forEach>
        </table>
    </div>  

</body>
</html>