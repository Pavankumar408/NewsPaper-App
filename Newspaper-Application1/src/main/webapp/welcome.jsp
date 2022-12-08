<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Newspaper form</title>
</head>
<body>
<h1>welcome to application form...........</h1><br><hr>
<form action="submit.do">
<pre>
Name:<input type="text" name="newspapername"><br>
Price:<input type="text" name="price"><br>
Language:<input type="text"name="language"><br>
Noofpages:<input type="text"name="noofpages"><br>
<input type="submit" value="save" style="color:red;background-color:black;"><br>
</pre>
</form><br>
<form action="SearchNewspaper.do">
SearchNewspaper:<input type="text"name="newspapername"><br>
<input type="submit" value="Search" style="color:red;background-color:black;"><br>
</form><br>
<a href="view.do">viewAllNewspaperDetails</a><br><br><br>
<form action="Delete.do">
DeleteNewspaper:<input type="text"name="newspapername"><br>
<input type="submit" value="Delete" style="color:red;background-color:black;"><br>


</form>
</body>
</html>