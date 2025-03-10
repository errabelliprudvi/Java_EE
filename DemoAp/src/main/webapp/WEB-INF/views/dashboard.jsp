<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
   // HttpSession session = request.getSession(false); // JSP provides an implicit session object
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<html>
<body>
    <h2>Welcome, <%= session.getAttribute("user") %></h2>
    <a href="logout">Logout</a>
    
     <a href="users">users</a>
</body>
</html>
