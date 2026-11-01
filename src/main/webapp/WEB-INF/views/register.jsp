<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><title>Register - NUCLEUS</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"></head>
<body class="bg-light"><div class="container"><div class="row justify-content-center align-items-center min-vh-100"><div class="col-md-6">
<div class="card shadow"><div class="card-body p-4"><h3 class="text-center mb-3 text-primary fw-bold">NUCLEUS</h3><h5 class="text-center mb-4">Create Account</h5>
<c:if test="${not empty error}"><div class="alert alert-danger">${error}</div></c:if>
<form method="post" action="${pageContext.request.contextPath}/register">
<div class="mb-3"><label class="form-label">Full Name</label><input type="text" name="fullName" class="form-control" required></div>
<div class="mb-3"><label class="form-label">Email</label><input type="email" name="email" class="form-control" required></div>
<div class="mb-3"><label class="form-label">Password</label><input type="password" name="password" class="form-control" required></div>
<div class="mb-3"><label class="form-label">Role</label><select name="role" class="form-select"><option value="STUDENT">Student</option><option value="FACULTY">Faculty</option></select></div>
<div class="mb-3"><label class="form-label">Skills / Interests</label><textarea name="skills" class="form-control" rows="2" placeholder="Java, Web Development, UI/UX..."></textarea></div>
<button class="btn btn-primary w-100">Register</button></form>
<p class="text-center mt-3">Already registered? <a href="${pageContext.request.contextPath}/login">Login here</a></p>
</div></div></div></div></div></body></html>
