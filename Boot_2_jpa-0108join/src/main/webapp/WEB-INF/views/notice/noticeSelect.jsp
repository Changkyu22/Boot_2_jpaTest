<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/BS.jsp" />
</head>
<c:import url="../template/nav.jsp" />
<body>
${noticeVO.num}
${noticeVO.title}
${noticeVO.writer}
${noticeVO.contents}
${noticeVO.regDate}
${noticeVO.hit}
<br>
<c:forEach items="${noticeVO.noticeFilesVOs}" var="vo">
<img src="../images/${vo.fname}" class="img-rounded" style="width: 400px; height: 400px;">
${vo.fname}
</c:forEach>

</body>
</html>