<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<title>UserLogin</title>
<link rel="stylesheet" type="text/css" media="all" href="css/Bbq.css">
</head>
<body>
    <div class="container">
        <c:if test="${hasError}">
            <div id="flush_error">ユーザーIDかパスワードが間違っています。</div>
        </c:if>
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h1 class="col-12">BBQ料理<br class="d-md-none">サーチシステム</h1>
        <!--  <div class="center-block">-->
            <h2 class="col-12  text-center">ログイン画面</h2>
            <form method="POST" action="<c:url value='/UserLogin' />">
                <div class="mb-3 row">
                    <label for="staticEmail" class="col-3 offset-1 col-form-label">Email</label>
                    <div class="col-7">
                      <input type="text" class="form-control" id="staticEmail" name="mail">
                    </div>
                </div>
                <div class="mb-3 row">
                    <label for="inputPassword" class="col-3 offset-1 col-form-label">Password</label>
                    <div class="col-7">
                      <input type="password" class="form-control" id="inputPassword"  name="password">
                    </div>
                </div>
                <input type="hidden" name="_token" value="${_token}" />
                <button class="col-6 offset-3 btn btn-primary mt-2" type="submit">ログイン</button>
            </form>
        <!--  </div>-->
    </div>
</body>
</html>
