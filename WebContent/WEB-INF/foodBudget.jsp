<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="layout/app.jsp">
    <c:param name="content">
        <h2 class="col-12 text-center">食材予算</h2>
        <c:if test="${requestScope.errors != null}">
            <ul>
                <c:forEach var="error" items="${requestScope.errors}">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </c:if>
        <form action="/BbqCook2/CookList" method=get>
            <div class="form-group">

                <input class="form-control col-3" id="person" type="number" name="person" placeholder="20まで" min="1" max="20" style="width: 8em;">
                <label for="person">人前</label>
                <br>
                <input class="form-control col-3" id="money" type="number" name="money">
                <label for="money">円</label>
            </div>
                <button class="btn btn-primary" type="submit">検索</button>
            </form>
    </c:param>
</c:import>
