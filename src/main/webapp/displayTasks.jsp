<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.yash.pojo.Task" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do List - View Tasks</title>
<style>
    table, th, td {
        border: 1px solid black;
        padding: 5px;
    }
</style>
</head>
<body>
    <h2>To Do List - View Tasks</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Status</th>
        </tr>

        <%-- We'll populate this table dynamically --%>
        <%
            List<Task> tasks = (List<Task>) request.getAttribute("tasks");
            for (Task task : tasks) {
                %>
                    <tr>
                        <td><%= task.getId() %></td>
                        <td><%= task.getName() %></td>
                        <td><%= task.getDescription() %></td>
                        <td><%= task.getStatus() %></td>
                    </tr>
                <%
            }
        %>
    </table>

    <script>
        function refreshPage() {
            window.location.reload(true);
        }
    </script>
</body>
</html>