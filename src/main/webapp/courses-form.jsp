

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Learners Academy</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<style>
.nav-container{
padding-left:30px;

}
.container-fluid {
display:flex;

}
.nav_contain{
display:flex;
}
.logo{
    align-self: flex-end;
    font-weight: 600;
    margin-left: 10px;
    margin-right: 30px;
    letter-spacing: 4px;
    font-size: 30px;

}
#teacher{
    width: 364px;
    height: 38;
}

</style>
<body>

	<header>
	<nav class="navbar navbar-light bg-light">
  
    <div class="nav_contain">
    <p class="logo">Add New Course</p>
      <a href="<%=request.getContextPath()%>/list-courses"
					class="nav-link"><button class="btn btn-outline-secondary" > < Go Back</button></a>	
			
									
  </div>
  </nav>

	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${c != null}">
					<form action="updatecourse" method="post">
				</c:if>
				<c:if test="${c == null}">
					<form action="insertcourse" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${c != null}">
            			Edit Class
            		</c:if>
						<c:if test="${c == null}">
            			Add New Class
            		</c:if>
					</h2>
				</caption>

				<c:if test="${c != null}">
					<input type="hidden" name="id" value="<c:out value='${c.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Course Name</label> <input type="text"
						value="<c:out value='${c.course}' />" class="form-control"
						name="course" required="required">
				</fieldset>

				
				
				

				<button style="margin-top:5px" type="submit" class="btn btn-success">Save</button>
	
				
			</div>
		</div>
	</div>
</body>
</html>