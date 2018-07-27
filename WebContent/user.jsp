<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>用户登录</title>
</head>
<body>
	<div class="container" style="margin-top: 60px;">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">用户登录</h3>
					</div>
					<div class="panel-body">
						<form>
			 				<div class="form-group">
			    				<label for="exampleInputEmail1">用户名:</label>
			    				<input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入用户名">
			  				</div>
			  				<div class="form-group">
			    				<label for="exampleInputPassword1">密码:</label>
			    				<input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码">
			  				</div>
			  				<button type="button" class="btn btn-primary">登录</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<div class="modal fade" tabindex="-1" id="modal-error">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">提示</h4>
				</div>
				<div class="modal-body">
					<p> 登录失败!</p>
				</div>	
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$(".btn").click(function(){
				var username=$("#exampleInputEmail1").val();
				var password=$("#exampleInputPassword1").val();
				if(username!="" && password!=""){
					$.getJSON("user.do",function(data){
						$.each(data,function(i,s){
							var usn=s.username;
							var pwd=s.password;
							if(username==usn && password==pwd){
								$(window).attr('location','/bank/first.jsp');
							}else{
								$('#modal-error').modal('show');
								$("#exampleInputEmail1").val("");
								$("#exampleInputPassword1").val("");
							}
						})
					})
				}else{
					$('#modal-error').modal('show');
					$("#exampleInputEmail1").val("");
					$("#exampleInputPassword1").val("");
				}
			})
		})
	</script>
</body>
</html>