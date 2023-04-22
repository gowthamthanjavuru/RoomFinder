<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/style1.css"/>">
</head>
<body>
  <div class="form-container">
    <h2>Register</h2>
    <form action="./getentries" method="post">
      <label for="username">University Name:</label>
      <input type="text" id="uni" name="uni" required><br>

     <button type="submit">FIND</button>
     </form>
     
    </div>
     </body> 
</html>