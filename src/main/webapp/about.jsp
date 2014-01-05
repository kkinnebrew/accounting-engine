<%@page import="com.orangelit.stocktracker.authentication.models.User" %>

<a href="/api/auth/logout">Logout</a>

<p>Welcome <%=((User)request.getAttribute("model")).email %></p>