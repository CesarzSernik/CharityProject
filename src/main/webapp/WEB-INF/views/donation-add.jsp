<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp"/>

<jsp:useBean id="categories" scope="request" type="java.util.List"/>
<form:checkboxes path="categories"
                 items="${categories}" itemLabel="name" itemValue="id"/>
<jsp:useBean id="institutions" scope="request" type="java.util.List"/>
<form:select path="institution" items="${institutions}" itemLabel="name" itemValue="id"/>
<form:input path="zipCode" />
<form:input path="street" />
<form:input path="city"/>
<form:input path="quantity"/>
<form:textarea path="pickUpComment"/>
<form:input type="date" path="pickUpDate"/>
<form:input type="time" path="pickUpTime" />

<jsp:include page="footer.jsp"/>
