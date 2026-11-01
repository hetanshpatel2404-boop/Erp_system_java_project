<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Welcome to NUCLEUS</h2>
<div class="alert alert-info">JDBC Connection Status: <strong>${jdbcConnected ? "Connected" : "Failed"}</strong></div>
<div class="row">
<div class="col-md-4 mb-3"><div class="card h-100"><div class="card-body"><h5 class="card-title">Student Community</h5><p class="card-text">Create posts, comment and like.</p><a href="${pageContext.request.contextPath}/app/posts" class="btn btn-primary">Open</a></div></div></div>
<div class="col-md-4 mb-3"><div class="card h-100"><div class="card-body"><h5 class="card-title">Academic Resources</h5><p class="card-text">Access study materials and notices.</p><a href="${pageContext.request.contextPath}/app/resources" class="btn btn-success">Open</a></div></div></div>
<div class="col-md-4 mb-3"><div class="card h-100"><div class="card-body"><h5 class="card-title">Events & Clubs</h5><p class="card-text">Discover university events and clubs.</p><a href="${pageContext.request.contextPath}/app/events" class="btn btn-warning">Events</a> <a href="${pageContext.request.contextPath}/app/clubs" class="btn btn-info">Clubs</a></div></div></div>
<div class="col-md-4 mb-3"><div class="card h-100"><div class="card-body"><h5 class="card-title">Faculty Appointments</h5><p class="card-text">Book faculty meeting slots.</p><a href="${pageContext.request.contextPath}/app/appointments" class="btn btn-secondary">Open</a></div></div></div>
<div class="col-md-4 mb-3"><div class="card h-100"><div class="card-body"><h5 class="card-title">Project Partner Finder</h5><p class="card-text">Find teammates for projects.</p><a href="${pageContext.request.contextPath}/app/projects" class="btn btn-dark">Open</a></div></div></div>
<div class="col-md-4 mb-3"><div class="card h-100"><div class="card-body"><h5 class="card-title">Campus Issues</h5><p class="card-text">Report and track campus problems.</p><a href="${pageContext.request.contextPath}/app/issues" class="btn btn-danger">Open</a></div></div></div>
</div>
<%@ include file="_footer.jsp" %>
