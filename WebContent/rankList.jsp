<%@page import="Entity.User"%>
<%@page import="org.apache.tomcat.util.descriptor.web.LoginConfig"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>汕大E考通</title>
	<link rel="stylesheet" href="css/rankList.css">
</head>
<body>
	<% 
	//判断用户是否已经登录
    String sno="";
	int lev=1;
	if(session.getAttribute("user")!=null){
          User user=(User)session.getAttribute("user");
          sno=user.getSno();
          lev=user.getLev();
    }else{
    	response.sendRedirect("login.html");   
    }
	%>
<div id="home">
	<header>
		<h1 id="title">成绩排名</h1>
	</header>
	<div id="main">
		<button type="button" id="button" onclick="startRequest1();">查看排名</button>
		<button type="button" id="button" onclick="startRequest2();">查看个人成绩</button>
		<div id="content"></div>
	</div><!-- end:main主体 -->
	<footer>
		Copyright &copy;2017 汕大-吴广林
	</footer>
</div><!-- emd:home自定义容器 -->

</body>


<script type="text/javascript">
	/*关于问卷部分的JS代码*/
	
	var xmlhttp;//用于发送Post请求
	//创建XMLHttprequest 
	function createXMLHttpRequest(){ 
	    if(window.ActiveXObject){
	        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	    }else{
	        xmlhttp = new XMLHttpRequest();
	    }
	}
	//开始请求
	function startRequest1(){   
		  	var url="http://localhost:8080/WebProject/RankServlet?action=all";
		    createXMLHttpRequest();
		    //设置状态改变时所调用的函数
		    xmlhttp.onreadystatechange = stateChange ;
		    //设置对服务器的调用
		    xmlhttp.open("POST",url,true);
		    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=gb2312");
		    //发送请求  
		    xmlhttp.send();
	}
	function startRequest2(){   
	  	var url="http://localhost:8080/WebProject/RankServlet?action=single";
	    createXMLHttpRequest();
	    //设置状态改变时所调用的函数
	    xmlhttp.onreadystatechange = stateChange ;
	    //设置对服务器的调用
	    xmlhttp.open("POST",url,true);
	    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=gb2312");
	    //发送请求  
	    xmlhttp.send();
}
	//监听服务器响应ajax请求
	function stateChange(){ 
		    if(xmlhttp.readyState==4){ 
		        if(xmlhttp.status==200){ 
		            //做你想在页面上做的事情 
		        	document.getElementById("content").innerHTML=xmlhttp.responseText; 
		        }
		    }
		}
	
</script> <!-- end:问卷脚本 -->
</html>