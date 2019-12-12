<html>
<head>
<title>My web application</title>
</head>
<body>
	<h2>Delete wrong!!!</h2>
	<br>
	
	<input type="text" name="user-id" value=<%=session.getAttribute("user-id")%> hidden>
	
	<form action="user" method="post">
		<input type="text" name="action" value="back-to-cabinet-page" hidden>

		<input type="submit" value="Back">
	</form>
</body>
</html>