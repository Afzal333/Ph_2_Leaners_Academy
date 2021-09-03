

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

</style>
<body>

	<header>
	<nav class="navbar navbar-light bg-light">
  
    <div class="nav_contain">
    <p class="logo">Learners Academy</p>
      <a href="<%=request.getContextPath()%>/list-teacher"
					class="nav-link"><button class="btn btn-outline-secondary" > < Go Back</button></a>	
			
									
  </div>
  </nav>

	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${teacher != null}">
					<form action="updateteacher" method="post">
				</c:if>
				<c:if test="${teacher == null}">
					<form action="insertteacher" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${teacher != null}">
            			Edit Teacher
            		</c:if>
						<c:if test="${teacher == null}">
            			Add New Teacher
            		</c:if>
					</h2>
				</caption>

				<c:if test="${teacher != null}">
					<input type="hidden" name="id" value="<c:out value='${teacher.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label> Name</label> <input type="text"
						value="<c:out value='${teacher.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Email</label> <input type="text"
						value="<c:out value='${teacher.email}' />" class="form-control"
						name="email" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Experience</label> <input type="text"
						value="<c:out value='${teacher.experience}' />" class="form-control"
						name="experience" required="required">
				</fieldset>

				<button style="margin-top:5px" type="submit" class="btn btn-success">Save</button>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>