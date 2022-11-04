<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Star</title>
<c:import url="./temp/boot.jsp"></c:import>
</head>
<body>
<h1>Index Page</h1>

<div>
<!-- 로그인 전 -->
<sec:authorize access="!isAuthenticated()">
<h3>안녕하세요</h3>
<h3>안녕</h3>
<a class="btn btn-info" href="./member/login">Login</a>
<a class="btn btn-info" href="./member/add">Join</a>
</sec:authorize>

<!-- 로그인 성공하면? -->
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="Principal" var="user"/>
	<h3>${user.id}님의 방문을 환영합니다!</h3>
	<h3>나의 등급은? ${user.roleVOs[0].roleName}</h3>
	<a class="btn btn-primary" href="./member/mypage">My Page</a>
	<a class="btn btn-danger" href="./member/logout">Logout</a>
</sec:authorize>

</div>

<a class="btn btn-warning m-2" href="./qna/list">QNA 게시판으로</a>

</body>
</html>