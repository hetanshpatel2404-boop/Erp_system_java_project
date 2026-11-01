<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="_header.jsp" %>
<h2 class="mb-4">Faculty Appointment Booking</h2>
<c:if test="${sessionScope.user.role == 'STUDENT'}"><div class="card mb-4"><div class="card-body"><h5>Book Appointment</h5>
<form method="post" action="${pageContext.request.contextPath}/app/appointments"><input type="hidden" name="action" value="createAppointment">
<div class="row"><div class="col-md-6 mb-3"><label class="form-label">Faculty</label><select name="facultyId" class="form-select" required>
<c:forEach var="faculty" items="${faculties}"><option value="${faculty.id}"><c:out value="${faculty.fullName}"/></option></c:forEach></select></div>
<div class="col-md-3 mb-3"><label class="form-label">Date</label><input type="date" name="appointmentDate" class="form-control" required></div>
<div class="col-md-3 mb-3"><label class="form-label">Time</label><input type="time" name="timeSlot" class="form-control" required></div>
<div class="col-md-12 mb-3"><label class="form-label">Purpose</label><textarea name="purpose" class="form-control" rows="2" required></textarea></div></div>
<button class="btn btn-primary">Request Appointment</button></form></div></div></c:if>
<h4>Appointment List</h4>
<table class="table table-bordered table-striped"><thead class="table-dark"><tr><th>Student</th><th>Faculty</th><th>Date</th><th>Time</th><th>Purpose</th><th>Status</th><th>Action</th></tr></thead><tbody>
<c:forEach var="appointment" items="${appointments}"><tr><td><c:out value="${appointment.student.fullName}"/></td><td><c:out value="${appointment.faculty.fullName}"/></td>
<td><c:out value="${appointment.appointmentDate}"/></td><td><c:out value="${appointment.timeSlot}"/></td><td><c:out value="${appointment.purpose}"/></td><td><c:out value="${appointment.status}"/></td>
<td><c:if test="${sessionScope.user.role == 'ADMIN' || sessionScope.user.id == appointment.faculty.id}">
<form method="post" action="${pageContext.request.contextPath}/app/appointments"><input type="hidden" name="action" value="updateAppointment"><input type="hidden" name="appointmentId" value="${appointment.id}">
<select name="status" class="form-select mb-2"><option value="PENDING" ${appointment.status == 'PENDING' ? 'selected' : ''}>PENDING</option><option value="APPROVED" ${appointment.status == 'APPROVED' ? 'selected' : ''}>APPROVED</option><option value="REJECTED" ${appointment.status == 'REJECTED' ? 'selected' : ''}>REJECTED</option></select>
<button class="btn btn-sm btn-success">Update</button></form></c:if></td></tr></c:forEach></tbody></table>
<%@ include file="_footer.jsp" %>
