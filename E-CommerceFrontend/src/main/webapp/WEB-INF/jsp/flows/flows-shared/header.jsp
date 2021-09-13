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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${flowExecutionUrl}&_eventId_home">HOME</a>
			</div>
		</div>
	</nav>
	<br />
	<br />
	<br />
