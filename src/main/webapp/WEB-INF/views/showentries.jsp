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


    <h3>Available rooms near  ${uni} :</h3>
   
    <table>
      <tr>
        <th>Date</th>
        <th>Apartment</th>
        <th>Description</th>
        <th>Contact</th>
      </tr>
      <c:if test="${entrieslist.size()==0}">
<tr><td style="font-size:20px;color:green;text-align:center" colspan="4"><h3>There is no rooms available in our database.</h3></td></tr>
</c:if>
      <c:forEach items="${entrieslist}" var="e">
      
       <tr>
        <td><fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy"/></td>
        <td>${e.apartment}</td>
        <td>${e.description}</td>
        <td>${e.contact}</td>
      </tr>
      
      </c:forEach>
     
    </table>
</body>
</html>