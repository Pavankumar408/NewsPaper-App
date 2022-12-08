<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewAllnewspaperDetails</title>
</head>
<body>
<h1>Newspaper Details Readed sucessfully,,,</h1>
<hr>
<c:forEach items="${ListofNewspaper }" var="newspaperObj">
<tr>
<td>${ newspaperObj.newspapername}</td><br>
<td>${ newspaperObj.price}</td><br>
<td>${ newspaperObj.language}</td><br>
<td>${ newspaperObj.noofpages}</td><br>
<hr>
</tr>





</c:forEach>

</body>
</html>