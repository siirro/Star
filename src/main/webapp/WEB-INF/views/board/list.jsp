<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Star</title>
<c:import url="../temp/boot.jsp"></c:import>
</head>
<body>

<h1>List Page</h1>
<div id="contents" style="display: flex; justify-content: center; flex-wrap: wrap;">
	
	<div>
	
		<!-- 내용 Search -->
        <div class="" style="display: flex; margin: 0 0 5px 0;">
        <form action="./list" method="get" class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
    
            <div class="input-group">
                <div class="search-category" id="search-category" style="margin-right: 5px;">
                    <select name="kind" class="custom-select form-control" style="appearance: auto; padding: d; height: 37px;">
                        <option class="kinds" value="title">제목</option>
                        <option class="kinds" value="contents">내용</option>
                        <option class="kinds" value="writer">작성자</option>
                    </select>
                </div>
                <input name="search" value="${param.search}" id="search" type="text" class="form-control bg-light border-0 small w-10" placeholder="Search"
                    aria-label="Search" aria-describedby="basic-addon2" style="border-radius: 8px;">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">
                        검색
                    </button>
                </div>
            </div>
        </form>
        </div>
		
		<table class="table table-primary table-hover" style="width: 900px">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
					<tr style="cursor: pointer;" onclick="location.href='./detail?num=${list.num}'">
						<td>${list.num}</td>
						<td>${list.title}</td>
						<td>${list.writer}</td>
						<td>${list.regDate}</td>
						<td>${list.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		    <li class="page-item">
		      <a class="page-link ${pager.pre?'':'disabled'}" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		    	<li class="page-item pages" id="page${i}">
		    	<a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
		    	</li>
		    </c:forEach>
		    <li class="page-item">
		      <a class="page-link ${pager.next?'':'disabled'}" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
		
		
	</div>
</div>
<script>
    // url의 페이지 번호에 맞춰 페이지네이션 active
    let pages = document.querySelectorAll(".pages")
    const url = new URL(window.location.href);
    
    if(url.searchParams.get("page")!=null) {
    	
/* 	    let curPage = url.searchParams.get("page");
 */	    let curPage = '${param.page}';
		    if(curPage!='') {
		        let ddd = document.getElementById("page"+curPage);
		        ddd.setAttribute("class","active");
		    };
    };
    
    // kind 검색시 고정
    let k = '${param.kind}';
    const kinds = document.getElementsByClassName('kinds');
    for(let i=0;i<kinds.length;i++) {
        if(k==kinds[i].value) {
            kinds[i].selected=true;
            break;
        }
    }
</script>
</body>
</html>