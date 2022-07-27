<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<div class="container">
<c:import url="layout/app.jsp">
    <c:param name="content">
        <h2 class="col-12 text-center">選択画面</h2>
            <div class="row">
                <div class="card col-lg-6">
                    <label for="tools">
                    <img class="card-img" src="https://images.unsplash.com/photo-1534177616072-ef7dc120449d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80" alt="CookTools">
                        <div class="card-img-overlay pl-4">
                            <form action="<%= request.getContextPath() %>/ToolSelection" method="GET">
                                <input class="btn btn-danger btn-lg" type="submit" id="tools" name="tool" value="道具選択へ" class= "button">
                            </form>
                        </div>
                    </label>
                </div>
                <div class="card col-lg-6">
                    <label for="foods">
                    <img class="card-img" src="https://images.unsplash.com/photo-1576866209830-589e1bfbaa4d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1770&q=80" alt="CookTools">
                        <div class="card-img-overlay pl-4">
                            <form method="GET" action="<%= request.getContextPath() %>/FoodSelection">
                                <input class="btn btn-danger btn-lg" type="submit" id="foods" value="食材選択へ">
                            </form>
                        </div>
                    </label>
                </div>
            </div>
    </c:param>
</c:import>
</div>
<!--  ${pageContext.request.contextPath}/-->