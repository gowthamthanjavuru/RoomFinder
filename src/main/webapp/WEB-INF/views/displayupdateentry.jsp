<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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


<h1>Display Entry</h1><br/><br/><br/>
<form action="./processentryupdate" method="POST">
<label>University </label><input type="test" name="uni" class="formcontrol" value="${entry.uni }" readonly><br/><br/>
<label>Date</label> <input type="text" name="entrydate" class="formcontrol" value="<fmt:formatDate value="${entry.entrydate}" pattern="yyyy-MM-dd"/>"  readonly><br/><br/>
<label>Apartment  </label><input type="text" name="apartment" class="formcontrol" value="${entry.apartment }" ><br/><br/>
<label>Contact    </label><input type="tel" name="contact" class="formcontrol" value="${entry.contact }" ><br/><br/>
<label>Description</label> 
<textarea rows="10" cols="30" name="description" >
 ${entry.description }
</textarea>
<input type="hidden" name="userid" value="${user.id}">
<input type="hidden" name="id" value="${entry.id}">
<br/><br/><br/>
<button type="submit">UPDATE ENTRY </button>

</form>


</body>
</html>