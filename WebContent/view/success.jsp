<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!-- jstl 선언문 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!-- request객체에 담겨있는 정보를 불러와 출력해주는 jsp -->
	<%-- JSP Expression Language --%>

	<ul>

		<!-- 속성 값을 접근 -->
		<li>Id: ${customer.id}</li>
		<li>Name: ${customer.name}</li>
		<li>Email: ${customer.email}</li>

	</ul>

	<!-- DoLogin.jsp에 ArrayList형식으로 저장되어있는 Customer 정보를 table형식으로 불러옴 -->
	<%-- JSTL --%>

	<table style="border: 1px solid red; padding: 10px;">

		<!-- forEach사용하여 자료접근 -->
		<c:forEach var="customer" items="${customerList}">
			<tr>
				<td>${customer.id}</td>
				<td>${customer.name}</td>
				<td>${customer.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>