<html>
<body>
<h2>Hello World!</h2>
</body>
</html>


<%@page import="com.orangelit.stocktracker.web.views.TestView" %>

<h1>Hello</h1>

<% TestView model = (TestView)request.getAttribute("model"); %>
<p>The car is <%=model.color%> and has <%=model.numberOfDoors%> doors.</p>