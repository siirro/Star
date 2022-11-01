<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>

</head>
<body>
	<div class="container-fluid">
		<div class="row justify-content-center">
			
			
			<section class="col-6">
			<h1 style="margin: 3px">Detail Page</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${detail.num}</td>
							<td>${detail.title}</td>
							<td>${detail.writer}</td>
							<td>${detail.hit}</td>
							<td>${detail.regDate}</td>
						</tr>
					</tbody>
				</table>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글내용</th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="height: 50px">
							
							<c:forEach items="${detail.boardFileVOs}" var="file">
	                        	<img src="/file/board/${file.fileName}" alt="" width="auto" style="cursor: pointer;" onclick="location.href='/file/board/${file.fileName}'">
	                        	<br>
	                        	<a href="/fileDown/board?fileNum=${file.fileNum}">${file.oriName}</a>
	                        <br></br>
	                        </c:forEach>
							
							${detail.contents}
							
							</td>
							
						</tr>
					</tbody>
				</table>
				
				<div>
					<a href="./update?num=${detail.num}" class="btn btn-danger">수정</a>
					<a href="./delete" class="btn btn-danger">삭제</a>
					
				</div>
			</section>
		
		</div>
	</div>
	

	
	
	
</body>
</html>