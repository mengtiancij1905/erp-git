<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: James
  Date: 2019/7/8
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>显示所有部门</title>
</head>
<body>
<c:forEach items="${list}" var="dep">
    ${dep.uuid}---${dep.depName}---${dep.tele}<br/>
</c:forEach>
</body>
</html>
