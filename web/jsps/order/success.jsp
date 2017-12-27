<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 17/12/26
  Time: 下午4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>结算成功</title>
</head>
<body>

<h1>结算成功</h1><br>

<input type="hidden" name="uid" value="${sessionScope.uid}">
<a href="<c:url value='/orderItem?method=delCar'/>">返回首页</a>


</body>
</html>
