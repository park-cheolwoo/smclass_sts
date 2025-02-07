<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<h4>session : ${session_id }</h4>
		<ul>
			<c:if test="${session_id == null }">
			<li><a href="stuInput">학생성적입력</a></li>
			<li><a href="login">로그인</a></li>
			<li><a href="member">회원가입</a></li>		
			</c:if>
			<c:if test="${session_id != null }">
			<li><a href="logout">로그아웃</a></li>			
			<li><a href="memInfo">회원정보</a></li>
			</c:if>			
		</ul>
	</body>
</html>