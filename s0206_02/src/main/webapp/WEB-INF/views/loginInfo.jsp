<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<title>가입회원정보</title>
    	<style>
    		h2{text-align:center;}
    		table,th,td{border:1px solid black; border-collapse:collapse;}
    		table{text-align:center; width:800px; margin:10px auto;}
    		th,td{height:40px;}
    	</style>
	</head>
	<body>
		<h2>가입회원정보</h2>
		<table>
			<colgroup>
				<col span="15%">
				<col span="15%">
				<col span="15%">
				<col span="15%">
				<col span="15%">
				<col span="15%">
			</colgroup>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>국어</th>
				<th>영어</th>
				<th>합계</th>
				<th>평균</th>
			</tr>
			<tr>
				<td>${mem.id }</td>
				<td>${mem.pw }</td>
				<td>${kor }</td>
				<td>${eng }</td>
				<td>${total }</td>
				<td>${avg }</td>
		</table>
		<a href="/">메인화면으로 이동</a>
	</body>
</html>