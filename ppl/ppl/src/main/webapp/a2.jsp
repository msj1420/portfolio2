<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>노원점</title>
		<link rel="stylesheet" href="css/index.css">
	</head>
	<body>
			<div id="wrap">
			<div id="header">
				<ul>
					<li><a href="login.jsp">로그인</a></li>
					<li><a href="register3.jsp">회원가입</a></li>
				</ul>
				<div id="headermain">
					<h1><a href="index.jsp"><img src="image/logo.png"></a></h1>\
					<div class="headleft">
						<span>점포찾기</span>
							<select>
								<option value="1">창동점</option>
								<option value="2">노원점</option>
								<option value="3">월계점</option>
								<option value="4">중계점</option>
							</select>
						<input type="submit" value="이동">
					</div>
				</div>
			</div>
		</div>
		<script>
			let sel=document.getElementsByTagName("select")[0];
			let btn=document.getElementsByTagName("input")[0];
			btn.addEventListener("click", function(){
				location.href="a"+sel.value+".jsp"
			});
		</script>
	</body>
</html>