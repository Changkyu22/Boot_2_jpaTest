<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="./memberJoin" method="post" enctype="multipart/form-data">

  <div class="form-group col-sm-3">
    <label for="id">ID:</label>
    <input type="text" class="form-control" placeholder="Enter id" id="id" name="id">
  </div>
  
  <div class="form-group col-sm-3">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="pw">
  </div>
  
  <div class="form-group col-sm-3">
    <label for="pwd2">Password check:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd2" name="pw2">
  </div>
  
  <div class="form-group col-sm-3">
    <label for="email">Email:</label>
    <input type="email" class="form-control" placeholder="Enter Email" id="email" name="email">
  </div>
  
  <div class="form-group col-sm-3">
    <label for="name">Name:</label>
    <input type="text" class="form-control" placeholder="Enter name" id="name" name="name">
  </div>
  
  <div class="form-group col-sm-3">
    <label for="files">Name:</label>
    <input type="file" class="form-control" id="files" name="files">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>