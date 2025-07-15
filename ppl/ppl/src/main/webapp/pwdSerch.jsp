<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>비밀번호 찾기</title>
		<link rel="stylesheet" href="css/pwdSerch.css">
	</head>
	<body>
		<div>
			<a href="index.jsp"><img src="image/logo2.png"></a>
		</div>
		<div id="login">
			<form method="post" action="login" name="frm">
				<input type="text" name="id" placeholder="아이디 "><br>
				<input type="password" name="pwd" placeholder="비밀번호"><br>
				<input type="submit" value="로그인" onclick="return check()">
				<ul>
					<li><a href="idSerch.jsp">아이디 찾기</a></li>
					<li><a href="pwdSerch.jsp">비밀번호 찾기</a></li>
					<li><a href="register3.jsp">회원가입</a></li>
				</ul>
			</form>
		</div>
		<script>
			function check(){
				if(document.frm.id.value.length==0){
					document.frm.id.focus();
					return false;
				}
				if(document.frm.pw.value==""){
					document.frm.pw.focus();
					return false;
				}
			return true;
			}
		</script>
	</body>
</html>