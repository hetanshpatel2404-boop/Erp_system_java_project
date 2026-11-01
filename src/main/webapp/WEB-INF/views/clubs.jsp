<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Clubs & Membership</h2>
<div class="row"><div class="col-md-6"><div class="card mb-4"><div class="card-body"><h5>Create Club</h5>
<form method="post" action="${pageContext.request.contextPath}/app/clubs"><input type="hidden" name="action" value="createClub">
<div class="mb-3"><label class="form-label">Club Name</label><input type="text" name="name" class="form-control" required></div>
<div class="mb-3"><label class="form-label">Description</label><textarea name="description" class="form-control" rows="2"></textarea></div>
<button class="btn btn-primary">Create Club</button></form></div></div></div>
<div class="col-md-6"><div class="card mb-4"><div class="card-body"><h5>Join Club</h5>
<form method="post" action="${pageContext.request.contextPath}/app/clubs"><input type="hidden" name="action" value="joinClub">
<div class="mb-3"><label class="form-label">Select Club</label><select name="clubId" class="form-select">
<c:forEach var="club" items="${clubs}"><option value="${club.id}"><c:out value="${club.name}"/></option></c:forEach></select></div>
<button class="btn btn-success">Join Club</button></form></div></div></div></div>
<h4 class="mt-4">Available Clubs</h4>
<table class="table table-bordered table-striped"><thead class="table-dark"><tr><th>Club Name</th><th>Description</th></tr></thead><tbody>
<c:forEach var="club" items="${clubs}"><tr><td><c:out value="${club.name}"/></td><td><c:out value="${club.description}"/></td></tr></c:forEach></tbody></table>
<h4 class="mt-5">Club Members</h4>
<table class="table table-bordered table-striped"><thead class="table-dark"><tr><th>Club</th><th>Student</th><th>Role</th><th>Action</th></tr></thead><tbody>
<c:forEach var="member" items="${members}"><tr><td><c:out value="${member.club.name}"/></td><td><c:out value="${member.user.fullName}"/></td>
<td><form method="post" action="${pageContext.request.contextPath}/app/clubs" class="d-flex"><input type="hidden" name="action" value="updateRole"><input type="hidden" name="memberId" value="${member.id}">
<select name="role" class="form-select me-2"><option value="MEMBER" ${member.role == 'MEMBER' ? 'selected' : ''}>MEMBER</option><option value="COORDINATOR" ${member.role == 'COORDINATOR' ? 'selected' : ''}>COORDINATOR</option><option value="HEAD" ${member.role == 'HEAD' ? 'selected' : ''}>HEAD</option></select>
<button class="btn btn-sm btn-primary">Update</button></form></td>
<td><form method="post" action="${pageContext.request.contextPath}/app/clubs" onsubmit="return confirmAction('Remove this member?');"><input type="hidden" name="action" value="removeMember"><input type="hidden" name="memberId" value="${member.id}"><button class="btn btn-sm btn-danger">Remove</button></form></td></tr></c:forEach></tbody></table>
<%@ include file="_footer.jsp" %>
