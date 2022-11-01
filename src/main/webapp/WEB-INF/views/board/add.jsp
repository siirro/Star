<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Star</title>

<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer src="/js/fileManager.js"></script>

</head>
 <body>
 	<div style="display: flex; justify-content: center;">
	<h1>QNA 작성</h1>
	</div>
	
	<div style="display: flex; justify-content: center;">
		<form:form modelAttribute="boardVO" method="post" enctype="multipart/form-data">
			<div class="mb-3">
				<label for="title" class="form-label">Title</label>
				<form:input path="title" cssClass="form-control" id="title" placeholder="제목을 입력하세요"/>
				<form:errors path="title"></form:errors>
			</div>
			<div class="mb-3">
				<label for="writer" class="form-label">Writer</label>
				<input name="writer" type="text" class="form-control" id="writer" placeholder="작성자를 입력하세요">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" id="summernote" name="contents"></textarea>
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