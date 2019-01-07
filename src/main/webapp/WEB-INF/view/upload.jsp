<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>文件上傳</title>
	</head> 
	<body>
		<form action="http://127.0.0.1:8080/file/uploaded" method="post" enctype="multipart/form-data">
			<h2>文件上傳</h2>
			選擇文件：<input name="uploadedFile" type="file" required="required"/>
			<br/><br/>
			<input name="comfirm" type="submit" value="提交"/>
			<a href="${pageContext.request.contextPath}/file/download?fileName=csgo_dust2.png">下載</a>
		</form>
	</body>
</html>