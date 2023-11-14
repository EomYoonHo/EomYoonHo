<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	<%@ include file="../../common/head.jsp" %>
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<%@ include file="../../common/nav.jsp" %>

    <section>
        <div class="table-container">
          <table class="table table-hover" id="content">
          <thead>
            <tr>
              <th>글번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>조회수</th>
            </tr>
          </thead>
          <tbody class="table-group-divider" id="table-content">

			<c:choose>
				<c:when test="${empty list}">
					<tr>
						<td colspan="5" class="text-center">등록된 글이 없습니다.</td>
					</tr>
				</c:when>
				
				<c:otherwise>
					<c:forEach var="item" items="${list}">
						<tr>
							<td>${row}</td>90
							<td>${item.title}</td>
							<td>${item.writer}</td>
							<td>${item.inDate}</td>
							<td>${item.views}</td>
						</tr>
						<c:set var="row" value="${row-1 }" />
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
          </tbody>
        </table>
        <nav aria-label="Page navigation example">
        
        
  <ul class="pagination">
  
  
  	<c:choose>
  		<c:when test="${pi.currentPage == 1}">
		    <li class="page-item">
		      <a class="page-link" href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
	    </c:when>
	    
	    <c:otherwise>
  		    <li class="page-item">
		      <a class="page-link" href="/freeList.do?cpage=${pi.currentPage-1}" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
	    </c:otherwise>
    </c:choose>
    
    
    <c:forEach var="page" begin="${pi.startPage}" end="${pi.endPage}">
	    <li class="page-item"><a class="page-link" href="/freeList.do?cpage=${page}">${page}</a></li>
    </c:forEach>
    
    
    <c:choose>
    	<c:when test="${pi.currentPage == pi.maxPage}">
		    <li class="page-item">
		      <a class="page-link" href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
	    </c:when>
	    
	    <c:otherwise>
  		    <li class="page-item">
		      <a class="page-link" href="/freeList.do?cpage=${pi.currentPage+1}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
	    </c:otherwise>
    </c:choose>
    
    
    
  </ul>
</nav>
            <button class="add-button" onclick="window.location.href = 'enrollForm.html'">등록</button>
        </div>
  </section>

	<%@ include file="../../common/footer.jsp" %>
</body>
</html>