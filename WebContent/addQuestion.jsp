<%@page import="Entity.User"%>
<%@page import="org.apache.tomcat.util.descriptor.web.LoginConfig"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>汕大E考通</title>
	<link rel="stylesheet" href="css/addQuestion.css">
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
		<h1 id="title">添加考题</h1>
	</header>
	<div id="main">
		<div class="input">
			题目:<br>
			  <input type="text" id="Con" name="Con"><span class="star">*</span><br>
			选项A: <br>
			<input type="text" id="A" name="A"><span class="star">*</span><br>
			选项B:<br>
			 <input type="text" id="B" name="B"><span class="star">*</span><br>
			选项C:<br>
			 <input type="text" id="C" name="C"><span class="star">*</span><br>
			选项D: <br>
			<input type="text"  id="D"  name="D"><span class="star">*</span><br>
			答案:  <br>
			<input type="text" id="Ans"   name="Ans"><span class="star">*</span><br>
			难度等级:  <br>
			<input type="text" id="Qlev"  name="Qlev"><span class="star">*</span>
			<div id="mess"></div>
		</div>
		<button type="button" id="button" onclick="startRequest();">添加</button>
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
	function startRequest(){   
		  	var url="http://localhost:8080/WebProject/addQuestionServlet";
		  	var con=document.getElementById("Con").value;
			var a=document.getElementById("A").value;
			var b=document.getElementById("B").value;
			var c=document.getElementById("C").value;
			var d=document.getElementById("D").value;
			var ans=document.getElementById("Ans").value;
			var qlev=document.getElementById("Qlev").value;
		    createXMLHttpRequest();
		    //设置状态改变时所调用的函数
		    xmlhttp.onreadystatechange = stateChange ;
		    //设置对服务器的调用
		    xmlhttp.open("POST",url,true);
		    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=gb2312");
		    //发送请求  
		    xmlhttp.send("con="+con+"&a="+a+"&b="+b+"&c="+c+"&d="+d+"&ans="+ans+"&qlev="+qlev);
	}
	//监听服务器响应ajax请求
	function stateChange(){ 
		    if(xmlhttp.readyState==4){ 
		        if(xmlhttp.status==200){ 
		            //做你想在页面上做的事情 
		            //如果用户名密码正确返回success，错误返回fail
		            if(xmlhttp.responseText=="success"){ 
		            	document.getElementById("mess").innerHTML="添加成功"; 
		            }
		            else{
		            	document.getElementById("mess").innerHTML="添加失败"; 
		            }
		        }
		    }
		}
	
	//显示结果框
	function show(){
		document.getElementById('light').style.display='block'; 
		document.getElementById('fade').style.display='block';
	}
	//隐藏结果框
	function close(){
		document.getElementById('light').style.display='none';
		document.getElementById('fade').style.display='none';
	}
	
</script> <!-- end:问卷脚本 -->
</html>