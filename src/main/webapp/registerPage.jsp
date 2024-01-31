<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="registrationForm" method="post" action="registration">
    <h1>Register Form</h1>
    <table style="with: 80%">
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><input type="text" name="surname"/></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>Country</td>
            <td><input type="text" name="country"/></td>
        </tr>
    </table>
    <input type="register" value="Register"/>
</form>
