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
            <caption><h2>Display all the users who never posted a poor review.</h2></caption>

  <div align="center">
        <table border="1" cellpadding="5">
            <tr>
            
                <th>Users</th>
         
            
          
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