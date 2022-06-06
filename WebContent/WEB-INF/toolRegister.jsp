<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>新規道具登録</title>
<link rel=stylesheet href="css/Bbq.css">
</head>
<body>
    <form method="POST" action="<%=request.getContextPath()%>/ToolRegister" enctype="multipart/form-data">
        <h1>新規道具登録</h1>
        <label for="toolRegister">登録道具： </label>
        <input type="text" id="toolRegister" name="registTool"><br>
        <label for="toolpict">道具写真： </label>
        <input type="file" id="toolpict" name="toolpict" accept="image/*"><br>
        <input type="hidden" name="_token" value="${_token}" />
        <button type="submit">登録</button>
    </form>
    <form method="GET"
        action="<%=request.getContextPath()%>/RegisterAllTool">
        <p>
            <input type="submit" value="登録道具一覧" class="button">
        </p>
        <input type="hidden" name="_token" value="${_token}" />
    </form>

</body>
</html>