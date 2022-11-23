<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp"/>
<header>
    <jsp:include page="navbar.jsp"/>
    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1 class="bold">
                Dziękujemy za rejestrację.
                Potwierdzenie zostało wysłane na podany adres e-mail.
                Logowanie zostało umożliwione.
            </h1>
        </div>
    </div>
</header>

<jsp:include page="footer.jsp"/>