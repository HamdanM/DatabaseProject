<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="addItem.jsp">Add Item</a>
<a href="list">item List</a>
<a href="favUsersList">fav User List</a>
<a href="search.jsp">Search</a>
<a href="sellers">Look at Sellers</a>

<div id="FavList" class="tab">
    <h1>Favorite List</h1>
    
      <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Favorite Items</h2></caption>
            <tr>
              <th>seller ID</th>
                <th>From user </th>
              
          
            </tr>
            <c:forEach var="fav" items="${favsList}">
                <tr>
                    <td><c:out value="${fav.getItemid()}" /></td>
                    <td><c:out value="${fav.getUser_UserID()}" /></td>
                    <td>
                        &nbsp;&nbsp;
                        <a href="deleteFav?id=<c:out value='${fav.getUser_UserID()}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
    
</div>
</body>
</html>