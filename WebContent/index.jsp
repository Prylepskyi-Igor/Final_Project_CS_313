<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Sign in with Facebook example</title>
</head>
<body>
<tag:notloggedin>
  <a href="sign_in.jsp">Sign in with Facebook</a>
</tag:notloggedin>
<tag:loggedin>
  <h1>Welcome ${facebook.name} (${facebook.id})</h1>
  ${facebook.getHome()}
<a href="LogoutServlet">logout</a>
</tag:loggedin>
</body>
</html>