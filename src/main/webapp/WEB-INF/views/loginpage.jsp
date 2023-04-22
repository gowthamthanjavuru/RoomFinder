<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/style1.css"/>">
</head>
<body>
<div class="form-container">
<h2>LOGIN HERE</h2><br/><br/><br/>
<form action="authenticate" method="post" >
     <label for="username">User-name</label>
      <input type="text" name="username"  required><br/><br/>
      
     <label for="password">Password</label>
     <input type="password" name="password" required><br/><br/><br/>
      <button type="submit">LOGIN</button>

     </form>
      <br/><br/>

      New User? <a href="./sturegister">Register</a> here
<br/><br/>
<h2>If you are here to find room <a href="./studentview">Click here</a></h2>
</div>

</body>
</html>