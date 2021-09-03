

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
#course{
    width: 364px;
    height: 38;
}

</style>
<body>

	<header>
	<nav class="navbar navbar-light bg-light">
  
    <div class="nav_contain">
    <p class="logo">Learners Academy</p>
      <a href="<%=request.getContextPath()%>/"
					class="nav-link"><button class="btn btn-outline-secondary" > < Go Back</button></a>	
			
									
  </div>
  </nav>

	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
            			Edit Student
            		</c:if>
						<c:if test="${student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<c:if test="${student != null}">
					<input type="hidden" name="id" value="<c:out value='${student.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Student Name</label> <input type="text"
						value="<c:out value='${student.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Student Email</label> <input type="text"
						value="<c:out value='${student.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Student Country</label> <input type="text"
						value="<c:out value='${student.country}' />" class="form-control"
						name="country">
				</fieldset>
				
				<fieldset class="form-group">
					 <label for="course">Pick a Class</label>
					 <br/>
						  <select name="course" id="course" >
						  	<c:forEach var="list" items="${listCourses}">
						  	 <option value="<c:out value="${list.course}" />"><c:out value="${list.course}" /></option>
						  	</c:forEach>
						   
						  </select>
				</fieldset> 
				

				<button style="margin-top:5px" type="submit" class="btn btn-success">Save</button>
				</form>
				
			</div>
		</div>
	</div>
</body>
</html>