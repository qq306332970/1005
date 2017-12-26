<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单详细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px gray;
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
	
	#pay {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -412px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
	#pay:HOVER {
		background: url(<c:url value='/images/all.png'/>) no-repeat;
		display: inline-block;
		
		background-position: 0 -448px;
		margin-left: 30px;
		height: 36px;
		width: 146px;
	}
</style>
  </head>
  
  <body>
<h1>当前订单</h1>

<table border="1" width="100%"  background="black">
	<tr bgcolor="gray" bordercolor="gray">
		<td colspan="6">
			订单编号：123456　成交时间：2000-01-01 15:30　金额：<font color="red"><b>319.2元</b></font>
		</td>
	</tr>

	<%--<tr bordercolor="gray" align="center">--%>
		<%--<td width="15%">--%>
			<%--<div><img src="<c:url value='/book_img/9317290-1_l.jpg'/>" height="75"/></div>--%>
		<%--</td>--%>
		<%--<td>书名：Java详解</td>--%>
		<%--<td>单价：39.9元</td>--%>
		<%--<td>作者：张孝祥</td>--%>
		<%--<td>数量：2</td>--%>
		<%--<td>小计：79.8元</td>--%>
	<%--</tr>--%>

	<tr>
		<th>图片</th>
		<th>书名</th>
		<th>作者</th>
		<th>数量</th>
		<th>小计</th>
	</tr>


	<c:forEach var="i" items="${requestScope.list}" >
		<tr>
			<td width="15%"><div><img src="<c:url value='${i.image}'/>" height="75"/></div></td>
			<td>${i.bname}</td>
			<td>${i.author}</td>
			<td>${i.count}</td>
			<td>${i.subtotal}</td>
		</tr>
	</c:forEach>

</table>
<br/>
<form method="post" action="javascript:alert('别点了，再点就去银行页面了！');" id="form" target="_parent">
	收货地址：<input type="text" name="address" size="50" value="北京市海淀区金燕龙大厦2楼216室无敌收"/><br/>

	选择银行：<br/>
	<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
	<img src="../../bank_img/icbc.bmp" align="middle"/>
	<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
	<img src="../../bank_img/bc.bmp" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
	<img src="../../bank_img/abc.bmp" align="middle"/>
	<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
	<img src="../../bank_img/ccb.bmp" align="middle"/><br/><br/>
	<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
	<img src="../../bank_img/bcc.bmp" align="middle"/><br/>
</form>
<a id="pay" href="javascript:document.getElementById('form').submit();"></a>

  </body>
</html>
