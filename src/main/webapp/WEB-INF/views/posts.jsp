<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Student Community</h2>
<div class="card mb-4"><div class="card-body">
<form method="post" action="${pageContext.request.contextPath}/app/posts">
<div class="mb-3"><label class="form-label">Write a post</label><textarea name="content" class="form-control" rows="3" required></textarea></div>
<button class="btn btn-primary">Post</button></form></div></div>
<c:forEach var="post" items="${posts}">
<div class="card mb-4"><div class="card-body">
<h6 class="card-title"><c:out value="${post.user.fullName}"/></h6><small class="text-muted">${post.createdAt}</small>
<p class="mt-3"><c:out value="${post.content}"/></p>
<form method="post" action="${pageContext.request.contextPath}/app/like"><input type="hidden" name="postId" value="${post.id}">
<button class="btn btn-sm btn-outline-danger">Like</button> <span class="ms-2"><c:out value="${empty likeCounts[post.id] ? 0 : likeCounts[post.id]}"/> likes</span></form>
</div><div class="card-footer"><h6>Comments</h6>
<c:forEach var="comment" items="${commentsMap[post.id]}"><div class="mb-2"><strong><c:out value="${comment.user.fullName}"/></strong>: <c:out value="${comment.content}"/></div></c:forEach>
<form method="post" action="${pageContext.request.contextPath}/app/comments" class="d-flex mt-3"><input type="hidden" name="postId" value="${post.id}">
<input type="text" name="content" class="form-control me-2" placeholder="Write a comment" required><button class="btn btn-primary btn-sm">Comment</button></form>
</div></div></c:forEach>
<%@ include file="_footer.jsp" %>
