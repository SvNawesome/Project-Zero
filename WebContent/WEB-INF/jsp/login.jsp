<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <div style="text-align:center">
            <h2>Signup Details</h2>
            <form action="loginCheck" method="post">
            <br/>Username:<input type="text" name="username">
            <br/>Password:<input type="password" name="password">
            <br/><input type="submit" value="Submit">
	         </form>
	         <form action="generateTestData">
	            	<input type="submit" value="Generiere Testdaten">
	         </form>
	         <form action="register">
	            	<input type="submit" value="Registrieren">
	         </form>
        </div>
    </body>
</html>
