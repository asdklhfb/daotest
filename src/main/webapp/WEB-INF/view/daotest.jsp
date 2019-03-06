<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보입력</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>정보입력</h1>
	<c:url value="/daotest.do" var="dao" />
	<form action="${dao}" method="post">
		<table class="table table-dark" style="width:60%;" align="center">
			<tr>
				<th>이름</th>
				<td><input type="text" name="s_name" required="required"
					placeholder="예>장날라"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="s_age" required="required"
					placeholder="예> 28"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit" class="btn btn-warning">입력</button></td>
			</tr>
		</table>
	</form>
</body>
</html>