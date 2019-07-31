<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Store</title>
</head>
<body>
<a href="addItem.jsp">Add Item</a>
<a href="list">item List</a>
<a href="favUsersList">fav User List</a>
<a href="search.jsp">Search</a>
<a href="sellers">Look at Sellers</a>

<div id="FavList" class="tab">

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Users Profile</h2></caption>
            <tr>
                <th>User</th>
                <th>item ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
          
            </tr>
            <c:forEach var="it" items="${itemsList}">
            
                <tr>
                    <td><c:out value="${it.getUser()}" /></td>
                    <td><c:out value="${it.getItemid()}" /></td>
                    <td><c:out value="${it.title}" /></td>
                    <td><c:out value="${it.description}" /></td>
                    <td>$<c:out value="${it.getPrice()}" /></td>               
                 
                </tr>
            </c:forEach>
        </table>
    </div>   
    
</div>
</body>
</html>