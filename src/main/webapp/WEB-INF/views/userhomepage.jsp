<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<c:url value="/resources/styles/styuserhomepage.css"/>">
</head>
<body>
<h1>Welcome <span style="color: SteelBlue">${user.username}</span></h1>
 <a href="./addentry"><button type="button" class="add-entry">Add apartment</button></a>
    <p>Here is a table of some data:</p>
   
    <table>
      <tr>
        <th>Date</th>
        <th>Apartment</th>
        <th>Description</th>
        <th  colspan="2">Actions</th>
      </tr>
      <c:forEach items="${entrieslist}" var="e">
      
       <tr>
        <td><fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy"/></td>
        <td>${e.apartment}</td>
        <td>${e.description}</td>
        <td><a href="./updateentry?id=${e.id}">Update</a></td>
        <td><a href="./deleteentry?id=${e.id}">Delete</a></td>
      </tr>
      
      </c:forEach>
     
    </table>
     <a href="./signout" class="btn">Sign Out</a>
</body>
</html>