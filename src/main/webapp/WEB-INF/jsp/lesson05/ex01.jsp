<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리(1)</title>
</head>
<body>
	<h2>1. 변수 정의하기 (c:set)</h2>
	<c:set var="number1" value="100" />
	<c:set var="number2" >250</c:set>
	
	number1: ${number1}<br>
	number2: ${number2}<br>
	number1 + number2: ${number1 + number2}
	
	<h2>2. 변수 출력(c:out)</h2>
	number1: <c:out value="${number1}" /><br>
	<c:out value="Hello world" /><br>
	<c:out value="<script>alert('얼럿창 띄우기')</script>" /><br>
</body>
</html>