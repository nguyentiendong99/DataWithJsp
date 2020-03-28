<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Form Insert</h1>
<p style="color: darkred">${message}</p>
<form:form action="#" modelAttribute="user">
    <div>
        <label>Username</label>
        <form:input path="id"/>
    </div>
    <div>
        <label>Pass</label>
        <form:input path="password" />
    </div>
    <div>
        <label>Fullname</label>
        <form:input path="fullname"/>
    </div>
    <div>
        <label>Photo</label>
        <form:input path="photo"/>
    </div>
    <div>
        <label>Email</label>
        <form:input path="email"/>
    </div>
    <div>
        <button>Insert</button>
    </div>
</form:form>
</body>
</html>