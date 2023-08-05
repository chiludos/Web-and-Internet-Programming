<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Genres</title>
</head>
<body>

	<c:choose>
		<c:when test="${books[0].genre == 'Fantasy'}">
		<table border='1'>
			<tr>
				<th>Book</th>
				<th>Votes</th>
			</tr>
			<tr>
			<c:forEach items="${books}" var="bookEntry">
				<td>${bookEntry.name}</td>
				<td>${bookEntry.votes}</td>
			</tr>
			</c:forEach>
		</table>
		</c:when>
		
		<c:otherwise>
		<table border='1'>
			<tr>
				<th>Book</th>
				<th>Votes</th>
			</tr>
			<tr>
			<c:forEach items="${books}" var="bookEntry">
				<td>${bookEntry.name}</td>
				<td>${bookEntry.votes}</td>
			</tr>
			</c:forEach>
		</table>
		</c:otherwise>
	</c:choose>
	
</body>
</html>