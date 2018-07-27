<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/left.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>首页</title>
</head>
<body>
<div class="wrap">
	<div class="">
		<h5>银行卡管理:</h5>
		<ul class="nav nav-pills nav-stacked">
			<li role="presentation"><a href="CardRegist.jsp">银行卡注册</a></li>
			<li role="presentation"><a href="RemoveCard.jsp">银行卡销毁</a></li>
		</ul>
	</div>
	<div class="">
		<h5>交易管理:</h5>
		<ul class="nav nav-pills nav-stacked">
			<li role="presentation"><a href="SaveMoney.jsp">存入管理</a></li>
			<li role="presentation"><a href="GetMoney.jsp">支出管理</a></li>
		</ul>
	</div>
	<div class="">
		<h5>汇总查询:</h5>
		<ul class="nav nav-pills nav-stacked">
			<li role="presentation"><a href="LookJilu.jsp">交易记录查询</a></li>
			<li role="presentation"><a href="LookYue.jsp">账户余额查询</a></li>
		</ul>
	</div>
	<div class="">
		<h5>友情链接:</h5>
		<ul class="nav nav-pills nav-stacked">
			<li role="presentation"><a href="www.baidu.com">百度</a></li>
		</ul>
	</div>
</div>
</body>
</html>
