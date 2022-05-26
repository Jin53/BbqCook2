<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>id : ${foodEdit.food_id} の編集</h1>

<form method="POST"
    action="${pageContext.request.contextPath}/FoodUpdate" enctype="multipart/form-data">
    <label>食材名<br /> <input type="text" name="foodName"
        value="${foodEdit.food_name}" />
    </label> <br />
    <label>画像<input type="file" name="pict" accept="image/*"></label>
     <input type="hidden" name="_token" value="${_token}" />
    <button type="submit">編集</button>
</form>

<p>
    <a href="${pageContext.request.contextPath}/RegisterAllFood">一覧に戻る</a>
</p>
<p>
    <a href="#" onclick="confirmDestroy();">この道具を削除する</a>
</p>
  <form method="POST" action="${pageContext.request.contextPath}/FoodDestroy">
            <input type="hidden" name="_token" value="${_token}" />
        </form>
        <script>
        function confirmDestroy() {
            if(confirm("本当に削除してよろしいですか？")) {
                document.forms[1].submit();
            }
        }
        </script>