<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="images" value="/rs/images" />
<spring:url var="custumcs" value="/rs/css" />
<spring:url var="custumjs" value="/rs/js" />
<spring:url var="jquery" value="/rs/vendor/jquery" />
<spring:url var="bootcs" value="/rs/vendor/bootstrap/css" />
<spring:url var="bootjs" value="/rs/vendor/bootstrap/js" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>



<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>${title}</title>

<!-- Bootstrap core CSS -->
<link href="${bootcs}/bootstrap.min.css" rel="stylesheet">

<!-- DataTable core CSS -->
<link href="${custumcs}/datatables.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${custumcs}/mystyle.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<%@include file="./shared/navbar.jsp"%>
<br/>
<br/>
<br/>


	<!-- Page Content -->
	
	<c:if test="${userclickhome == true}">
		<%@include file="home.jsp"%>
	</c:if>

	<c:if test="${userclickabout == true}">
		<%@include file="aboutus.jsp"%>
	</c:if>
	
	<c:if test="${userclickcontact == true}">
		<%@include file="contactus.jsp"%>
	</c:if>
	
	<c:if test="${userclickallproduct == true or userclickcategoryproduct == true }">
		<%@include file="listproduct.jsp"%>
	</c:if>
	
	<c:if test="${userclickmanageproduct == true}">
		<%@include file="manageproduct.jsp"%>
	</c:if>
	
	<c:if test="${userclickshowcart == true}">
		<%@include file="cart.jsp"%>
	</c:if>
	
	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="${jquery}/jquery.min.js"></script>
	<script src="${bootjs}/bootstrap.bundle.min.js"></script>
	
	<!-- DataTable core JavaScript -->
	<script src="${custumjs}/datatables.min.js"></script>
	
	<!-- Custum JavaScript -->
	<script src="${custumjs}/myscript.js"></script>

</body>

</html>
