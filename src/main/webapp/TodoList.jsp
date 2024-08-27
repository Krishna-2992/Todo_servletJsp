<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>To Do List</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center py-12 px-6 sm:px-12 lg:px-24">
    <div class="max-w-md w-full bg-white rounded-lg shadow-xl p-8 text-left">
        <h2 class="text-2xl font-bold mb-4">To Do List</h2>
        <form method="post" action="TodoController">
            <div class="mb-4">
                <label for="name" class="block mb-2 text-sm font-medium text-gray-900">Task Name:</label>
                <input type="text" id="name" name="name" value="eat" 
                       class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                       placeholder="Enter Task Name">
            </div>
            <div class="mb-4">
                <label for="description" class="block mb-2 text-sm font-medium text-gray-900">Description:</label>
                <textarea id="description" name="description" rows="4" cols="50" 
                          class="min-h-[120px] bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5"
                          placeholder="Enter Task Description"></textarea>
            </div>
            <button type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                Add Task
            </button>
        </form>
        <br/>
        <form action="TodoController">
            <button type="submit" class="mt-4 w-full text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800">
                View All Tasks
            </button>
        </form>
    </div>
</body>
</html>
