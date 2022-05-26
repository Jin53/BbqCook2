<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
<meta charset="UTF-8">
<title>新規食材登録</title>
<link rel=stylesheet href="css/Bbq.css">
</head>
<body>
    <form method="POST" action="<%= request.getContextPath() %>/FoodRegister" enctype="multipart/form-data" >
        <h1>新規食材登録</h1>
        <label for="foodregister">食材：</label>
        <input type="text" id="foodregister" name="registFood"><br>
        <label for="foodpict">食材写真：</label>
        <input type="file" id="foodpict" name="pict" accept="image/*"><br>
        <input type="hidden" name="_token" value="${_token}" />
        <button type="submit">登録</button>
    </form>
    <form method="GET" action="<%= request.getContextPath() %>/RegisterAllFood">
        <p>
            <input type="submit" value="登録食材一覧" class="button">
            <input type="hidden" name="_token" value="${_token}" />
        </p>
    </form>

</body>
</html>