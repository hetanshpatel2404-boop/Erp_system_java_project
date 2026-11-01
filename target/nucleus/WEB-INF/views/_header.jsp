<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>NUCLEUS - NUV Student Community</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/app/dashboard">NUCLEUS</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarMenu"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarMenu">
            <ul class="navbar-nav me-auto">
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/dashboard">Dashboard</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/posts">Community</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/resources">Resources</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/notices">Notices</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/events">Events</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/clubs">Clubs</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/appointments">Appointments</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/projects">Project Partner</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/issues">Campus Issues</a></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/app/achievements">Achievements</a></li>
            </ul>
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><span class="navbar-text">Hello, ${sessionScope.user.fullName}</span></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
<main class="container py-4">
