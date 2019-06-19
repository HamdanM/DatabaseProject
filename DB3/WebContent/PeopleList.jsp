<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Online Store Application</title>
</head>
<body>
    <center>
        <h1>List Items</h1>
        <h2>
           <!--  <a href="new">Add New People</a> -->
            &nbsp;&nbsp;&nbsp;
            <a href="list">Initialize Database</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption> <h2>List of Items</h2></caption>
            <tr>
                <th>ID</th>
                <th>title</th>
                <th>description</th>
                <th>date</th>
                <th>price</th>
                <th>category</th>
 
            </tr>
            <c:forEach var="item" items="${listItems}">
                <tr>
                    <td><c:out value="${item.id}" /></td>
                    <td><c:out value="${item.title}" /></td>
                    <td><c:out value="${item.description}" /></td>
                    <td><c:out value="${item.date}" /></td>
                    <td><c:out value="${item.price}" /></td>
                    <td><c:out value="${item.category}" /></td>
                    <td>
                       <%--  <a href="edit?id=<c:out value='${people.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=<c:out value='${people.id}' />">Delete</a>    --%>                  
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>