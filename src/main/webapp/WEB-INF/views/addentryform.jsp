<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/style.css"/>">
</head>
<body>

<br/><br/>

<hr/>
<br/><br/>
<h1>welcome  <span style="color:SteelBlue">${user.username}</span></h1> 

<a href="./signout" style="color:red;float:right">Signout</a>


<h1>ADD ENTRY</h1><br/><br/><br/>
<form action="./saveentry" method="POST">
<label>University </label><input type="text" name="uni" class="formcontrol"><br/><br/>
<label>Date       </label> <input type="date" name="entrydate" class="formcontrol"><br/><br/>
<label>Apartment  </label><input type="text" name="apartment" class="formcontrol"><br/><br/>
<label>Contact    </label><input type="tel" name="contact" class="formcontrol"><br/><br/>
<label>Description</label> 
<textarea rows="10" cols="30" name="description">
</textarea>
<input type="hidden" name="userid" value="${user.id}">

<br/><br/><br/>
<button type="submit">SAVE ENTRY </button>

</form>


</body>
</html>