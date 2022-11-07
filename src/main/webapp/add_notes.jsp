<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Notes taker :home page</title>

<%@include file="all_js.jsp"%>

</head>
<body>

	<%@include file="navbar.jsp"%>

	<h2>This is add notes Page</h2>

	<!-- this is form -->

	<form action="SaveServlet" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Note Title</label> <input
				type="text" class="form-control" id="title"
				required="required"
				name="title"
				aria-describedby="emailHelp" placeholder="Enter email"> <small
				class="form-text text-muted">We'll never
				share your email with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="content">Note Content</label> 
			<textarea id="content"
			class="form-control"
			required="required"
			name="content"
			style="height:300px"
			> </textarea>
			
		</div>
		
		<div class="container text-center">
			<button type="submit" class="btn btn-primary">Ok</button>
		</div>
		
	</form>
</body>
</html>