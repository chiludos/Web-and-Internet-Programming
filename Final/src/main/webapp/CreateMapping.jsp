<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Course Mapping</title>
</head>
<body>
	<form action="CreateMapping" method="post">
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>Quarter Course</th>
					<th>Semester Course</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
					<ul>
						<c:forEach items="${unmappedQCourses}" var="unmappedQCourse">
							<li>
								${unmappedQCourse.name}
								<input name="quarter" type="radio" value="${unmappedQCourse.id}" />
							</li>
						</c:forEach>
					</ul>
					</td>
					<td>
					<ul>
						<c:forEach items="${unmappedSCourses}" var="unmappedSCourse">
							<li>
								${unmappedSCourse.name}
								<input name="semester" type="radio" value="${unmappedSCourse.id}" />
							</li>
						</c:forEach>
					</ul>
					</td>
				</tr>
			</tbody>
		</table>
		
		<p><button type="submit">Create Mapping</button></p>
	</div>
	</form>
</body>
</html>