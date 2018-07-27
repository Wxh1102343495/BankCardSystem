<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/first.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>首页</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-3">
				<%@ include file="left.jsp" %>
			</div>
			<div class="col-md-7">
				<div class="panel panel-default panel-primary">
					<div class="panel-heading">支出管理</div>
					<div class="panel-body">
						<form>
							<div class="form-group">
								<label>选择卡号:</label>
								<select id="select" style="width:200px;height:20px">
									
								</select>
							</div>
							<div class="form-group">
								<label>支取时间:</label>
								<input type="date" class="form-control" id="deltime" placeholder="请输入时间">
							</div>
							<div class="form-group">
								<label>支取金额:</label>
								<input type="text" class="form-control" id="delmoney" placeholder="请输入金额">
							</div>
							<button type="button" class="btn btn-primary" id="ok2">提交</button>
							<button type="button" class="btn btn-primary" id="no2">重置</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<!-- 模态框 -->
	<div class="modal fade" tabindex="-1" id="modal-error">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">提示</h4>
				</div>
				<div class="modal-body">
					<p>失败!</p>
				</div>	
			</div>
		</div>
	</div>
	<div class="modal fade" tabindex="-1" id="modal-success">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">提示</h4>
				</div>
				<div class="modal-body">
					<p>成功!</p>
				</div>	
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$.getJSON("LookCard.do",function(data){
				$.each(data,function(i,s){
					$("<option>"+s.CardId+"</option>").appendTo("#select");
				})
			})
			$("#ok2").click(function(){
				var delid=$("#select option:selected").val();
				var deltime=$("#deltime").val();
				var delmoney=$("#delmoney").val();
				if(delid!="" && deltime!="" && delmoney!=""){
					$.getJSON("DelMoney.do",{delid:delid,deltime:deltime,delmoney:delmoney},function(data){
						if(data){
							$('#modal-success').modal('show');
							$("#deltime").val("");
							$("#delmoney").val("");
							$("#tb").empty();
						}else{
							$('#modal-error').modal('show');
							$("#deltime").val("");
							$("#delmoney").val("");
						}
					})
				}else{
					$('#modal-error').modal('show');
					$("#deltime").val("");
					$("#delmoney").val("");
				}
			})
			
			//重置
			$("#no2").click(function(){
				$("#deltime").val("");
				$("#delmoney").val("");
			})
		})
	</script>
</body>
</html>
<%@ include file="foot.jsp" %>