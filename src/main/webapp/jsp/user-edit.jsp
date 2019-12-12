<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h2>Update user:</h2>
    <input type="text" name="user-id" value=<%=session.getAttribute("user-id")%> hidden>
    
    <form action="user" method="post">
        <input type="text" name="action" value="update-user" hidden>
        
        <input type="text" size="40" name="login" placeholder="Input login" required>
        <br>
        <input type="text" size="40" name="password" placeholder="Input password" required>
        <br>
        <input type="text" size="40" name="first-name" placeholder="Input first name" required>
        <br>
        <input type="text" size="40" name="last-name" placeholder="Input last name" required>
        <br>
        <input type="email" size="40" name="email" placeholder="Input email" required>
        <br>       
        <input type="text" size="40" name="phone" placeholder="Input phone">
        <br>
        
        <input type="submit" value="Edit user">
     </form>
</body>
</html>