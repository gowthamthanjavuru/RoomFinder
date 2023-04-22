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
    <form action="./saveuser" method="post">
      <label for="username">Username:</label>
      <input type="text" id="username" name="username" required><br>

      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required><br>
     <button type="submit">Register</button>
     </form>
     
    </div>
     </body> 
</html>