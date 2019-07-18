<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Review</title>
</head>
<body>
<a href="addITem">Add Item</a>
<a href="favlist">Favorite List</a>
<a href="itemList">item List</a>
<a href="itemReview">Item Review</a>
<a href="search">Search</a>
<a href="seller">Look at Sellers</a>
                   
<form action="insertReview"
          method="post">
          <label>User: </label>
        <input type="text" name="userid" maxlength="50" >
       
        <label>Score:</label>
         <input
         type="text" name="Subject"
         size="70" maxlength="70" />
            
        <label>ShortRemark:  </label>
         <input
           type="text" name="ShortRemark"
           size="70" maxlength="250" />
          
       
           
        <p style="color:orange"><input style="height:120px;width:225px" type=
        "submit" name="submit" value=
        "Add a Review" /></p>
</form>
<div>
<table border="1" cellpadding="5">
            <caption><h2>List of Reviews</h2></caption>
            <tr>
                <th>user ID</th>
                <th>Title</th>
                <th>Description</th>
          
            </tr>
            <c:forEach var="reivew" items="${review}">
                <tr>
                    <td><c:out value="${review.User_UserID}" /></td>
                    <td><c:out value="${review.Score}" /></td>
                    <td><c:out value="${review.ShortRemark}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${review.ReviewID}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${review.ReviewID}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
</div>
</body>
</html>

