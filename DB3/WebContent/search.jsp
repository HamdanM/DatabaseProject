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
<a href="addItem.jsp">Add Item</a>
<a href="favlist">Favorite List</a>
<a href="favUsersList">fav User List</a>
<a href="favUsersList">fav User List</a>
<a href="list">item List</a>
<a href="sellers">Look at Sellers</a>


 <form action="search" method="post">
        <input type="hidden" name="action"" >
        <p style="color:green"><label>Search Item by Category: <input
                    type="text" name="Category"
                    size="60" maxlength="70" />
          <input style="height:30px;width:125px" type="submit" name="submit" value="Submit" />	
                    
            </label></p>
 </form>
     
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Items</h2></caption>
            <tr>
                <th>user ID</th>
                <th>Title</th>
                <th>Description</th>
          
            </tr>
            <c:forEach var="it" items="${itemsList}">
                <tr>
                    <td><c:out value="${it.getItemid()}" /></td>
                    <td><c:out value="${it.getTitle()}" /></td>
                    <td><c:out value="${it.getDescription()}" /></td>
                    
                </tr>
            </c:forEach>
        </table>
    </div>   

</body>
</html>