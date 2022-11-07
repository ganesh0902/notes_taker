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
<%@include file="all_js.jsp"%>
</head>
<body>
		<%@include file="navbar.jsp"%>
	<%
	int id = Integer.parseInt(request.getParameter("note_id").trim());

	Session s = factoryProvider.getFactory().openSession();
				
	Note note=s.get(Note.class, id);
	
	%>
		<h1> Edit here </h1>
						
	<form action="UpdateServlet" method="post">
		
		<input value=<%=note.getId()%> name="noteId" type="hidden">
	 
		<div class="form-group">
			<label for="exampleInputEmail1">Note Title</label> <input type="text"
				class="form-control" id="title" required="required" 
				name="title"
				aria-describedby="emailHelp" 
				placeholder="Enter email"
				value="<%=note.getTitle()%>"				
				> 				
				<small
				class="form-text text-muted">We'll never share your email
				with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="content">Note Content</label>
			<textarea id="content" class="form-control" required="required"
			name="content" style="height: 300px">
			<%=note.getContent() %>
			
			</textarea>

		</div>

		<div class="container text-center">
			<button type="submit" class="btn btn-success">Save your notes </button>
		</div>

	</form>
</body>
</html>