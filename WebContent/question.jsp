<%@page import="Entity.User"%>
<%@page import="Entity.Question"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.tomcat.util.descriptor.web.LoginConfig"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>调查问卷</title>
	<link rel="stylesheet" href="css/questionaire.css">
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
		考生：<%=sno %>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		考生级别：<%=lev %>
		</div><!-- end:StuIfo 学生信息 -->

		<div id="content">
			<div class="question">
				<h4>本学期教授WEB技术的是哪一个老师？（答错自动扣40分）<span class="red" id="red">*</span><span class="green" id="green"></span></h4>
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
			if(questions!=null){
			for(Question q: questions){
				count++;
			%>
			<div class="question">
				<h4>第<%=count%>题，<%=q.getCon()%><span class="red" id="red">*</span><span class="green" id="green"></span></h4>
				<div class="answerBox">
					<label><span class="answerStyle"><input type="radio" name="<%=count%>" value="A" 	class="radioStyle2"><%= q.getA()%> </span></label>
					<label><span class="answerStyle"><input type="radio" name="<%=count%>" value="B" class="radioStyle2"><%= q.getB()%> </span><br></label>
					<label><span class="answerStyle"><input type="radio" name="<%=count%>" value="C" class="radioStyle2"><%= q.getC()%>  </span></label>
					<label><span class="answerStyle"><input type="radio" name="<%=count%>" value="D" class="radioStyle2"><%= q.getD()%>  </span><br></label>
				</div>
			</div>
			<%
			if(count==10){
				break;
			}
			}
			}
			%>
		</div><!-- end:content问卷内容 -->
		<p id="pButton"><button type="button" id="button" onclick="showResult();startRequest();">交卷</button></p>
	</div><!-- end:main问卷主体 -->
	<footer>
		Copyright &copy;2017 汕大-吴广林
	</footer>
</div><!-- emd:home自定义容器 -->

<!-- 结果显示窗口 -->
<div id="light" class="white_content">
	<textarea name="showContent" id="showContent" disabled></textarea> <br>
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

</body>
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
	function checkTime(i){//转换格式
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
	var xmlhttp;//用于发送Post请求
	var score=0;//用户考试的分数
	var ans=[];//存放用户题目选择的答案
	var rightAns=new Array(10);//存放正确的答案
	var isRight=[];//存放每题的布尔值，用于判断每题的正确性
	var sno=<%=sno%>;
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
		score=getScore();
		show();//显示结果框
		showRightWrong();//显示正确与否
		var text;
		if (isTeacherRight()) {
			text=sno+",你的成绩为"+score+"分哦"
			document.getElementById("showContent").value=text;
		}
		else {
			score-=40;
			text="居然连老师都忘记了，"+sno+",你的成绩为"+score+"分哦";
			document.getElementById("showContent").value=text;
			 }
	}
	//获取所有问题输入的值
	function getScore(){
		let i,rightCount=0;
		for(i=0;i< <%=count%>;i++){
			ans[i]=getRadioBoxValue(""+(i+1));
		}
		<%
		int count2=0;
		if(questions!=null){
		for(Question q:questions){
		%>
			rightAns[<%=count2 %>]="<%=q.getAns()%>";
		<%
		count2++;
		}
		}
		%>
		for(i=0;i< <%=count%>;i++){
			if(ans[i]==rightAns[i]){
				isRight[i]=true;
				rightCount++;
			}else{
				isRight[i]=false;
			}
			console.log(ans[i]);
			console.log(rightAns[i]);
		}
		return 10*rightCount;
	}
	
	//正确的题目显示正确，错误的显示错误
	function showRightWrong(){
		let i;
		for(i=0;i< <%=count+1%>;i++){
			document.getElementsByClassName("green")[i].innerHTML="";
			document.getElementsByClassName("red")[i].innerHTML="";
		}
		//教师选择是否正确
		if(isTeacherRight()){
			document.getElementsByClassName("green")[0].innerHTML=" 正确";
		}else document.getElementsByClassName("red")[0].innerHTML="错误，正确答案为第三个";
 		document.getElementsByName("teacher")[0].disabled=true;
 		document.getElementsByName("teacher")[1].disabled=true;
 		document.getElementsByName("teacher")[2].disabled=true;
 		document.getElementsByName("teacher")[3].disabled=true;
		//题目是否正确
		for(i=0;i< <%=count%>;i++){
 			document.getElementsByName(""+(i+1))[0].disabled=true;
 			document.getElementsByName(""+(i+1))[1].disabled=true;
 			document.getElementsByName(""+(i+1))[2].disabled=true;
 			document.getElementsByName(""+(i+1))[3].disabled=true;
			if(isRight[i]){
				document.getElementsByClassName("green")[i+1].innerHTML=" 正确";
			}else{
				document.getElementsByClassName("red")[i+1].innerHTML="错误，正确答案为"+rightAns[i];
			}
		}
	}
	
	//判断教师是否选择正确
	function isTeacherRight(){
		let tc;
		tc=getRadioBoxValue("teacher");
		if(tc==3) return true
		else return false;
	}
	
	// 获取单选框的值
	function   getRadioBoxValue(radioName) 
	{ 
	    var obj = document.getElementsByName(radioName);  //这个是以标签的name来取控件
	         for(i=0; i<obj.length;i++)    {
	          if(obj[i].checked)    { 
	                  return   obj[i].value; 
	          } 
	      }         
	     return "wuguanglin";       
	}
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
		  	var url="http://localhost:8080/WebProject/ScoreServlet";
		    createXMLHttpRequest();
		    //设置状态改变时所调用的函数
		    xmlhttp.onreadystatechange = stateChange ;
		    //设置对服务器的调用
		    xmlhttp.open("POST",url,true);
		    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=gb2312");
		    var time=getTime();
		    //发送请求  
		    xmlhttp.send("score="+score+"&time="+encodeURIComponent(encodeURIComponent(time)));
	}
	//监听服务器响应ajax请求
	function stateChange(){ 
		    if(xmlhttp.readyState==4){ 
		        if(xmlhttp.status==200){ 
		            //做你想在页面上做的事情 
		            //如果用户名密码正确返回success，错误返回fail
		            if(xmlhttp.responseText=="success"){ 
		            }
		            else{
		            }
		        }
		    }
		}
	//获取系统当前时间
	function getTime(){
		var myDate=new Date();
		return myDate.toLocaleString();
	}
	
</script> <!-- end:问卷脚本 -->
</html>