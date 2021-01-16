<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"/>
<spring:url var="images" value="/resources/images"/>
<spring:url var="js" value="/resources/js"/>


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>OnlineDukan - ${title } </title>
    
    <script>
    window.menu = '${title}';
    
    
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.css" rel="stylesheet">

    <!-- Add custom CSS here -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

</head>




<body>

<div class="wrapper">
  <!-- Navigation -->
<%@include file="./shared/navbar.jsp" %>



	<!-- Page Content -->

<div class="content">
			
			<!-- Loading the home content -->
			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- Load only when user clicks about -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- Load only when user clicks contact -->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>
		
</div>
	

<!-- Footer here  -->
<%@include file="./shared/footer.jsp" %>
   




    <!-- JQuery -->
    <script src="${js}/jquery-1.10.2.js"></script>
    
    <!-- Bootstrap core JavaScript -->
    <script src="${js}/bootstrap.js"></script>
    
    <!-- Self Coed For Helight NevBar -->
        <script src="${js}/myapp.js"></script>
    
</div>
</body>

</html>