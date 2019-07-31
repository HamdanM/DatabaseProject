<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Online Store</title>
</head>
<body>
<a href="root.jsp">root page</a>
<form action="problemfive" method="post">
        <input type="hidden" name="action"" >
        <label>choose user id: <input
                    type="text" name="user1"
                    size="60" maxlength="70" />
        <label>choose user id: <input
                    type="text" name="user2"
                    size="60" maxlength="70" />
        
          <input style="height:30px;width:125px" type="submit" name="submit" value="Submit" />	
                    
            </label></p>
 </form>


            <caption><h2>List the other users who are favorited by both users X and Y..</h2></caption>


  <div align="center">
        <table border="1" cellpadding="5">
            <tr>
            
                <th>users</th>
         
            
          
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