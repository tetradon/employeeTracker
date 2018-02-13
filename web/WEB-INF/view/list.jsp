<%@ include file="/WEB-INF/view/partials/header.jsp" %>

<div class="top-bar">
    <a href="/employees/new" class="btn btn-outline-primary" role="button">Add Employee</a>
    <form:form class="inline float-right" action="search" method="get">
        Search employee: <input type="text" name="searchName" placeholder="Search"/>
        <input type="submit" value="Search" class="btn btn-outline-success"/>
    </form:form>
</div>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">id</th>
        <th scope="col">Last Name</th>
        <th scope="col">First Name</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td> ${employee.id} </td>
            <td> ${employee.lastName} </td>
            <td> ${employee.firstName} </td>
            <td><a href="${employee.id}" >Read More</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<%@ include file="/WEB-INF/view/partials/footer.jsp" %>