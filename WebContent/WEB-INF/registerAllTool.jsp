<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/Bbq.css">
<h1>登録道具一覧</h1>
<table id="tool_List">
    <tbody>
        <tr>
            <th>道具ID</th>
            <th>道具名前</th>
        </tr>
        <c:forEach var="allTool" items="${allTool}" varStatus="status">
            <tr class="row${status.count % 2}">
                <td><a
                    href="${pageContext.request.contextPath}/ToolEdit?id=${allTool.tool_id}&_token=${_token}">
                         <c:out
                            value="${allTool.tool_id}" />
                </a></td>
                <td><c:out value="${allTool.tool_name}" /></td>
                <td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div id="pagination">
    （全 ${tool_count} 件）<br />
    <c:forEach var="i" begin="1" end="${((tool_count - 1) / 15) + 1}"
        step="1">
        <c:choose>
            <c:when test="${i == page}">
                <c:out value="${i}" />&nbsp;
                    </c:when>
            <c:otherwise>
                <a href="<c:url value='/RegisterAllTool?page=${i}&_token=${_token}' />"><c:out
                        value="${i}" /></a>&nbsp;
                    </c:otherwise>
        </c:choose>
    </c:forEach>
</div>
<p>
    <a href="<c:url value='/ToolRegister' />">新規道具登録</a>
</p>
<input type="hidden" name="_token" value="${_token}" />
