<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 리스트</title>
		<style>
		  h2{text-align: center;}
		  table,th,td{border:1px solid black; border-collapse: collapse;}
		  table{text-align: center; width:800px; margin:0 auto;}
		  th,td{height:40px; }
		</style>
	</head>
	<body>
	  <h2>회원 리스트</h2>
	  <table>
	    <colgroup>
	      <col width="10%">
	      <col width="*">
	      <col width="15%">
	      <col width="15%">
	      <col width="10%">
	      <col width="10%">
	    </colgroup>
	    <tr>
	      <th>아이디</th>
	      <th>패스워드</th>
	      <th>이름</th>
	      <th>전화번호</th>
	      <th>성별</th>
	      <th>취미</th>
	      <th>가입일</th>
	    </tr>
	    <c:forEach items="${list}" var="mDto">
	    <tr>
	      <td><a href="/memInfo?id=${mDto.id}">${mDto.id }</a></td>
	      <td>${mDto.pw }</td>
	      <td>${mDto.name }</td>
	      <td>${mDto.phone }</td>
	      <td>${mDto.gender }</td>
	      <td>${mDto.hobby }</td>
	      <td>${mDto.mdate }</td>
	    </tr>
	    </c:forEach>
	  </table>
	 
	   <div><a href="/">메인페이지 이동</a></div>
	
	</body>
</html>