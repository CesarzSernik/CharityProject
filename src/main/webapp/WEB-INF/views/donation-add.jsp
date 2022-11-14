<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp"/>

<form:form method="post" action="/donation/save" modelAttribute="donation" cssClass="form--steps">

    <%--@elvariable id="categories" type="java.util.List"--%>
    Kategoria: <form:checkboxes path="categories"
                                items="${categories}" itemLabel="name" itemValue="id"/><br>
    <%--@elvariable id="institutions" type="java.util.List"--%>
    Fundacja: <form:select path="institution" items="${institutions}" itemLabel="name" itemValue="id"/><br>
    Kod pocztowy: <form:input path="zipCode"/><br>
    Ulica i numer budynku/mieszkania: <form:input path="street"/><br>
    Miasto: <form:input path="city"/><br>
    Ilość worków: <form:input path="quantity"/><br>
    Komentarz do darowizny: <form:textarea path="pickUpComment"/><br>
    Data odbioru: <form:input type="date" path="pickUpDate"/><br>
    Czas odbioru: <form:input type="time" path="pickUpTime"/><br>
    <input type="submit" value="Zapisz"/>

</form:form>

<jsp:include page="footer.jsp"/>
