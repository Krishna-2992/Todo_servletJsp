<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.yash.pojo.Task" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>To Do List - View Tasks</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center py-12 px-6 sm:px-12 lg:px-24">
    <div class="w-full bg-white rounded-lg shadow-xl p-8 text-left">
        <h2 class="text-2xl font-bold mb-4">To Do List - View Tasks</h2>
        
        <div class="overflow-x-auto">
            <table class="min-w-full divide-y divide-gray-200">
                <thead class="bg-gray-50">
                    <tr>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Name</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Description</th>
                        <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Status</th>
                    </tr>
                </thead>
                <tbody class="bg-white divide-y divide-gray-200">
                    <%
                        List<Task> tasks = (List<Task>) request.getAttribute("tasks");
                    	out.println("tasks count is: " + tasks.size());
                    	for (Task task : tasks) {
                            %>
                                <tr class="hover:bg-gray-50">
                                    <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><%= task.getId() %></td>
                                    <td class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900"><%= task.getName() %></td>
                                    <td class="px-6 py-4 text-sm text-gray-500"><%= task.getDescription() %></td>
                                    <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500"><%= task.getStatus() %></td>
                                    <td><a href="DeleteTask?id=<%=task.getId()%>">Delete</a></td>
                                </tr>
                            <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        
        <div class="text-center">
        	<%
			String message = (String)request.getAttribute("message");
			String errorMessage = (String)request.getAttribute("errorMessage");
			
			if(message != null) {
			%>
			<p class="text-green-600"><%=message %></p>
			<%
			} else if(errorMessage != null) {
			%>
			<p class="text-red-600"><%=errorMessage %></p>
			<%
			}
		%>
        </div>
        
        <a href="TodoList.jsp" class="mt-8 w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            Add New Task
        </a>
    </div>
</body>
</html>
