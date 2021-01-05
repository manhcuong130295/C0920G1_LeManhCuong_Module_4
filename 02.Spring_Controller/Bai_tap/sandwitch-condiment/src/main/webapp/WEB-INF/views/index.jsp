<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24-Nov-20
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/save" >
    <label for="Lettuce">Lettuce</label>
    <input type="checkbox" name="condiment" value="Lettuce" id="Lettuce">
    <label for="Tomato">Tomato</label>
    <input type="checkbox" name="condiment" value="Tomato" id="Tomato">
    <label for="Mustard">Mustard</label>
    <input type="checkbox" name="condiment" value="Mustard" id="Mustard">
    <label for="Sprouts">Sprouts</label>
    <input type="checkbox" name="condiment" value="Sprouts" id="Sprouts">
    <button type="submit">Save</button>
  </form>
  </body>
</html>
