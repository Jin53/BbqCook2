<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Top画面</title><section class="indexSection">…</section>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" media="all" href="css/Bbq.css">
</head>
<body>
    <div class="container">
        <div class="row">
           <h1 class="col-12">BBQ料理サーチシステム</h1>
               <img class="img-fluid img-thumbnail" src="https://cdn.pixabay.com/photo/2015/05/31/12/23/fool-791504_1280.jpg">
                    <div class="d-flex justify-content-center bd-highlight bd-highlight col-md">
                            <form action="<%=request.getContextPath()%>/UserLogin" method="get">
                                <input class="btn col-11 d-inline-block m-2 btn-success btn-lg" type="submit" value=ユーザーログイン>
                            </form>
                            <form action="<%=request.getContextPath()%>/Administrator" method="get">
                                 <input class="btn col-11 d-inline-block m-2 btn-primary btn-lg" type="submit" value=管理者ログイン>
                            </form>
                    </div>
        </div>
    </div>
</body>
</html>

<!-- role="toolbar"  class="buttonadmin" -->