<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<script>
			if("${chkLogin}"=="0"){
				alert("아이디 또는 패스워드가 일치하지 않습니다. 다시 로그인해주세요.");
			}
			if("${chkLogin}" != null){
				alert("로그인 되었습니다.");
				location.href="/";
			}
		</script>
	</head>
	<body>
		<h2>로그인</h2>
		<form action="/member/login" method="post">
			<h4>모델 확인 : ${chkLogin }</h4>
			<label>아이디</label>
			<input type="text" name="id"><br/>
			<label>패스워드</label>
			<input type="text" name="pw"><br/>
			<input type="submit" value="로그인"><br/>
			<a href="/">메인화면으로 이동</a>
		</form>
	</body>
</html>