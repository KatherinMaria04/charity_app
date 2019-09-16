<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
<h3> ADMIN LOGIN</h3>
<script>

function login(){
    event.preventDefault();
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    
    var formData = "username=" + username + "&password=" + password ;
    console.log(formData);
    var url="http://localhost:8080/Charity_app/AdminLoginServlet?"+formData;
    console.log(url);
    var formData = {};
    $.get(url, function(response){
            console.log(response);
            console.log(response.errorMessage);
            var msg=JSON.parse(response);
            
            
            if (msg.errorMessage!=null) {
                alert("Invalid Username/Password");
            } else {
                alert("valid Username/Password");
                window.location.href = "listdonations.jsp";
            }
            
    });
       
    
}
</script>


<form onsubmit= "login()">
<label>Username:</label>
<input type="text" name="username" id="username" placeholder="Enter username"  required autofocus />
<br/>
<label>Password:</label>
<input type="password" name="password" id="password" placeholder="Enter Password"  required />
<br/>

<button type="submit">Submit</button>
</form>
<br/>
<a href="header.jsp">Home</a>
</body>
</html>

</body>
</html>