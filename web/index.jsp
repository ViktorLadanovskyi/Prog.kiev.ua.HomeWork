<%--
  Created by IntelliJ IDEA.
  User: lada
  Date: 22.10.2019
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>profile results</title>
  </head>
  <body>
    <%
      String name = (String) session.getAttribute("Name");
      String lastName = (String) session.getAttribute("LastName");
      String age = (String) session.getAttribute("Age");
      String male = (String) session.getAttribute("Male");
      String female = (String) session.getAttribute("Female");
      String english = (String) session.getAttribute("English");
      String ukrainian = (String) session.getAttribute("Ukrainian");
    %>

    <h1>Hello <%= name + " " + lastName + ", " + age %></h1><br>

    <table>
      <caption>Response results</caption>
      <tr>
        <th>male</th>
        <th>female</th>
        <th>english</th>
        <th>ukrainian</th>
      </tr>
      <tr>
        <td><%= male %></td>
        <td><%= female %></td>
        <td><%= english %></td>
        <td><%= ukrainian %></td>
      </tr>
    </table>

  <br><a href="index.html">once more</a>
  </body>
</html>
