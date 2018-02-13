<%@ include file="/WEB-INF/view/partials/header.jsp" %>

<div class="row profile-info">
    <div class="col-3">
        <img src="${employee.photo}" class="img-thumbnail float-left"
        onerror=" this.onerror=null; this.src='https://image.flaticon.com/icons/svg/126/126486.svg';"/>
    </div>
    <div class="col-9">
        <table class="table">
            <tbody>

                <tr>
                    <th scope="row">id</th>
                    <td>${employee.id}</td>
                </tr>
                <tr>
                    <th scope="row">First Name</th>
                    <td>${employee.firstName}</td>
                </tr>
                <tr>
                    <th scope="row">Last Name</th>
                    <td>${employee.lastName}</td>
                </tr>
                <tr>
                    <th scope="row">Email</th>
                    <td>${employee.email}</td>
                </tr>
                <tr>
                    <th scope="row">Phone</th>
                    <td>${employee.phoneNumber}</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>



<a href="${employee.id}/edit" class="btn btn-warning">Update</a>

    <form:form class="inline" action="/employees/${employee.id}" modelAttribute="employee" method="delete">
        <form:button type="submit" class="btn btn-danger" onclick="if(!(confirm('Are you sure?'))) return false" >Delete</form:button>
    </form:form>

<a class="btn" href="${pageContext.request.contextPath}/employees/">Back to list</a>
<%@ include file="/WEB-INF/view/partials/footer.jsp" %>