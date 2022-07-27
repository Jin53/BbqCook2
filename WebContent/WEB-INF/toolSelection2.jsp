<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="layout/app.jsp">
    <c:param name="content">
        <!--  <div class="container">-->
            <h2 class="col-12 text-center">道具選択</h2>
                <p>現在、持っているBBQ道具を選択してください。</p>
                    <form action="<%=request.getContextPath()%>/FoodBudget" method="get">
                        <div class="row row-cols-1 row-cols-md-2">
                            <c:forEach var="tools" items="${tool}" varStatus="loop">
                                <div class="col-md-4 mb-4">
                                <div class="card">
                                    <label class="form-check-label" for="toolList${loop.index}">
                                        <input type="checkbox" class="form-check-input" id="toolList${loop.index}" name="tool" value="${loop.index + 1}">
                                        <img class="col-lg-4" src="/BbqCook2/upload/${tools.tool_image}" id="toolList${loop.index}" alt="BBQ道具">
                                    </label>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                       <input class="col-5 btn btn-primary" type="submit"/>
                   </form>
        <!--  </div> -->
    </c:param>
</c:import>
