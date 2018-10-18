<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>New Ninja</title>
	</head>
	<body>
		<h1>New Ninja</h1>
		<form:form action="/ninjas" method="post" modelAttribute="ninja"> <!-- modelAttribute is just a name to be called -->
		    <form:select path="dojo">
		    	<c:forEach items="${allDojos}" var="d">
		    		<form:option value="${d.id}" label="${d.name}"/>
		    	
		    	</c:forEach>
		  </form:select>
		  	
		    <p>
		        <form:label path="firstName">First Name</form:label> <!-- path is the name of the field!! from model -->
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		    </p>
		    
		    <p>
		        <form:label path="lastName">Last Name</form:label> <!-- path is the name of the field!! from model -->
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </p>
		    
		    <p>
		        <form:label path="age">Age</form:label> <!-- path is the name of the field!! from model -->
		        <form:errors path="age"/>
		        <form:input path="age"/>
		    </p>
		  
		    
		    <input type="submit" value="Submit"/>
			</form:form>
	</body>
</html>