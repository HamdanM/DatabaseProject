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

<a href="addReview">Add Review</a>
<a href="favlist">Favorite List</a>
<a href="itemList">item List</a>
<a href="itemReview">Item Review</a>
<a href="search">Search</a>
<a href="seller">Look at Sellers</a>

<form action="insertItem"
          method="post">

        <p style="color:green"><label>title: <input
                    type="text" name="Title"
                    size="70" maxlength="70" />
            </label></p>
        <p style="color:red"><label>Description: <input
                    type="text" name="Description"
                    size="70" maxlength="250" />
            </label></p>
        <p style="color:red"><label>Tags: <input
                    type="text" name="Tags"
                    size="70" maxlength="70" />
            </label></p>
        <p style="color:orange"><input style="height:120px;width:225px" type=
        "submit" name="submit" value=
        "Add a Review" /></p>
</form>

</body>
</html>