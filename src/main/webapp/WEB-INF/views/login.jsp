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
      <h2>Zaloguj się</h2>
      <form action="<c:url value="/login/process"/>" method="post">
        <div class="form-group">
          <input type="text" id="username" name="username" placeholder="Email"/>
        </div>
        <div class="form-group">
          <input type="password" id="password" name="password" placeholder="Hasło"/>
          <a href="/login/forgot-password" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
        <div class="form-group form-group--buttons">
          <a href="/register" class="btn btn--without-border">Załóż konto</a>
          <button class="btn" type="submit">Zaloguj się</button> 
        </div>
      </form>
    </section>

<jsp:include page="footer.jsp"/>