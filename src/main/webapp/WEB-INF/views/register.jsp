<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="header.jsp"/>
<header>
    <jsp:include page="navbar.jsp"/>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="newUser" method="post" action="/register">

        <div class="form-group">
            <form:input path="name" type="text" name="name" placeholder="Imię" />
        </div>
        <div class="form-group">
            <form:input path="surname" type="text" name="surname" placeholder="Nazwisko" />
        </div>
        <div class="form-group">
            <form:input path="email" type="email" name="email" placeholder="Email" />
        </div>
        <div class="form-group">
            <form:input path="password" type="password" name="password" placeholder="Hasło" />
        </div>
        <div class="form-group">
            <form:input path="password2" type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>

    </form:form>
</section>

<jsp:include page="footer.jsp"/>