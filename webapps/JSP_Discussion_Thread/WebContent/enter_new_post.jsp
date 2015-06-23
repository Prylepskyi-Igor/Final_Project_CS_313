<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Post</title>
</head>
<body>
	<form id="myform" method="POST" action="StorePosts">
	  <input type="hidden" name="username" value="${username}"/><br />
	  <a onclick="document.getElementById('myform').submit();">View Posts</a>
	</form>
	
	<form action="StorePosts" method="POST">
		Enter Post: <input type="text" name="post" /><br />
		<input type="hidden" name="username" value="${username}" />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>