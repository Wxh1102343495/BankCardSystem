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
					<div class="panel-heading">银行卡注册</div>
					<div class="panel-body">
						<form>
							<div class="form-group">
								<label>卡号:</label>
								<input type="text" class="form-control" id="cardid" placeholder="请输入卡号">
							</div>
							<div class="form-group">
								<label>开户银行:</label>
								<input type="text" class="form-control" id="cardname" placeholder="请输入开户银行">
							</div>
							<div class="form-group">
								<label>初始金额:</label>
								<input type="text" class="form-control" id="cardmoney" placeholder="请输入初始金额">
							</div>
							<button type="button" class="btn btn-primary" id="zhuce">注册</button>
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
		//注册银行卡
		$("#zhuce").click(function(){
			var cardid=$("#cardid").val();
			var cardname=$("#cardname").val();
			var cardmoney=$("#cardmoney").val();
			if(cardid!="" && cardname!="" && cardmoney){
				$.post("CardRegister.do",{cardid:cardid,cardname:cardname,cardmoney:cardmoney},function(data){
					if(data){
						$('#modal-success').modal('show');
						$("#cardid").val("");
						$("#cardname").val("");
						$("#cardmoney").val("");
					}
				})
			}else{
				$('#modal-error').modal('show');
				$("#cardid").val("");
				$("#cardname").val("");
				$("#cardmoney").val("");
			}
		})
	})
	</script>
</body>
</html>
<%@ include file="foot.jsp" %>