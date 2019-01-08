<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>用戶登錄</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/styles.css">
	</head>
	<body>
		<script src="${pageContext.request.contextPath}/static/js/jquery-2.1.1.min.js" type="text/javascript"></script>
		<script>
		$('#login-button').click(function (event) {
			event.preventDefault();
			$('form').fadeOut(500);
			$('.wrapper').addClass('form-success');
		});
		</script>
		<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
			<h1>数据管理系统</h1>
		</div>
	
		<div class="htmleaf-container">
			<div class="wrapper">
				<div class="container">
					<h1>Welcome</h1>
					
					<form class="form" action="${pageContext.request.contextPath}/doLogin" method="post">
						<input name="username" type="text" placeholder="Username">
						<input name="password" type="password" placeholder="Password">
						<button type="submit" id="login-button">Login</button>
					</form>
				</div>
			
				<ul class="bg-bubbles">
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
		</div>
	</body>
</html>