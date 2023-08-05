<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Books</title>
</head>
<body>
		
		<table border="1">
		<tr>
			<th>Book</th>
			<th>Genre</th>
			<th>Votes</th>
		</tr>
		
		<c:forEach items="${books}" var="bookEntry">
		<tr>
			<td>${bookEntry.name}</td>
			<td style="text-align: center;"><a href="DisplayGenres">${bookEntry.genre}</a></td>
			<td style="text-align: center;"><a href="IncrementVote">${bookEntry.votes}</a></td>
		</tr>
		</c:forEach>
			
		<form action="DisplayBooks" method="post">
		<tr>
			<td><input type="text" name="bookname" size="20"/></td>
			<td><input type="text" name="bookgenre" size="40"/></td>
			<td><input type="submit" value="Add"/></td>
		</tr>
		</table>
		
		</form>
</body>
</html>