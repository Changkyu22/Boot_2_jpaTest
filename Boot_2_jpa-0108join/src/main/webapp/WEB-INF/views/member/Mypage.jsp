<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/BS.jsp" />
</head>
<body>
<c:import url="../template/nav.jsp" />
<div class="card" style="width:400px">
<c:forEach items="${memberfiles}" var="vo">
  <img class="card-img-top" src="../upload/${vo.fname}" alt="Card image">
</c:forEach>
  <div class="card-body">
    <h4 class="card-title">${member.name}</h4>
    <p class="card-text">${member.email}</p>
    <a href="memberUpdate" class="btn btn-primary">정보 수정</a>
  </div>
</div>


</body>
</html>