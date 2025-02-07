<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
    	<title>data정보</title>
    	<style>
    		h2{text-align:center;}
    		table,th,td{border:1px solid black; border-collapse:collapse;}
    		table{text-align:center; width:800px; margin:10px auto;}
    		th,td{height:40px;}
    	</style>
	</head>
	<body>
		<h2>data정보</h2>
		<table>
			<colgroup>
				<col span="*">
			</colgroup>
			<tr>
				<th>data값</th>
			</tr>
			<tr>
				<td>${bno }</td>
			</tr>
		</table>
		<a href="/">메인화면으로 이동</a>
	</body>
</html>