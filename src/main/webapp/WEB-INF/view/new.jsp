<%@ include file="/WEB-INF/view/partials/header.jsp" %>
<%@ page isErrorPage="true" %>

<form:form class="input-form" action="/employees" modelAttribute="employee" method="post">
    <div class="form-group justify-content-center row">
        <label for="first_name" class="col-sm-2 col-form-label">First Name</label>
        <div class="col-sm-10">
            <form:input path="firstName" type="text" class="form-control" id="first_name"/>
            <form:errors path="firstName" cssClass="error" />
        </div>
    </div>
    <div class="form-group row">
        <label for="last_name" class="col-sm-2 col-form-label">Last Name</label>
        <div class="col-sm-10">
            <form:input path="lastName" type="text" class="form-control" id="last_name"/>
            <form:errors path="lastName" cssClass="error" />
        </div>
    </div>
    <div class="form-group row">
        <label for="email" class="col-sm-2 col-form-label">Email</label>
        <div class="col-sm-10">
            <form:input path="email" type="text" class="form-control" id="email"/>
            <form:errors path="email" cssClass="error" />
        </div>
    </div>
    <div class="form-group row">
        <label for="phone_number" class="col-sm-2 col-form-label">Phone Number</label>
        <div class="col-sm-10">
            <form:input path="phoneNumber" type="text" class="form-control" id="phone_number"/>
            <form:errors path="phoneNumber" cssClass="error" />
        </div>
    </div>

    <div class="form-group row">
        <label for="photo" class="col-sm-2 col-form-label">Photo URL</label>
        <div class="col-sm-10">
            <form:input path="photo" type="text" class="form-control" id="photo"/>
        </div>
    </div>

    <form:button type="submit" class="btn btn-primary btn-lg btn-block">Save</form:button>

</form:form>
<a class="btn" href="${pageContext.request.contextPath}/employees/">Back to list</a>

<%@ include file="/WEB-INF/view/partials/footer.jsp" %>