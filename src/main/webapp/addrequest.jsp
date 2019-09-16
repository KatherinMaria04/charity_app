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
<h3> Add Donations</h3>
<script>
function addRequest(){
    event.preventDefault();
    var requesttype  = document.getElementById("requestType ").value;
    var amountrequested  = document.getElementById("amountRequested ").value;
    var  targetamount = document.getElementById("targetAmount").value;
    var formData = "requestType=" + requesttype + "&amountRequested=" + amountrequested + "&targetAmount="+ targetamount +;
    console.log(formData);
    var url="http://localhost:8080/Charity_app/AddDonationRequestController?requestType=B&amountRequested=1&targetAmount=10";
    	console.log(url);
    var formData = {};
    $.get(url, function(response){
            console.log(response);
    });
  }
    

</script>
<form onsubmit="addRequest()">
<form action= listdonations.jsp>
<label>RequestType:</label>
<input type="text" name="requestType" id="requestType" placeholder="Enter requestType"  required autofocus />
<br/>
<label>AmountRequested:</label>
<input type="text" name="amountRequested" id="amountRequested" placeholder="Enter amount"  required />
<br/>
<label>TragetAmount:</label>
<input type="text" name="targetAmount" id="targetAmount" placeholder="Enter amount"  required />
<br/>

<button type="submit">Submit</button>
</form>
</form>
<br/>
<a href="index.jsp">Home</a>


</body>
</html>