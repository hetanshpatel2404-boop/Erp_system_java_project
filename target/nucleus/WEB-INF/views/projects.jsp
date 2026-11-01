<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Project Partner Finder</h2>
<div class="card mb-4"><div class="card-body"><h5>Post Project Requirement</h5>
<form method="post" action="${pageContext.request.contextPath}/app/projects"><input type="hidden" name="action" value="createProject">
<div class="row"><div class="col-md-6 mb-3"><label class="form-label">Project Title</label><input type="text" name="title" class="form-control" required></div>
<div class="col-md-6 mb-3"><label class="form-label">Required Skills</label><input type="text" name="skillsRequired" class="form-control" placeholder="Java, MySQL, HTML, CSS"></div>
<div class="col-md-12 mb-3"><label class="form-label">Description</label><textarea name="description" class="form-control" rows="2"></textarea></div></div>
<button class="btn btn-dark">Submit Request</button></form></div></div>
<table class="table table-bordered table-striped"><thead class="table-dark"><tr><th>Title</th><th>Description</th><th>Skills Required</th><th>Posted By</th><th>Status</th><th>Action</th></tr></thead><tbody>
<c:forEach var="project" items="${projects}"><tr><td><c:out value="${project.title}"/></td><td><c:out value="${project.description}"/></td><td><c:out value="${project.skillsRequired}"/></td>
<td><c:out value="${project.user.fullName}"/></td><td><c:out value="${project.status}"/></td>
<td><c:if test="${sessionScope.user.role == 'ADMIN' || sessionScope.user.id == project.user.id}">
<form method="post" action="${pageContext.request.contextPath}/app/projects"><input type="hidden" name="action" value="updateProject"><input type="hidden" name="projectId" value="${project.id}">
<select name="status" class="form-select mb-2"><option value="OPEN" ${project.status == 'OPEN' ? 'selected' : ''}>OPEN</option><option value="CLOSED" ${project.status == 'CLOSED' ? 'selected' : ''}>CLOSED</option></select>
<button class="btn btn-sm btn-primary">Update</button></form></c:if></td></tr></c:forEach></tbody></table>
<%@ include file="_footer.jsp" %>
