<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<br><br>
<img src="/resources/uploads/images/${ user.avatar }" width="150" height="150" alt="Avatar" style="border-radius: 80px;display: block;margin-right: auto;margin-left: auto;" />
<br><br>
<form style="margin-left: 250px;margin-right: 250px;">
  <div class="form-row">
      <div class="form-group col-md-6">
      <label for="username">Username</label>
      <input type="text" class="form-control" id="username" value="${ user.username }">
    </div>
    <div class="form-group col-md-6">
      <label for="email">Email</label>
      <input type="email" class="form-control" id="inputEmail4" value="${ user.email }">
    </div>
  </div>
  <div class="form-group">
    <label for="fullname">Fullname</label>
    <input type="text" class="form-control" id="fullname" value="${ user.fullname }">
  </div>
  <div class="form-group">
    <label for="birthday">Birthday</label>
    <fmt:formatDate value="${ user.birthday }" var="date" pattern="dd/MM/yyyy"/>
    <input type="text" class="form-control" id="birthday" value="${ date }">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="city">City</label>
      <input type="text" class="form-control" id="city" value="${ user.city }">
    </div>
    <div class="form-group col-md-4">
      <label for="phone">Phone</label>
      <input type="text" class="form-control" id="phone" value="${ user.phone }">
    </div>
    <div class="form-group col-md-2">
      <label for="gender">Gender</label>
      <input type="text" class="form-control" id="gender" value="${ user.gender }">
    </div>
  </div>  
</form>