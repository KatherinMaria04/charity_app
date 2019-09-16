<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>

</head>
<body>
<h3>LOGIN</h3>
<script>

function login(){
    event.preventDefault();
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var role = document.getElementById("Role").value;
    var formData = "username=" + username + "&password=" + password + "&role" = + role +;
    console.log(formData);
    
}
</script>


<form action= listdonations.jsp>
<label>Username:</label>
<input type="text" name="username" id="username" placeholder="Enter username"  required autofocus />
<br/>
<label>Password:</label>
<input type="password" name="password" id="password" placeholder="Enter Password"  required />
<br/>
<label>Role:</label>
<select>
<option value="Admin">Admin</option>
<option value="Donor" selected>Donor</option>
</select>
<button type="submit">Submit</button>
</form>
<br/>
<a href="index.jsp">Home</a>
</body>
</html>