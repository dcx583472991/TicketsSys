<%@ page language="java" import="java.util.*,action.LogAction" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
	</head>
	<style type="text/css">
		body{
   			/*background-image: url(bg2.jpg);*/
		}
		
		#id1{
			margin-top: 120px;
			
		}
		
		.form-group{
			width: 35%;
		}
	</style>
	<body>
		<!---->
		<div>
			<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				
				<a href="#" class="navbar-brand"><strong>主页</strong></a>
				<ul class="nav navbar-nav">
					<li><a href="">修改密码</a></li>
					<li><a href="">机票预订</a></li>
					<li><a href="">预订信息</a></li>
					<li><a href="">退出系统</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<!-- 登录表单 -->
		<div id="id1" class="col-md-offset-5">
			<form action="loginAction" method="post">
				<div class="form-group">
					<label>用户名</label>
					<input name="users.userName" type="text" class="form-control" placeholder="UserName" />
				</div>
				<div class="form-group">
					<label>密码</label>
					<input name="users.password" type="password" class="form-control" placeholder="password" />
				</div>
				<input  class="btn btn-group-vertical col-md-offset-3" type="submit" value="Sign In"/>
			</form>
		</div>
		
		<!-- 注册表单 -->
		<div id="id2" class="col-md-offset-5">
			<form action="regLoginAction" method="post">
				<div class="form-group">
					<label>用户名</label>
					<input name="registUser.userName" type="text" class="form-control" placeholder="UserName" />
				</div>
				<div class="form-group">
					<label>密码</label>
					<input name="registUser.password" type="password" class="form-control" placeholder="password" />
				</div>
				<div class="form-group">
					<label>密码确认</label>
					<input name="registUser.rePassword" type="password" class="form-control" placeholder="password" />
				</div>
				<input  class="btn btn-group-vertical col-md-offset-3" type="submit" value="Sign Up"/>
			</form>
		</div>
		
	</body>
</html>
