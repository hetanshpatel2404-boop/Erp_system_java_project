<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Notices</h2>
<c:if test="${sessionScope.user.role == 'ADMIN' || sessionScope.user.role == 'FACULTY'}">
<div class="card mb-4"><div class="card-body">
<form method="post" action="${pageContext.request.contextPath}/app/notices">
<div class="mb-3"><label class="form-label">Notice Title</label><input type="text" name="title" class="form-control" required></div>
<div class="mb-3"><label class="form-label">Content</label><textarea name="content" class="form-control" rows="3" required></textarea></div>
<button class="btn btn-primary">Publish Notice</button></form></div></div></c:if>
<c:forEach var="notice" items="${notices}"><div class="card mb-3"><div class="card-body">
<h5 class="card-title"><c:out value="${notice.title}"/></h5><small class="text-muted">Posted by <c:out value="${notice.postedBy.fullName}"/> at ${notice.postedAt}</small>
<p class="mt-3"><c:out value="${notice.content}"/></p></div></div></c:forEach>
<%@ include file="_footer.jsp" %>
