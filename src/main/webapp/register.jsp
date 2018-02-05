<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/register.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/register.js"></script>
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
	<form id="regForm" method="post" action="${pageContext.request.contextPath }/user/register.do">
    	<div id="formDiv">
    		<div><h1 align="center">欢迎注册</h1></div>
    		<div id="role">
    			<input type="button" value="买家" class="selected" title="1">
    			<input type="button" value="商铺" title="2">
    			<input type="button" value="快递" title="3">
    		</div>
			<div id="regType" align="center">
				<input id="regBySms" type="radio" value="1" name="type" checked="checked">短信验证
				<input id="regByEmail" type="radio" value="2" name="type">邮箱验证
			</div>
			<div id="formContent" align="center">
					<br/><br/>
					<input id="roleInput" type="hidden" name="userRole" value="1"/>
					<table cellpadding="10px">
						<tr>
							<td>邮箱：</td>
							<td><input class="textInput" id="verifyEmail" name="userEmail" placeholder="请输入常用有效邮箱"/></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="emailSpan"></span></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td><input class="textInput" id="verifyPwd" type="password" name="userPassword" placeholder="请输入6-16位密码"/></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="pwdSpan"></span></td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td><input class="textInput" id="verifyRePwd" type="password" placeholder="请重新输入密码"/></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="pwdReSpan"></span></td>
						</tr>
						<tr>
							<td>手机：</td>
							<td><input id="verifyPhone" class="textInput" name="userPhone" placeholder="请输入有效手机号码"/></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="phoneSpan"></span></td>
						</tr>
						<tr id="smsTr">
							<td><input id="sendMsg" type="button" value="获取短信验证码"></td>
							<td><input id="msgInput" class="textInput" name="code" placeholder="请输入手机验证码"/></td>
						</tr>
						<tr>
							<td></td>
							<td><span id="msgSpan"></span></td>
						</tr>
						<tr id="agreeTr">
							<td><input id="agree" type="checkbox"/>同意</td>
							<td><a href='#'><<用户注册协议>></a><br/><font color="red">注册前请先阅读协议，同意后方可进行注册</font></td>
						</tr>
						<tr>
							<td align="center" colspan="2"><input id="regButton" type="submit" value="注册"/></td>
						</tr>
					</table>
			</div>
    	</div>
	</form>
    	
    	
    	
  </body>
</html>
