<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <script>
    var assignment7 = window.location.origin + "/assignment7";
    var assignment8 = window.location.origin + "/assignment8";
  </script>
<title>First JSP</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h2>Hello Heroku! I am JSP</h2>
<strong>Current Time is</strong>: <%=new Date() %>
<button onclick="window.location.assign(assignment7);"> Assignment 7 </button>
<button onclick="window.location.assign(assignment8);"> Assignment 8 </button>

</body>
</html>
