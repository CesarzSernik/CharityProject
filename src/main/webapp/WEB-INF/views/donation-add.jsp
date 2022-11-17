<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="header.jsp"/>

<%--@elvariable id="categories" type="java.util.List"--%>
<%--@elvariable id="institutions" type="java.util.List"--%>

<section class="form--steps">

    <%--Error messages--%>
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter" id="steps">Krok <span>1</span>/4</div>

        <form:form method="post" action="/donation/save" modelAttribute="donation">

            <%--STEP 1--%>
            <%--Change to c:forEach list--%>
            <div id="categoryStep" data-step="1" class="active">
                <h2 class="bold">Zaznacz co chcesz oddać:</h2>

                <c:forEach items="${categories}" var="category">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input
                                    type="checkbox"
                                    name="categories"
                                    value="${category.id}"
                            />
                            <span class="checkbox"></span>
                            <span class="description">
                                ${category.name}
                            </span>
                        </label>
                    </div>
                </c:forEach>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <%--STEP 2--%>
            <div id="quantityStep" data-step="2">
                <h2 class="bold">Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h2><br>
                <div class="form-group form-group--inline">
                    <form:label path="quantity">
                        Liczba 60l worków:
                        <form:input path="quantity"/>
                    </form:label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <%--STEP 3--%>
            <div id="institutionStep" data-step="3">
                <h2 class="bold">Wybierz organizację, której chcesz pomóc:</h2>
                <c:forEach items="${institutions}" var="institution">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="institution" value="${institution.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                  <div class="title">${institution.name}</div>
                  <div class="subtitle">Cel i misja: ${institution.description}</div>
                </span>
                        </label>
                    </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <%--STEP 4--%>
            <div id="addressAndDateStep" data-step="4">
                <h2 class="bold">Podaj adres oraz termin odbioru rzeczy przez kuriera:</h2><br>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h1 class="bold">Adres odbioru</h1>
                        <div class="form-group form-group--inline">
                            <form:label path="street">
                                Ulica: <form:input path="street"/>
                            </form:label>
                        </div>
                        <div class="form-group form-group--inline">
                            <form:label path="city">
                                Miasto: <form:input path="city"/>
                            </form:label>
                        </div>
                        <div class="form-group form-group--inline">
                            <form:label path="zipCode">
                                Kod pocztowy: <form:input path="zipCode"/>
                            </form:label>
                        </div>
                        <div class="form-group form-group--inline">
                            <form:label path="phoneNumber">
                                Numer telefonu: <form:input type="number" path="phoneNumber" maxlength="9"/>
                            </form:label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h1 class="bold">Termin odbioru</h1>
                        <div class="form-group form-group--inline">
                            <form:label path="pickUpDate">
                                Data: <form:input type="date" path="pickUpDate"/>
                            </form:label>
                        </div>
                        <div class="form-group form-group--inline">
                            <form:label path="pickUpTime">
                                Godzina: <form:input type="time" path="pickUpTime"/>
                            </form:label>
                        </div>
                        <div class="form-group form-group--inline">
                            <form:label path="pickUpComment">
                                Uwagi dla kuriera: <form:textarea path="pickUpComment"/>
                            </form:label>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <%--SUMMARY--%>
            <div id="conclusionStep" data-step="5">
                <h2 class="bold">Podsumowanie Twojej darowizny</h2>

                <div class="summary">
                    <div class="form-section">
                        <h1 class="bold">Oddajesz:</h1>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span class="summary--text">
                                        <%--${numberOfBags} worki ${categoryOfDonation}--%>
                                </span>
                            </li>
                            <li>
                                <span class="icon icon--hand"></span>
                                <span class="summary--text">
                                        <%--Dla fundacji: "${chosenInstitution}" w ${cityOfInstitution}<br>--%>
                                </span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h1 class="bold">Adres odbioru:</h1>
                            <ul>
                                <li id="sumStreet"></li>
                                <li id="sumCity"></li>
                                <li id="sumZipCode"></li>
                                <li id="sumPhoneNumber"></li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h1 class="bold">Termin odbioru:</h1>
                            <ul>
                                <li id="sumPickUpDate"></li>
                                <li id="sumPickUpTime"></li>
                                <li id="sumInfoForCourier"></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>


<jsp:include page="footer.jsp"/>