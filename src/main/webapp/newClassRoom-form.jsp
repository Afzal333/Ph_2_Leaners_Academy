

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
    <p class="logo">Add New Class Room</p>
      <a href="<%=request.getContextPath()%>/list-class"
					class="nav-link"><button class="btn btn-outline-secondary" > < Go Back</button></a>	
			
									
  </div>
  </nav>

	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${c != null}">
					<form action="updateclassroom" method="post">
				</c:if>
				<c:if test="${c == null}">
					<form action="insertclassroom" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${c != null}">
            			Edit Subject
            		</c:if>
						<c:if test="${c == null}">
            			Add New Subject
            		</c:if>
					</h2>
				</caption>

				<c:if test="${c != null}">
					<input type="hidden" name="id" value="<c:out value='${c.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Subject Name</label> <input type="text"
						value="<c:out value='${c.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Duration</label> <input type="text"
						value="<c:out value='${c.duration}' />" class="form-control"
						name="duration">
				</fieldset>
				
				<fieldset class="form-group">
					 <label for="teacher">Choose a Faculty</label>
					 <br/>
						  <select name="teacher" id="teacher" >
						  	<c:forEach var="list" items="${teachersList}">
						  	 <option value="<c:out value="${list.name}" />"><c:out value="${list.name}" /></option>
						  	</c:forEach>
						   
						  </select>
				</fieldset>
				
				<fieldset class="form-group">
					 <label for="course">Pick Courses</label>
					 <br/>
					 <c:forEach var="list" items="${courses}">
					 <input type="checkbox" id="<c:out value="${list.course}" />" name="courses" value="<c:out value="${list.course}" />">
					 <label for="<c:out value="${list.course}" />"><c:out value="${list.course}" /></label><br>
					 </c:forEach>
					</fieldset>

				<button style="margin-top:5px" type="submit" class="btn btn-success">Save</button>
	
				
			</div>
		</div>
	</div>
</body>
</html>