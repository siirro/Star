<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Star</title>

<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer src="/js/fileManager.js"></script>
<script defer src="/js/board/add.js"></script>

</head>
 <body>
 	<div style="display: flex; justify-content: center;">
	<h1>QNA 작성</h1>
	</div>
	
	<sec:authentication property="Principal" var="user"/>
	
	<div style="display: flex; justify-content: center;">
		<form:form modelAttribute="boardVO" method="post" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="title" class="form-label">Title</label>
				<form:input path="title" cssClass="form-control" id="title" placeholder="제목을 입력하세요"/>
				<form:errors path="title" id="titleError"></form:errors><br>
				<label for="title" id="titleErrorFront" class="form-label"></label>
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label>
				<form:input path="writer" value="${user.id}" cssClass="form-control" readonly="true" id="writer" placeholder="작성자를 입력하세요"/>
				<form:errors path="writer" id="writerError"></form:errors><br>
				<label for="title" id="writerErrorFront" class="form-label"></label>
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<form:textarea path="contents" cssClass="form-control" id="summernote"/>
				<form:errors path="contents" id="contentsError"></form:errors><br>
				<label for="contents" id="contentsErrorFront" class="form-label"></label>
			</div>

			<div class="mb-3" id="fileBtnSpace">

			</div>
			<div class="mb-3">
				<button class="btn btn-info" type="button" id="fileBtn">FileAdd</button>
			</div>
			
			<button class="btn btn-primary" type="submit">작성</button>
		</form:form>
	</div>
	


<script>
$(document).ready(function () {
    $('#summernote').summernote({
        placeholder: '내용을 작성하세요',
        height: 250,
        maxHeight: 400
    });
});

</script>


    
</body>
</html>