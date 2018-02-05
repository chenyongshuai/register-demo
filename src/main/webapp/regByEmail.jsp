<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'regBySms.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/regok.css">

  </head>
  
  <body>
   			
   		<div id="header">
    		<img alt="" src="img/2017-10-10_191340.png">
    		<hr/>
    	</div>	
    	<div id="menu">
    		<ul>
    			<li><a href="categorylist.jsp">商城首页</a>→</li>
    			<li>注册</li>
    		</ul>
    	</div>
   		<div id="message">
			<span>${requestScope.message }</span>
			<span>${requestScope.map.message }</span>
   		</div>
  </body>
</html>
