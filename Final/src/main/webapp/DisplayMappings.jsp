<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Mapping</title>
</head>
<body>

<p><a href="AddCourse">Add Course</a> | <a href="CreateMapping">Create Course Mapping</a></p>

<div>
<table border="1">
	<thead>
		<tr>
			<th>Quarter Courses</th>
			<th>Semester Courses</th>
			<th >Course Mappings</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
			<ul>
				<c:forEach items="${qCourses}" var="qCourse">
					<li>${qCourse.name}</li>
				</c:forEach>
			</ul>
			</td>
			<td>
			<ul>
				<c:forEach items="${sCourses}" var="sCourse">
					<li>${sCourse.name}</li>
				</c:forEach>
			</ul>
			</td>
			<td>
			<ul>
				<c:forEach items="${courseMappings}" var="courseMapping">
					<li>(${courseMapping.qCourse.name}, ${courseMapping.sCourse.name})</li>
				</c:forEach>
			</ul>
			</td>
		</tr>
	</tbody>
</table>
</div>
</body>
</html>

