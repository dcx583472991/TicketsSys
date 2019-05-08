<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width" />
		<title>注册/登录</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script src="js/bootstrap.min.js"></script>
	</head>
	<style type="text/css">
		/**/body{
			/*background-image: url(bg2.jpg);*/
		}
		
		#id1{
			margin-top: 80px;
			
		}
		
		.form-group{
			width: 35%;
		}
		
		h3{
			text-align: center;
			margin-top: 90px;
		}
	</style>
	
	
	<body>
		<div>
			<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">	
				<a href="#" class="navbar-brand"><strong>主页</strong></a>
				<ul class="nav navbar-nav">
					<li><a href="resetPwd.jsp">修改密码</a></li>
					<li class="active"><a href="#">机票预订</a></li>
					<li><a href="QuerryAllByUserNameAction">预订信息</a></li>
					<li><a href="LogOutAction">退出系统</a></li>
				</ul>
			</div>
			</nav>
		</div>
		
		<h3>在线机票预订</h3>
		<div id="id1" class="col-md-offset-5">
			<form action="bookAction" method="post">
				<div class="form-group" style="display:none;">
					<label>用户名</label>
					<input type="text" class="form-control" value="<%=request.getSession().getAttribute("UserName") %>" readonly/>
				</div>
				<div class="form-group">
					<label>真实姓名</label>
					<input name="book.name" type="text" class="form-control" placeholder="name" />
				</div>
				<div class="form-group">
					<label>始发城市</label>
					<input name="book.startCity" type="text" class="form-control" placeholder="StratCity" />
				</div>
				<div class="form-group">
					<label>目的城市</label>
					<input name="book.endCity" type="text" class="form-control" placeholder="EndCity" />
				</div>
				<div class="form-group">
					<label>出发日期</label>
					<input name="book.date" type="date" class="form-control" />
				</div>
				<input  class="btn btn-group-vertical col-md-offset-3" type="submit" value="确认"/>
			</form>
		</div>
	</body>
</html>
