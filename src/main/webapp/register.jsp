<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>

</head>
<body>
<form onsubmit="register()" >
<label>Username:</label>
<input type="text" name="username" id="username" placeholder="Enter username" required autofocus />
<br/>
<label>Phone Number</label>
<input type="tel" name="phonenumber" id="phonenumber" placeholder="Enter phone number"required  />
<br/>

<label>Password:</label>
<input type="password" name="password" id="password" placeholder="Enter Password" required />
<br/>
<button type="submit">Submit</button>
<br/>
Existing User ? <a href="login.jsp">Login</a> <br/>
<a href="index.jsp">Home</a>
</form>
<script>
function register()
{
 event.preventDefault();
 var username = document.getElementById("username").value;
 var phonenumber=document.getElementById("phonenumber").value;
 var password=document.getElementById("password").value;
 var formData = "username=" + username + "&phonenumber="+ phonenumber +"&password="+password; 
 console.log(formData);
 var url="http://localhost:8080/Charity_app/RegisterServlet"+formData;
 console.log(url);
 var formData = {};
 $.get(url, function(response){
         console.log(response);
 });
}
</script>
</body>
</html>
