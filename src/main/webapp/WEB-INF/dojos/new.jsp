<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>New Dojo</title> <!-- below was copied/pasted from New/Create Spring 1 and tagged the form above -->
	</head>
		<body>
			<h1>New Dojo</h1>
			
			<form:form action="/dojos" method="post" modelAttribute="dojo"> <!-- modelAttribute is just a name to be called -->
		    <p>
		        <form:label path="name">Name</form:label> <!-- path is the name of the field!! from model -->
		        <form:errors path="name"/>
		        <form:input path="name"/>
		    </p>
		  
		    <input type="submit" value="Submit"/>
			</form:form>
			
	</body>
</html>