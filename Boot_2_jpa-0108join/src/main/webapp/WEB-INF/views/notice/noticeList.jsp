<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/BS.jsp" />
</head>
<c:import url="../template/nav.jsp" />
<body>
<div class="contents">
	<table class="table table-hover">
		<tr>
			<td>NUM</td>
			<td>TITLE</td>
			<td>WRITER</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>
		<c:forEach items="${list}" var="vo">
			<tr>
				<td>${vo.num}</td>
				<td style="cursor: pointer;" onclick="location.href='noticeSelect?num=${vo.num}';">${vo.title}</td>
				<td>${vo.writer}</td>
				<td>${vo.regDate}</td>
				<td>${vo.hit}</td>
			</tr>
		</c:forEach>
	</table>
	<div style="margin: auto;">
			<ul class="pagination">
				<c:if test="${pager.curBlock gt 1}">
					<li><span class="list" id="${pager.startNum-1}">이전</span></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li><span class="list" id="${i}">${i}</span></li>
				</c:forEach>
				<c:if test="${pager.curBlock ne pager.totalBlock}">
					<li><span class="list" id="${pager.lastNum+1}">다음</span></li>
				</c:if>
			</ul>
		</div>
		
		<form  id="frm" action="noticeList">
			<input type="hidden" id="curPage" value= "1" name="curPage" >
			<select name="kind">
				<option id="kt" value="kt">Title</option>
				<option id="kw" value="kw">Writer</option>
				<option id="kc" value="kc">Contents</option>
			</select> 
			<input type="text" name="search" value="${pager.search}">
			<button>검색</button>

		</form>
</div>
<script type="text/javascript">
var kind = '${pager.kind}';
if(kind==''){
	kind='kt';
}
$("#"+kind).prop("selected", true);

$(".list").click(function() {
	$("#curPage").val($(this).attr("id"))
	$("#frm").submit();
});

</script>
</body>
</html>