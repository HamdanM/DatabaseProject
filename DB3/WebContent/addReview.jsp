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
<a href="addItem.jsp">Add Item</a>
<a href="favlist">Favorite List</a>
<a href="list">item List</a>
<a href="favUsersList">fav User List</a>
<a href="search.jsp">Search</a>
<a href="sellers">Look at Sellers</a>
                   
<form action="insertreview"
          method="post">

        <table border="1" cellpadding="5">
      		 <tr>
                <th>Item ID: </th>
                <td>
                <c:if test="${item != null}">
                    <input type="text" name="Itemid" readonly value="<c:out value='${item.itemid}' />" />
                </c:if>   
                 </td>
            </tr>      
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="Title" readonly size="15"
                            value="<c:out value='${item.title}' />" />
                </td>
            </tr>
            <tr>
                <th>Score: </th>
                <td>
				<select name="Score">
					<option value="Excellent">Excellent</option>
					<option value="Good">Good</option>
					<option value="Fair">Fair</option>
					<option value="Poor">Poor</option>
				</select>
                </td>
            </tr>
            <tr>
                <th>Description/review: </th>
                <td>
                    <input type="text" name="ShortRemark" width="40" height="4"/>
                </td>
            </tr>
            
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="submit" value="Add a Review" />
                </td>
            </tr>
        </table>
   
          
       
         
       
</form>
<div>

</div>
</body>
</html>

