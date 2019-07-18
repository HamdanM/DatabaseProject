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
<a href="addITem">Add Item</a>
<a href="addReview">Add Review</a>
<a href="itemReview">Item Review</a>
<a href="search">Search</a>
<a href="seller">Look at Sellers</a>

<div id="FavList" class="tab">
    <h1>Favorite List</h1>
    
      <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Favorites</h2></caption>
            <tr>
                <th>user ID</th>
                <th>Title</th>
                <th>Description</th>
          
            </tr>
            <c:forEach var="fav" items="${listFav}">
                <tr>
                    <td><c:out value="${fav.userid}" /></td>
                    <td><c:out value="${fav.title}" /></td>
                    <td><c:out value="${fav.description}" /></td>
                    <td>
                        &nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${item.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
    
</div>
</body>
</html>