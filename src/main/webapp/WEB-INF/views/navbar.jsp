<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<nav class="container container--70">
    <ul class="nav--actions">
        <sec:authorize access="isAnonymous()">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li>
                Zalogowany jako: <sec:authentication property="principal.username"/>
            </li>
            <li>
                <form:form action="/logout" method="post">
                    <input type="submit" value="Wyloguj">
<%--                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
                </form:form>
            </li>
        </sec:authorize>
    </ul>

    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="donation/add" class="btn btn--without-border">Przekaż dar</a></li>
        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#" class="btn btn--without-border">O nas</a></li>
        <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>