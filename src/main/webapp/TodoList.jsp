<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To do List</title>
</head>
<body>
	
	Add task: 
	<br> <br>
	<form method="post" action="TodoController">
		Task name: <input type="text" name="name" value="eat"> <br>
		Task description: <input type="text" name="description" value="eat healthy food">
		<button type="submit">Add Task</button>
	</form>
</body>
</html>