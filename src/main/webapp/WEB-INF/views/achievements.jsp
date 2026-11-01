<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Student Achievement Portfolio</h2>
<div class="card mb-4"><div class="card-body"><h5>Add Achievement</h5>
<form method="post" action="${pageContext.request.contextPath}/app/achievements"><div class="row">
<div class="col-md-6 mb-3"><label class="form-label">Achievement Title</label><input type="text" name="title" class="form-control" required></div>
<div class="col-md-6 mb-3"><label class="form-label">Date</label><input type="date" name="achievementDate" class="form-control"></div>
<div class="col-md-6 mb-3"><label class="form-label">Proof URL</label><input type="text" name="proofUrl" class="form-control" placeholder="Certificate link, GitHub link..."></div>
<div class="col-md-12 mb-3"><label class="form-label">Description</label><textarea name="description" class="form-control" rows="2"></textarea></div></div>
<button class="btn btn-success">Add Achievement</button></form></div></div>
<table class="table table-bordered table-striped"><thead class="table-dark"><tr><th>Student</th><th>Title</th><th>Description</th><th>Date</th><th>Proof</th></tr></thead><tbody>
<c:forEach var="achievement" items="${achievements}"><tr><td><c:out value="${achievement.user.fullName}"/></td><td><c:out value="${achievement.title}"/></td>
<td><c:out value="${achievement.description}"/></td><td><c:out value="${achievement.achievementDate}"/></td>
<td><a href="<c:out value='${achievement.proofUrl}'/>" target="_blank">View Proof</a></td></tr></c:forEach></tbody></table>
<%@ include file="_footer.jsp" %>
