<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="layout/app.jsp">
    <c:param name="content">
            <h1 class="col-12">BBQ料理<br class="d-md-none">サーチシステム</h1>
            <h2 class="col-12 text-center">道具選択</h2>
                <p>現在、持っているBBQ道具を選択してください。</p>
                    <form action="<%=request.getContextPath()%>/FoodBudget" method="get">
                        <div class="row">
                            <c:forEach var="tools" items="${tool}" varStatus="loop">
                                  <div class="col-md-4 mb-4">
                                      <div class="card">
                                        <label class="form-check-label" for="toolList${loop.index}">
                                            <input type="checkbox" class="form-check-input" id="toolList${loop.index}" name="tool" value="${loop.index + 1}">
                                            <img class="card-img-top" src="/BbqCook2/upload/${tools.tool_image}" id="toolList${loop.index}" alt="BBQ道具">
                                            <div class="card-body">
                                                <div class="cardname">
                                                    <c:out value="${tools.tool_name}" />
                                                </div>
                                            </div>
                                        </label>
                                      </div>
                                  </div>
                            </c:forEach>
                        </div>
                       <input class="col-5 btn btn-primary" type="submit"/>
                   </form>
    </c:param>
</c:import>
