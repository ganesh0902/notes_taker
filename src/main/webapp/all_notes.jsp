<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
<%@page import="java.util.List"%>
<%@page import="com.note.*"%>
<%@page import="com.helper.factoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@ include file="all_js.jsp"%>

</head>
<body>

	<%@include file="navbar.jsp"%>
	<br>

	<h2 class="text-upperCase">All Notes</h2>

	<%
	Session s = factoryProvider.getFactory().openSession();
			
	Query q = s.createQuery("from Note");

	List<Note> li = q.list();

	for (Note n : li) {
	%>
	<div class="card mt-3">
		<img src="https://play-lh.googleusercontent.com/vSNQds6F5roxdN4-a16JnQ9dWQVSZZ8OH4-iMAcNLaFQd3ItZWU8rOPOql4Ew5Hh1esX" class="rounded mx-auto d-block"  alt="...">
		<div class="card-body">
			<h5 class="card-title"><%=n.getTitle()%></h5>
			<p class="card-text"><%=n.getContent()%></p>
			<p class="card-text"><%=n.getAddDate() %></p>	
			<div class="container text-center mt-2">
			
				<a href="DeleteServlet?note_id=<%=n.getId()%>" class="btn btn-danger">Delete</a> 
				<a href="edit.jsp?note_id=<%=n.getId()%>"class="btn btn-primary">Update</a>
					
			</div>

		</div>
	</div>

	<%
		
	}

	%>
</body>
</html>