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
    <title>My JSP 'categorylist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
  	<link rel="stylesheet" type="text/css" href="css/categorylist.css">
	<script type="text/javascript">
		$(function(){
			//类别
			$.ajax({
				url:"virtualCategory/getVirtualCategory.do",
				success:function(data){
					//console.log(data);
					var obj = $("#categoryLi");
					for(var i=0;i<data.length;i++){
						$(obj).append("<li name='categoryContent' class='fontSize'  onmouseover='showCategory("+data[i].virtualCategoryId+")'><a href='${pageContext.request.contextPath}/product/getProductById.do?virId="+data[i].virtualCategoryId+"'>"+data[i].virtualCategoryName+"</a><div class='level22' style='display:none;height:600px;width:600px;background-color:#00FFFF;position: absolute;left:308px;top: 137px; ' id='categoryDiv2'><ul ></ul></div></li>");
					}
				}
			});
			
			//搜索按钮
			$("#store").click(function(){
				$("#baby").css("background-image","url('img/2017-10-09_210048.png')");
				$("#store").css("background-image","url('img/2017-10-09_210054.png')");
			});
			$("#baby").click(function(){
				$("#baby").css("background-image","url('img/2017-10-09_210031.png')");
				$("#store").css("background-image","url('img/2017-10-09_210040.png')");
			});
			
			
			//每日特惠
			$.ajax({
				url:"product/getProductOrderByDisCount.do",
				success:function(data){
					console.log(data);
					var flag = 0;
					for(var i=0;i<5;i++){
						$("#discount").append("<div><img src='img/"+data[i].proPicture+"'/></div>");
						//console.log(flag);
						flag=flag+1;
					}
					window.setInterval(function(){
						if(flag==20){
							flag=0;
						}
						$("#discount").html("");
						for(var i=flag;i<flag+5;i++){
							//console.log(flag);
							$("#discount").append("<div><a href='#'><img src='img/"+data[i].proPicture+"'/><span id='proNameSpan'>"+data[i].proName+"<br/>原价:"+data[i].proPrice+" Ks,<font color='red'>现价:"+data[i].proDiscount+" Ks</font></span></a></div>");
						}
						flag=flag+5;
					}, 1500);
				}
			});
			
			$("[name='categoryContent']").hover(function(){
				$(this).find(".level22").show();
			},function(){
				$(this).find(".level22").hide();
			});
			
		});
		//类别
		function showCategory(data){
			//console.log(data);
			$.ajax({
				url:"category/getCategoryByVirId.do",
				data:"virtualCategoryId="+data,
				success:function(data){
					//console.log(data);
					var obj = $("#categoryDiv2");
					obj.html("").css("display","block");
					for(var i=0;i<data.length;i++){
						//console.log(data[i].categoryName);
						obj.append("<li id='categorySpan"+i+"' class='fontSize2'><a href='${pageContext.request.contextPath}/product/getProductById.do?secondId="+data[i].categoryId+"'>"+data[i].categoryName+"</a><br/></li><hr/>");
						for(var j=0;j<data[i].categoryThird.length;j++){
							$("#categorySpan"+i).append("<a href='${pageContext.request.contextPath}/product/getProductById.do?thirdId="+data[i].categoryThird[j].categoryId+"' style='display:inline-block;'>"+data[i].categoryThird[j].categoryName+"</a>&nbsp;&nbsp;&nbsp;");
						}
					}
				}
			});
		}
		
	</script>
  </head>
   		
  <body bgcolor="#CCCCFF">	
  	 	
  	 	<div id="headerDiv">
  	 		<ul id="headLi">
  	 			<li><a href="">主页</a></li>
  	 			<li><a href="">登陆</a></li>
  	 			<li><a href="register.jsp">注册</a></li>
  	 			<li><a href="">帮助中心</a></li>
  	 			<li><a href="">会员中心</a></li>
  	 			<li><a href="">购物车</a></li>
  	 		</ul>
  	 	</div>
  	 	<div id="search">
	  	 		<input id="baby" type="button" value="" />
	  	 		<input id="store" type="button" value=""/><br/>
	  	 	<span>
  	 			<input class="textInput" type="text" width="100px" style="font-size:20px;width:400px;height:40px;"/>
	  	 	</span>
	  	 	<span>
  	 			<input id="searchButton" type="button" value="">
	  	 	</span>
  	 	</div>
  		<div id="categoryDiv" style="width:300px;height:600px;background-color:#F0F8FF">
  			<ul id="categoryLi"></ul>
  		</div>
<!--   		<div id="categoryDiv2" onmouseout="catediv2()" style="width:800px;height:600px;background-color:#FFFFFF;display:none;"></div>
 -->  		<div id="introduce"><img alt="" src="img/2017-10-09_212412.png"></div>
  		<div id="discount"></div>
  		
  		
  		
  </body>
</html>
