<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp"/>

<%--@elvariable id="categories" type="java.util.List"--%>
<%--@elvariable id="institutions" type="java.util.List"--%>
<div>
    <form:form method="post" action="/donation/save" modelAttribute="donation" cssClass="form--steps">

        <div class="steps" id="steps">Krok 1/4</div>

        // Change to c:forEach list
        <div id="categoryStep">
            <h2 class="bold">Zaznacz co chcesz oddać:</h2><br>
            <form:checkboxes path="categories"
                             items="${categories}" itemLabel="name" itemValue="id"/><br></div>

        <div id="quantityStep" hidden="hidden">
            <h2 class="bold">Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h2><br>
            Liczba 60l worków: <form:input path="quantity"/><br></div>

        // Change to c:forEach list
        <div id="institutionStep" hidden="hidden">
            <h2 class="bold">Wybierz organizację, której chcesz pomóc:</h2><br>
            <form:select path="institution" items="${institutions}"
                         itemLabel="name" itemValue="id"/><br></div>

        <div id="addressAndDateStep" hidden="hidden">
            <h2 class="bold">Podaj adres oraz termin odbioru rzeczy przez kuriera:</h2><br>

            <div>
                <h1 class="bold">Adres odbioru</h1><br>
                Ulica: <form:input path="street"/><br>
                Miasto: <form:input path="city"/><br>
                Kod pocztowy: <form:input path="zipCode"/><br>
                <form:input path="phoneNumber" type="number" maxlength="9" hidden="hidden"/><br>
            </div>

            <div>
                <h1 class="bold">Termin odbioru</h1><br>
                Data: <form:input type="date" path="pickUpDate"/><br>
                Godzina: <form:input type="time" path="pickUpTime"/><br>
                Uwagi dla kuriera: <form:textarea path="pickUpComment"/><br>
            </div>
        </div>

        <div id="conclusionStep" hidden="hidden">
            <h2 class="bold">Podsumowanie Twojej darowizny</h2><br>
            <h1 class="bold">Oddajesz:</h1><br>
            <div id="whatToWhom">
                    <%--${numberOfBags} worki ${categoryOfDonation}<br>--%>
                    <%--Dla fundacji: "${chosenInstitution}" w ${cityOfInstitution}<br>--%>
            </div>
            <div>
                <div>
                    <h1 class="bold">Adres odbioru:</h1><br>
                        <%--${pickUpStreet}<br>--%>
                        <%--${pickUpCity}<br>--%>
                        <%--${pickUpZipCode}<br>--%>
                        <%--${senderPhoneNumber}<br>--%>
                </div>
                <div>
                    <h1 class="bold">Termin odbioru:</h1>
                        <%--${pickUpDate}<br>--%>
                        <%--${pickUpTime}<br>--%>
                        <%--${infoForCourier}<br>--%>
                </div>
            </div>
        </div>

        <div>
            <input type="button" value="Wstecz" hidden="hidden"/>
            <input type="button" value="Dalej"/>
            <input type="submit" value="Potwierdzam" hidden="hidden"/>
        </div>

    </form:form>
</div>
<jsp:include page="footer.jsp"/>