<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Academic Resources</h2>
<div class="card mb-4"><div class="card-body">
<form method="post" action="${pageContext.request.contextPath}/app/resources">
<div class="row"><div class="col-md-6 mb-3"><label class="form-label">Title</label><input type="text" name="title" class="form-control" required></div>
<div class="col-md-6 mb-3"><label class="form-label">Category</label><input type="text" name="category" class="form-control" placeholder="Notes, Syllabus, Previous Papers"></div>
<div class="col-md-12 mb-3"><label class="form-label">Resource URL</label><input type="text" name="url" class="form-control" placeholder="https://..."></div>
<div class="col-md-12 mb-3"><label class="form-label">Description</label><textarea name="description" class="form-control" rows="2"></textarea></div></div>
<button class="btn btn-success">Add Resource</button></form></div></div>
<table class="table table-bordered table-striped"><thead class="table-dark"><tr><th>Title</th><th>Category</th><th>Link</th><th>Uploaded By</th></tr></thead><tbody>
<c:forEach var="resource" items="${resources}"><tr><td><c:out value="${resource.title}"/></td><td><c:out value="${resource.category}"/></td>
<td><a href="<c:out value='${resource.url}'/>" target="_blank">Open Resource</a></td><td><c:out value="${resource.uploadedBy.fullName}"/></td></tr></c:forEach>
</tbody></table>
<%@ include file="_footer.jsp" %>
