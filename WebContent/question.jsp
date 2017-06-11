<%@page import="Entity.User"%>
<%@page import="Entity.Question"%>
<%@page import="java.util.List"%>>
<%@page import="org.apache.tomcat.util.descriptor.web.LoginConfig"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>调查问卷</title>
	<link rel="stylesheet" href="css/questionaire.css">
	<script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
</head>
<body>
	<% //判断用户是否已经登录
   User user=null;
	if(session.getAttribute("user")!=null){
          user=(User)session.getAttribute("user");
    }else{
    	response.sendRedirect("login.html");   
    }
	
	List<Question> questions= (List<Question>)session.getAttribute("questions");
	%>
<div id="home">
	<header>
		<div id="title">WEB应用技术期末考试</div>
		<div id="tips">本次考试共10题，均为单选题,总分100分</div>
		<a id="query" href="http://www.baidu.com">点击进入成绩查询系统!</a>
	</header>
	<div id="main">
		<div id="StuIfo">
		考生：<%=user.getSno() %>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		考生级别：<%=user.getLev() %>
		</div><!-- end:StuIfo 学生信息 -->

		<div id="content">
			<div class="question">
				<h4>本学期教授WEB技术的是哪一个老师？（答错自动扣40分）<span class="star">*</span></h4>
				<div class="imgQustion">
					<div class="imgBox">
						<label for="haiyong">
							<img src="questionImg/haiyong.jpg" ><br>
							<input type="radio" name="teacher" value="1" class="radioStyle1" id="haiyong">
						</label>
					</div>
					<div class="imgBox">
						<label for="ruoyu">
							<img src="questionImg/ruoyu.jpg" ><br>
							<input type="radio" name="teacher" value="2" class="radioStyle1" id="ruoyu">
						</label>
					</div>
					<div class="imgBox">
						<label for="dazhi">
							<img src="questionImg/dazhi.png" ><br>
							<input type="radio" name="teacher" value="3" class="radioStyle1" id="dazhi">
						</label>
					</div>
					<div class="imgBox">
						<label for="yujin">
							<img src="questionImg/yujin.png" ><br>
							<input type="radio" name="teacher" value="4" class="radioStyle1" id="yujin">
						</label>
					</div>
				</div>
			</div>
			<%
			int count=0;
			for(Question q: questions){
			%>
			<div class="question">
				<h4>第<%=count++%>题，<%=q.getCon()%><span class="star">*</span></h4>
				<div class="answerBox">
					<label><div class="answerStyle"><input type="radio" name="question1" value="1" class="radioStyle2"><%= q.getA()%> </div></label>
					<label><div class="answerStyle"><input type="radio" name="question1" value="2" class="radioStyle2"><%= q.getB()%> </div><br></label>
					<label><div class="answerStyle"><input type="radio" name="question1" value="3" class="radioStyle2"><%= q.getC()%>  </div></label>
					<label><div class="answerStyle"><input type="radio" name="question1" value="4" class="radioStyle2"><%= q.getD()%>  </div><br></label>
				</div>
			</div>
			<%
			if(count==10){
				break;
			}
			}
			%>
		</div><!-- end:content问卷内容 -->
		<p id="pButton"><button id="submit" onclick="showResult()">交卷</button></p>
	</div><!-- end:main问卷主体 -->
	<footer>
		Copyright &copy;2017 汕大-吴广林
	</footer>
</div><!-- emd:home自定义容器 -->

<!-- 结果显示窗口 -->
<div id="light" class="white_content">
	<textarea name="showContent" id="showContent" value="显示内容" disabled></textarea> <br>
	<a href="javascript:void(0)" onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'">
关闭</a>
</div>

<!-- 幕布 -->
<div id="fade" class="black_overlay"></div>

<!-- 计时器 -->
<div id="timer">
		<div id="timeTips">考试时间剩余</div>
		<input type="text" name="showtime" id="showtime" value="0时0分0秒" disabled> 
</div>

<script type="text/javascript">
/*关于计时器部分的JS代码*/
	var se,ss=99;m=10,h=0,s=0; 
	var h1,m1,s1;
	function second(){ 
	if(ss<0){s-=1;ss=100;}  
	if(s<0){m-=1;s=59;}  
	if(m<0){h-=1;m=59;} 
	if(h<0) {
		clearInterval(se);
		alert("考试时间到");
		h=0;m=0;s=0;ss=0;
	}
	h1=checkTime(h);
	m1=checkTime(m);
	s1=checkTime(s);
	t=h1+":"+m1+":"+s1;   //时分秒运算
	document.getElementById("showtime").value=t; 
	//这有一个给id为showtime的input赋值的语句，可以实现动态计时。
	//其实所谓的动态计时，就是在很短的时间里不停给显示时间的地方更新数值，由于速度很快，这样计时器看起来时刻都在变化。但其实不是的，它从本质上还是静态的，这跟js的伪多线程原理是一样的。 
	ss-=1; 
	}  
	function checkTime(i){
		if (i<10) {i="0"+i}
		return i;
	}
	function startclock(){se=setInterval("second()",10);}  //这个函数是要放到按钮的click事件上的
	function pauseclock(){clearInterval(se);}    //这个函数是要放到按钮的click事件上的
	function stopclock(){clearInterval(se);ss=99;m=10;h=0;s=0;}   //这个函数是要放到按钮的click事件上的
	window.onload=startclock();
</script><!--  end:计时器脚本 -->

<script type="text/javascript">
/*关于问卷部分的JS代码*/
var tc;
var rightCount=0;
var score=0;
var sno=<%=user.getSno()%>
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
// 显示结果
function showResult(){
	var text;
	if (isTeacherRight()) {
		if(sno) text=sno+",你的成绩为10分哦"
		else text="你的成绩为10分哦"
		document.getElementById("showContent").value=text;
	}
	else {
		if(sno) text="居然连老师都忘记了，"+sno+",你的成绩为-10分哦";
		else text="居然连老师都忘记了，你的成绩为"+score+"分哦";
		document.getElementById("showContent").value=text;
		 }
}

</script> <!-- end:问卷脚本 -->

</body>
</html>