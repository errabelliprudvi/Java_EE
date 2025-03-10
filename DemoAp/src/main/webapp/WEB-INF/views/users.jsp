<%@ page import="java.util.List, com.spr.model.User" %>
<html>
<body>
    <h2>User List</h2>
    <table border="1">
        <tr><th>Name</th><th>Email</th></tr>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
            for (User u : users) {
                out.println("<tr><td>" + u.getName() + "</td><td>" + u.getEmail() + "</td></tr>");
            }
        %>
    </table>
</body>
</html>
