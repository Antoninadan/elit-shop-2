<html>
<head>
<title>User cabinet</title>
</head>
<body>
	<h2>
		Hello, <%=session.getAttribute("user-name")%></h2>

	<input type="text" name="user-id" value=<%=session.getAttribute("user-id")%> hidden>

	<form action="user" method="post">
		<input type="text" name="action" value="open-edit-user-page" hidden> 
		<input type="submit" value="Edit user">
	</form>

	<form action="user" method="post">
		<input type="text" name="action" value="delete-user" hidden> 
		<input type="submit" value="Delete user">
	</form>

</body>
</html>