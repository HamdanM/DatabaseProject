<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="addITem">Add Item</a>
<a href="addReview">Add Review</a>
<a href="favlist">Favorite List</a>
<a href="itemList">item List</a>
<a href="itemReview">Item Review</a>
<a href="seller">Look at Sellers</a>

 <form action="search" method="post">
        <input type="hidden" name="action"" >
        <p style="color:green"><label>Search Item: <input
                    type="text" name="item"
                    size="70" maxlength="70" />
            </label></p>
        <p style="color:orange"><input style="height:120px;width:225px" type=
        "submit" name="submit" value=
        "Submit" /></p>			
 </form>
     
     <table border="1" cellpadding="5">
            <caption><h2>List of Items</h2></caption>
            <tr>
                <th>Item ID</th>
                <th>User ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Date</th>
          
            </tr>
            <c:forEach var="item" items="${item}">
                <tr>
                    <td><c:out value="${item.ItemID}" /></td>
                    <td><c:out value="${item.User_UserID}" /></td>                
                    <td><c:out value="${itemFound.Title}" /></td>
                    <td><c:out value="${item.Description}" /></td>
                    <td><c:out value="${item.Date}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${item.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${item.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>