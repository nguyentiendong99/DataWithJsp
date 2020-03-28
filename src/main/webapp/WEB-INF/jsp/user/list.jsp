<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>List du lieu tu bang User</h1>
    <table border="1" cellpadding="10">
        <tr>
            <th>Id</th>
            <th>Pass</th>
            <th>Name </th>
            <th>Photo</th>
            <th>Email</th>
        </tr>
        <c:forEach var="u" items="${list}">
            <tr>
                <th>${u.id}</th>
                <th>${u.password}</th>
                <th>${u.fullname}</th>
                <th>${u.photo}</th>
                <th>${u.email}</th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>