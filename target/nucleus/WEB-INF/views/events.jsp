<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Events</h2>
<div class="card mb-4"><div class="card-body">
<form method="post" action="${pageContext.request.contextPath}/app/events">
<div class="row"><div class="col-md-6 mb-3"><label class="form-label">Event Title</label><input type="text" name="title" class="form-control" required></div>
<div class="col-md-6 mb-3"><label class="form-label">Event Date</label><input type="date" name="eventDate" class="form-control" required></div>
<div class="col-md-6 mb-3"><label class="form-label">Location</label><input type="text" name="location" class="form-control"></div>
<div class="col-md-12 mb-3"><label class="form-label">Description</label><textarea name="description" class="form-control" rows="2"></textarea></div></div>
<button class="btn btn-warning">Create Event</button></form></div></div>
<div class="row"><c:forEach var="event" items="${events}"><div class="col-md-4 mb-3"><div class="card h-100"><div class="card-body">
<h5 class="card-title"><c:out value="${event.title}"/></h5><p><strong>Date:</strong> <c:out value="${event.eventDate}"/></p>
<p><strong>Location:</strong> <c:out value="${event.location}"/></p><p><strong>Organizer:</strong> <c:out value="${event.organizer.fullName}"/></p>
<p><c:out value="${event.description}"/></p></div></div></div></c:forEach></div>
<%@ include file="_footer.jsp" %>
