<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Star</title>
<c:import url="../temp/boot.jsp"></c:import>
<script defer type="text/javascript" uri="#"></script>
</head>
<body>
<div>
<h1>Join Page</h1>
</div>

<div style="display: flex;">
	<div>
		<form:form modelAttribute="memberVO" method="post">
			<div class="mb-3">
				<label for="id" class="form-label">ID</label>
				<form:input path="id" cssClass="form-control" id="id" placeholder="아이디를 입력하세요"/>
				<form:errors path="id"></form:errors>
				<label for="id" class="form-label" id="idLabel"></label>
			</div>
			<div class="mb-3">
				<label for="pw" class="form-label">PW</label>
				<form:password path="pw" cssClass="form-control" id="pw" placeholder="비밀번호를 입력하세요"/>
				<form:errors path="pw"></form:errors>
				<label for="pw" class="form-label" id="pwLabel"></label>
			</div>
			<div class="mb-3">
				<label for="pwCheck" class="form-label">PW</label>
				<form:password path="pwCheck" cssClass="form-control" id="pwCheck" placeholder="비밀번호를 다시 입력해주세요"/>
				<form:errors path="pwCheck"></form:errors>
				<label for="pwCheck" class="form-label" id="pwCheckLabel"></label>
			</div>
			<div class="mb-3">
				<label for="name" class="form-label">NAME</label>
				<form:input path="name" cssClass="form-control" id="name" placeholder="이름을 입력하세요"/>
				<form:errors path="name"></form:errors>
				<label for="name" class="form-label" id="nameLabel">${name}</label>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">EMAIL</label>
				<form:input path="email" cssClass="form-control" id="email" placeholder="이메일을 입력하세요"/>
				<form:errors path="email"></form:errors>
				<label for="email" class="form-label" id="emailLabel"></label>
			</div>
			<button type="submit" id="btn" class="btn btn-primary">회원가입</button>
		</form:form>
	</div>
</div>
</body>
</html>