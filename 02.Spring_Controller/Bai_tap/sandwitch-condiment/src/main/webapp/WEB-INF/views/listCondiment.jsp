<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24-Nov-20
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<C:forEach var="condiment" items="${listCondiment}">
    <p>
            ${condiment}
    </p>
</C:forEach>

</body>
</html>
