<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Learners Academy</title>

</head>
<style>
.body-container{
padding:30px;
margin:0;
margin-top:50px;
}
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
    width:500px;

}

</style>
<body>
<header>
		
		
		<nav class="navbar navbar-light bg-light">
  
    <div class="nav_contain">
    <p class="logo">Learners Academy</p>
    
      <a href="<%=request.getContextPath()%>/listuser"
					class="nav-link"><button class="btn btn-outline-secondary" >Students</button></a>	
		<a href="<%=request.getContextPath()%>/list-teacher"
					class="nav-link"><button class="btn btn-outline-secondary" >Teachers</button></a>			
 		<a href="<%=request.getContextPath()%>/list-class"
					class="nav-link"><button class="btn btn-outline-secondary" >Subjects</button></a>	
		<a href="<%=request.getContextPath()%>/list-courses"
					class="nav-link"><button class="btn btn-outline-secondary" >Classes</button></a>
		<a href="<%=request.getContextPath()%>/list-report"
					class="nav-link"><button class="btn btn-warning" >Class Report</button></a>		
					
		<a href="<%=request.getContextPath()%>/"
					class="nav-link"><button class="btn btn-danger" >Logout</button></a>				
    </div>
    	
									

</nav>
	</header>
	<br>
	
	
<div class="body-container">
	<div class="row">

		<div class="container">
			<h3 class="text-center">Students Master List</h3>
			<hr>
			<div >

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Student</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Class Name</th>
						<th>Address</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="student" items="${listStudent}">

						<tr>
							<td><c:out value="${student.id}" /></td>
							<td><c:out value="${student.name}" /></td>
							<td><c:out value="${student.email}" /></td>
							<td><c:out value="${student.course}" /></td>
							<td><c:out value="${student.country}" /></td>
							<td><a href="edit?id=<c:out value='${student.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</div>	

</body>
</html>