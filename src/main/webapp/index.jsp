<html>
<head>
    <title>My web application</title>
</head>
<body>
    <h2>Hello, this is the start page</h2>
<br>
    <form action="user" method="post">
        <input type="text" name="action" value="login" hidden>
        <input type="text" size="40" name="login" placeholder="Input login" required>
        <br>
        <input type="password" size="40" name="password" placeholder="Input password" required>
        <br>
        <input type="submit" value="Login user">
    </form>
    <br>
        <form action="user" method="post">
        <input type="text" name="action" value="open-create-page" hidden>
        <input type="submit" value="Create new user">
    </form>
    
</body>
</html>
