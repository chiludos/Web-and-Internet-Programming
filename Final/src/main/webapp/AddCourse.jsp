<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course</title>
</head>
<body>
	<form action="AddCourse" method="post">
	<p>Course: <input name="name" type="text"/>
		<select name="type">
			<option>Quarter</option>
			<option>Semester</option>
		</select>
		<button type="submit">Add</button>
	</p>
	</form>
</body>
</html>