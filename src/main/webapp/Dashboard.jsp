<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Class Report</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<style>
.body-container{
padding:30px;
margin:0;
margin-top:50px;
display: flex;
flex-direction: column;
align-items: center;
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
</head>
<body>
<header>
<%!

public String getData(String i){
	
	return i;
	
	
}

%>


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

<div class="body-container">



				<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/ph2_la" user="root" password="root"/>
				<sql:query var="rs" dataSource="${db}">
				SELECT * FROM courses
				</sql:query>
				<c:forEach var="main" items="${rs.rows}">
				
				<h2><c:out value="${main.course}" /> class</h2>
				
				
				<sql:query var="rs2" dataSource="${db}">
				SELECT * FROM students where course like "${main.course}";
				</sql:query>
				<sql:query var="rs3" dataSource="${db}">
				      
				      SELECT * FROM classes where courses like "%${main.course}%"
					
				</sql:query>
				<h3>Students List</h3>
				<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Class Name</th>
						<th>Address</th>
						
					</tr>
				</thead>
				<c:forEach var="list" items="${rs2.rows}">
				
				
				<tbody>
				<tr>
							<td><c:out value="${list.id}" /></td>
							<td><c:out value="${list.name}" /></td>
							<td><c:out value="${list.email}" /></td>
							<td><c:out value="${list.course}" /></td>
							<td><c:out value="${list.country}" /></td>
							
						</tr>
						</tbody>
						
						
				</c:forEach>
				</table>
				<br/>
				
				<h2>Faculty List and Subject List</h2>
				
				<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Subject Name</th>
						<th>Faculty Name</th>
						<th>Duration</th>
						<th>Other Classes Handling by Faculty</th>
						
					</tr>
				</thead>
				<c:forEach var="l" items="${rs3.rows}">
				
				
				<tbody>
				<tr>
							<td><c:out value="${l.id}" /></td>
							<td><c:out value="${l.name}" /></td>
							<td><c:out value="${l.teacher}" /></td>
							<td><c:out value="${l.duration}" /></td>
							<td><c:out value="${l.courses}" /></td>
							
							
						</tr>
						</tbody>
				
				
				
				
				</c:forEach>
				</table>
				<br/>
				
				</c:forEach>
				<br/>
					
				
</div>

</body>
</html>