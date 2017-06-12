<%@page import="Entity.User"%>
<%@page import="org.apache.tomcat.util.descriptor.web.LoginConfig"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>汕大一考通</title>
	<link rel="stylesheet" type="text/css" href="css/basic.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script src="js/jquery-3.2.1.min.js"></script>
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
<!-- 头部 -->
<header id="header">
	<div class="center">
		<h1 class="logo">汕大一考通</h1>
		<div	 class="login">		
			<span class="user">欢迎考生：<%=sno %></span>&nbsp;&nbsp;&nbsp;
			<span class="signOut"><a href="login.html">注销</a></span>
		</div>
		<nav class="link">
			<h2 class="none">网站导航</h2>
			<ul>
				<li class="active"><a href="index.jsp">首页</a></li>
				<li><a href="###">考试资讯</a></li>
				<li><a href="###">考点复习</a></li>
				<li><a href="###">自我检测</a></li>
				<li><a href="###">关于我们</a></li>
			</ul>
		</nav>
	</div>
</header>
<div id="search">
	<div class="center"></div>
	<input type="text" class="search" placeholder="请输入查询内容（考题、老师、成绩等）">
	<img src="img/search.png" onclick="formName.submit();" class="button">
</div>
<div id="main">
	<section class="center">
		<h2>热门考试</h2>
		<p>考试、测试、复习、实验各种贴心模块推荐</p>
	</section>
	<div id="container">
		<div class="box">
			<h2>考试</h2>
			<ul>
				<li><a href="question.jsp">WEB应用</a></li>
				<li><a href="###">智能系统</a></li>
				<li><a href="###">算法设计与分析</a></li>
				<li><a href="###">计算机网络</a></li>
				<li><a href="###">数据库概论</a></li>
				<li><a href="###">企业建模</a></li>
			</ul>
		</div>
		<div	 class="box">
			<h2>测试</h2>
			<ul>
				<li><a href="question.jsp">WEB应用</a></li>
				<li><a href="###">智能系统</a></li>
				<li><a href="###">算法设计与分析</a></li>
				<li><a href="###">计算机网络</a></li>
				<li><a href="###">数据库概论</a></li>
				<li><a href="###">企业建模</a></li>
			</ul>
		</div>
		<div	 class="box">
			<h2>复习</h2>
			<ul>
				<li><a href="question.jsp">WEB应用</a></li>
				<li><a href="###">智能系统</a></li>
				<li><a href="###">算法设计与分析</a></li>
				<li><a href="###">计算机网络</a></li>
				<li><a href="###">数据库概论</a></li>
				<li><a href="###">企业建模</a></li>
			</ul>
		</div>
		<div	 class="box">
			<h2>实验</h2>
			<ul>
				<li><a href="question.jsp">WEB应用</a></li>
				<li><a href="###">智能系统</a></li>
				<li><a href="###">算法设计与分析</a></li>
				<li><a href="###">计算机网络</a></li>
				<li><a href="###">数据库概论</a></li>
				<li><a href="###">企业建模</a></li>
			</ul>
		</div>
		<div	 class="box">
			<h2>录入考试题</h2>
			<ul>
				<li><a href="###">WEB应用</a></li>
				<li><a href="###">智能系统</a></li>
				<li><a href="###">算法设计与分析</a></li>
				<li><a href="###">计算机网络</a></li>
				<li><a href="###">数据库概论</a></li>
				<li><a href="###">企业建模</a></li>
			</ul>
		</div>
		<div	 class="box">
			<h2>录入测试题</h2>
			<ul>
				<li><a href="###">WEB应用</a></li>
				<li><a href="###">智能系统</a></li>
				<li><a href="###">算法设计与分析</a></li>
				<li><a href="###">计算机网络</a></li>
				<li><a href="###">数据库概论</a></li>
				<li><a href="###">企业建模</a></li>
			</ul>
		</div>
		<div	 class="box">
			<h2>录入复习题</h2>
			<ul>
				<li><a href="###">WEB应用</a></li>
				<li><a href="###">智能系统</a></li>
				<li><a href="###">算法设计与分析</a></li>
				<li><a href="###">计算机网络</a></li>
				<li><a href="###">数据库概论</a></li>
				<li><a href="###">企业建模</a></li>
			</ul>
		</div>
		<div	 class="box">
			<h2>录入实验题</h2>
			<ul>
				<li><a href="###">WEB应用</a></li>
				<li><a href="###">智能系统</a></li>
				<li><a href="###">算法设计与分析</a></li>
				<li><a href="###">计算机网络</a></li>
				<li><a href="###">数据库概论</a></li>
				<li><a href="###">企业建模</a></li>
			</ul>
		</div>
	</div>
</div>

<footer id="footer">
	<div class="top">
		<div class="block left">
			<h2>合作伙伴</h2>
			<hr>
			<ul>
				<li><a href="https://www.stu.edu.cn/">汕头大学</a></li>
				<li><a href="http://www.pku.edu.cn/">北京大学</a></li>
				<li><a href="http://www.hku.hk/">香港大学</a></li>
				<li><a href="http://www.harvard.edu/">哈佛大学</a></li>
			</ul>
		</div>
		<div class="block center">
			<h2>考试FAQ</h2>
			<hr>
			<ul>
				<li><a href="###">考试规则？</a></li>
				<li><a href="###">考试和实验有什么区别？</a></li>
				<li><a href="###">试卷评分有疑问？</a></li>
				<li><a href="###">如何查看自己的GPA？</a></li>
				<li><a href="###">如何补考？</a></li>
			</ul>
		</div>
		<div class="block right">
			<h2>联系方式</h2>
			<hr>
			<ul>
				<li>微博：汕大123团队</li>
				<li>FaceBook：汕大123团队</li>
				<li>邮箱：123@qq.com</li>
				<li>地址：汕头市金平区大学路243号</li>
			</ul>
		</div>
	</div>
	<div class="bottom">COPY © 汕大一考通 | 汕头大学123团队 All Rights Reserved. | 粤ICP备2014101058号</div>
</footer>
</body>
</html>