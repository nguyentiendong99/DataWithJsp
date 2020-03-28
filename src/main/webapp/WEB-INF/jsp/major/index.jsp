<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello nguyen tien dong</title>
</head>
<body>
<p style="color: red">${message}</p>
<form:form action="#" modelAttribute="major">
    <div>
        <label>ID Major</label>
        <form:input path="id"/>
        <br>
        <label>User Name</label>
        <form:input path="name"/>
        <br>
        <button name="btnInsert">Insert</button>
        <button name="btnUpdate">Update</button>
    </div>
</form:form>
<br>
<h1>Danh sach Major </h1>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>User Name</th>
    </tr>
    <c:forEach var="u" items="${listmajor}">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>
                <a href="index/delete/${u.id}">Delete</a>
            </td>
            <td>
                <a href="index/edit/${u.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>