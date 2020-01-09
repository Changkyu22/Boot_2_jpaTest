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

<div class="container">
<form:form action="./memberUpdate" modelAttribute="memberVO" method="post" enctype="multipart/form-data">
	 <div class="form-group">
      <label for="Id">Id:</label>
      <form:input path="id" placeholder="Enter Id" readonly="true" class="form-control" id="idcheck"/>
      <form:errors path="id" />
   	 </div>
   	 
	<div class="form-group">
      <label for="Name">Name:</label>
      <form:input path="name" class="form-control" id="name" placeholder="Enter Name"/>
    </div>
    
   
    
    <div class="form-group">
      <label for="Email">Email:</label>
      <form:input path="email" class="form-control" id="email" placeholder="Enter Email"/>
    </div>
	
	
	<div class="form-group">
      <label for="File">File:</label>
      <input type="file" class="form-control" id="files" name="files">
    </div>
	
	 <button type="submit" class="btn btn-default">Submit</button>
	
	</form:form>
</div>

</body>
</html>