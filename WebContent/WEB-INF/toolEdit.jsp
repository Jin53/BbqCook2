<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/Bbq.css">
<h1>id : ${toolEdit.tool_id} の編集</h1>

<form method="POST"
    action="${pageContext.request.contextPath}/ToolUpdate">
    <label>道具名<br /> <input type="text" name="toolName"
        value="${toolEdit.tool_name}" />
    </label> <br /> <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">編集</button>
</form>

<p>
    <a href="${pageContext.request.contextPath}/RegisterAllTool?_token=${_token}">一覧に戻る</a>
</p>
<p>
    <a href="#" onclick="confirmDestroy();">この道具を削除する</a>
</p>
  <form method="POST" action="${pageContext.request.contextPath}/ToolDestroy">
            <input type="hidden" name="_token" value="${_token}" />
            <input type="hidden" name="toolName" value="${toolEdit.tool_name}" />
        </form>
        <script>
        function confirmDestroy() {
            if(confirm("本当に削除してよろしいですか？")) {
                document.forms[1].submit();
            }
        }
        </script>

