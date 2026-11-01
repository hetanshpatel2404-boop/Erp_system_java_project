<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Campus Issue Tracking</h2>
<div class="card mb-4"><div class="card-body"><h5>Report Issue</h5>
<form method="post" action="${pageContext.request.contextPath}/app/issues"><input type="hidden" name="action" value="createIssue">
<div class="row"><div class="col-md-6 mb-3"><label class="form-label">Issue Title</label><input type="text" name="title" class="form-control" required></div>
<div class="col-md-6 mb-3"><label class="form-label">Location</label><input type="text" name="location" class="form-control" placeholder="Lab, Library, Classroom..."></div>
<div class="col-md-6 mb-3"><label class="form-label">Category</label><input type="text" name="category" class="form-control" placeholder="Electrical, Internet, Furniture..."></div>
<div class="col-md-12 mb-3"><label class="form-label">Description</label><textarea name="description" class="form-control" rows="2"></textarea></div></div>
<button class="btn btn-danger">Submit Issue</button></form></div></div>
<table class="table table-bordered table-striped"><thead class="table-dark"><tr><th>Title</th><th>Description</th><th>Location</th><th>Category</th><th>Reported By</th><th>Status</th><th>Action</th></tr></thead><tbody>
<c:forEach var="issue" items="${issues}"><tr><td><c:out value="${issue.title}"/></td><td><c:out value="${issue.description}"/></td><td><c:out value="${issue.location}"/></td>
<td><c:out value="${issue.category}"/></td><td><c:out value="${issue.user.fullName}"/></td><td><c:out value="${issue.status}"/></td>
<td><form method="post" action="${pageContext.request.contextPath}/app/issues"><input type="hidden" name="action" value="updateIssue"><input type="hidden" name="issueId" value="${issue.id}">
<select name="status" class="form-select mb-2"><option value="REPORTED" ${issue.status == 'REPORTED' ? 'selected' : ''}>REPORTED</option><option value="IN_PROGRESS" ${issue.status == 'IN_PROGRESS' ? 'selected' : ''}>IN_PROGRESS</option><option value="RESOLVED" ${issue.status == 'RESOLVED' ? 'selected' : ''}>RESOLVED</option></select>
<button class="btn btn-sm btn-warning">Update</button></form></td></tr></c:forEach></tbody></table>
<%@ include file="_footer.jsp" %>
