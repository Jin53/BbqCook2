<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/fileupload/Main" method="post" enctype="multipart/form-data">
        好きな写真:<input type="file" name="pict"><br>
        <button type="submit">送信</button>
    </form>
</body>
</html>