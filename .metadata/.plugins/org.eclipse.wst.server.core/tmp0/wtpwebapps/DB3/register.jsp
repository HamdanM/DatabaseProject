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
<div id="Register" class="tab">
    <h1>Register</h1>
</div>

<script>


// Function to check Whether both passwords 
// is same or not. 
function checkPassword(form) { 
    password1 = form.password.value; 
    password2 = form.password1.value; 

    if (password1 == '') 
        alert ("Please enter Password"); 
    else if (password2 == '') 
        alert ("Please enter confirm password"); 
    else if (password1 != password2) { 
        alert ("\nPassword did not match: Please try again...") 
        return false; 
    }else{
    	return true;
    }
    
    

} 

</script>
<form onSubmit = "return checkPassword(this)" action="register"
          method="post">
        <input type="hidden" name="action" value="addToMailingList" >
        <p style="color:green"><label>Username: <input
                    type="text" name="Username"
                    size="70" maxlength="70" />
            </label></p>
        <p style="color:red"><label>Password: <input
                    type="password" name="Password"
                    size="70" maxlength="70" />
            </label></p>
             <p style="color:red"><label>Password: <input
                    type="password" name="Password1"
                    size="70" maxlength="70" />
            </label></p>
        <p style="color:red"><label>First Name: <input
                    type="text" name="FirstName"
                    size="70" maxlength="70" />
            </label></p>
        <p style="color:red"><label>Last Name: <input
                    type="text" name="LastName"
                    size="70" maxlength="70" />
            </label></p>
        
        <p style="color:red"><label>Email: <input
                    type="text" name="Email"
                    size="70" maxlength="70" />
            </label></p>    
        
        <p style="color:red"><label>Gender: <input
                    type="text" name="Gender"
                    size="70" maxlength="70" />
            </label></p>    
            
        <p style="color:red"><label>Age: <input
                    type="text" name="Age"
                    size="70" maxlength="70" />
            </label></p>

        <p style="color:orange"><input style="height:120px;width:225px" type=
        "submit" name="submit" value=
        "Register" /></p>
</form>

</body>
</html>