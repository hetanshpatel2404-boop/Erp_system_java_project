<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><title>Login - NUCLEUS</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"></head>
<body class="bg-light"><div class="container"><div class="row justify-content-center align-items-center min-vh-100"><div class="col-md-5">
<div class="card shadow"><div class="card-body p-4"><h3 class="text-center mb-3 text-primary fw-bold">NUCLEUS</h3><h5 class="text-center mb-4">Login</h5>
<c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/login">
<div class="mb-3"><label class="form-label">Email</label><input type="email" name="email" class="form-control" required></div>
<div class="mb-3"><label class="form-label">Password</label><input type="password" name="password" class="form-control" required></div>
<button class="btn btn-primary w-100">Login</button></form>
<p class="text-center mt-3">New user? <a href="${pageContext.request.contextPath}/register">Register here</a></p>
</div></div></div></div></div></body></html>
