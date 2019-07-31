<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Online Store</title>
</head>
<body>
<a href="addItem.jsp">Add Item</a>
<a href="favlist">Favorite List</a>
<a href="favUsersList">fav User List</a>
<a href="search.jsp">Search</a>
<a href="sellers">Look at Sellers</a>

    <center>
        <h1>Item Management</h1>
        <h2>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Items</h2></caption>
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
                    
                    <td>
                      <a href="addFav?id=<c:out value='${it.getItemid()}' />&user=<c:out value='${it.getUser()}' />">add Fav Item</a>
                      </td>
                    <td>
                      <a href="addFavUser?id=<c:out value='${it.getUser()}' />">add Fav User</a>
                      </td>   
                      <td>
                        <a href="addReview?id=<c:out value='${it.getItemid()}' />">add Review</a>
                        
                       <td>
              
                            
                 
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>